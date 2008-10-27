package tac.program;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

/**
 * Controls the worker threads that are downloading the map tiles in parallel.
 * Additionally the job queue containing the unprocessed tile download jobs can
 * be accessed via this class.
 */
public class JobDispatcher {

	private static Logger log = Logger.getLogger(JobDispatcher.class);

	protected WorkerThread[] workers;

	protected BlockingQueue<Job> jobQueue = new LinkedBlockingQueue<Job>();

	public JobDispatcher(int threadCount) {
		workers = new WorkerThread[threadCount];
		for (int i = 0; i < threadCount; i++)
			workers[i] = new WorkerThread(i);
	}

	@Override
	protected void finalize() throws Throwable {
		terminateAllWorkerThreads();
		super.finalize();
	}

	public void terminateAllWorkerThreads() {
		cancelOutstandingJobs();
		log.trace("Killing all worker threads");
		for (int i = 0; i < workers.length; i++) {
			try {
				WorkerThread w = workers[i];
				if (w != null) {
					w.interrupt();
				}
				workers[i] = null;
			} catch (Exception e) {
				// We don't care about exception here
			}
		}
	}

	public void cancelOutstandingJobs() {
		jobQueue.clear();
	}

	/**
	 * Blocks if more than 100 jobs are already scheduled.
	 * 
	 * @param job
	 * @throws InterruptedException
	 */
	public void addJob(Job job) throws InterruptedException {
		while (jobQueue.size() > 100) {
			Thread.sleep(200);
		}
		jobQueue.put(job);
	}

	/**
	 * Adds the job to the job-queue and returns. This method will never block!
	 * 
	 * @param job
	 */
	public void addErrorJob(Job job) {
		try {
			jobQueue.put(job);
		} catch (InterruptedException e) {
			// Can never happen with LinkedBlockingQueue
		}
	}

	public int getWaitingJobCount() {
		return jobQueue.size();
	}

	protected static interface Job {
		public void run() throws Exception;
	}

	/**
	 * Each worker thread takes the first job from the job queue and executes
	 * it. If the queue is empty the worker blocks, waiting for the next
	 * job.
	 */
	protected class WorkerThread extends Thread {

		Job job;

		private Logger log = Logger.getLogger(WorkerThread.class);

		public WorkerThread(int threadNum) {
			super("WorkerThread " + threadNum);
			setDaemon(true);
			job = null;
			start();
		}

		@Override
		public void run() {
			executeJobs();
			log.debug("Thread is terminating");
		}

		protected void executeJobs() {
			while (!isInterrupted()) {
				try {
					job = jobQueue.take();
				} catch (InterruptedException e1) {
					return;
				}
				if (job == null)
					return;
				try {
					job.run();
					job = null;
				} catch (Exception e) {
					if (e instanceof InterruptedException)
						return;
					log.error("Unknown error occured while executing the job: ", e);
				}
			}
		}
	}

}