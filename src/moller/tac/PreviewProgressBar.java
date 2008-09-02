package moller.tac;


// Importeringar
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JFrame;

// Klassdefinition
public class PreviewProgressBar extends JFrame{
		
	private static final long serialVersionUID = 4769464581926237949L;
	
	// Instansvariabler
	private JProgressBar progress;
	private JPanel background;

	private long initiateTime;
	private int elementsDoneInt;

	private JLabel title;
	private JLabel percent;
	private JLabel elementsDone;
	private JLabel timeLeft;

	// Konstruktor
	public PreviewProgressBar(int theMinimumValue, int theMaximumValue){
	//public ProgressBar(){

		// H�mta in sk�rmstorlek f�r att kunna positionera progressbarf�nstret h�r nedan
		Dimension	dScreen		= Toolkit.getDefaultToolkit().getScreenSize();
		Dimension	dContent 	= new Dimension(500,52);

		// S�tter storlek och position p� progressbarf�nstret. F�nstret hamnar centrerat p�
		// sk�rmen.
		this.setLocation((dScreen.width-dContent.width)/2,(dScreen.height-dContent.height)/2);
		this.setSize(dContent);

		// Skapar JPanel att l�gga alla nedanst�ende grafikobjekt p�.
		background = new JPanel(null);
		background.setBorder(BorderFactory.createRaisedBevelBorder());

		// Skapar JLabel f�r titel
		title = new JLabel("Downloading preview images:");
		title.setBounds(10,5,170,15);

		// Skapar JLabel f�r procent avklarat
		percent = new JLabel();
		percent.setBounds(180,5,120,15);

		// Skapar JLabel f�r avklarade objekt
		elementsDone = new JLabel();
		elementsDone.setBounds(225,5,185,15);

		// Skapar JLabel f�r �terst�ende tid
		timeLeft = new JLabel();
		timeLeft.setBounds(310,5,190,15);

		// Skapar progressbar
		progress = new JProgressBar(theMinimumValue, theMaximumValue);
		progress.setBounds(10,27,480,20);

		// L�gger alla grafikobjekt p� bakgrunden
		background.add(progress);
		background.add(title);
		background.add(percent);
		background.add(elementsDone);
		background.add(timeLeft);

		// L�gger bakgrunden p� ContentPane
		getContentPane().add(background);

		initiateTime = System.currentTimeMillis();

		this.setUndecorated(true);
  	}


	// Metod f�r att uppdatera alla f�lt och v�rden p� progressbaren.
	public void updateProgressBar(int theElementsDone){
		elementsDoneInt = theElementsDone;

		this.setCurrent();
		this.setTimeLeft();
	}


	// Hj�lpmetod f�r att s�tta till hur m�nga procent arbetet �r avklarat.
	private void setCurrent(){
		progress.invalidate();
		progress.setValue(elementsDoneInt);

		String stringPercent = Integer.toString(((int)(progress.getPercentComplete() * 100)));

		percent.setText("Percent done: " + stringPercent + " %");
	}

	// Hj�lpmetod f�r att visa hur m�nga sekunder det �terst�r innan arbetet �r utf�rt
	private void setTimeLeft(){
		// R�kna ut tiden det, i snitt, tar f�r att utf�ra en iteration i det som skall
		// utf�ras
		double timePerElement = (System.currentTimeMillis() - initiateTime) / elementsDoneInt;

		int secondsLeft = ((int)timePerElement * (progress.getMaximum() - elementsDoneInt) / 1000);
		String timeLeftString;
		
		timeLeftString = Integer.toString(secondsLeft) + " " + "seconds";
		
		timeLeft.setText("Time remaining: " + timeLeftString);
	}
}