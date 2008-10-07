package tac.program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;

import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;

public class TileDownLoader {

	public static final String SECURESTRING = "Galileo";

	public static boolean getImage(int x, int y, int zoom, File destinationDirectory,
			TileSource tileSource, boolean isAtlasDownload) throws IOException {

		if (x == 0 || y == 0)
			return false;
		TileStore ts = TileStore.getInstance();

		/**
		 * If the desired tile already exist in the persistent tilestore and
		 * settings is to use the tile store
		 */
		Settings s = Settings.getInstance();
		File destFile = new File(destinationDirectory + "/y" + y + "x" + x + ".png");

		if (s.isTileStoreEnabled()) {

			// Copy the file from the persistent tilestore instead of
			// downloading it from internet.
			try {
				if (ts.copyStoredTileTo(destFile, x, y, zoom, tileSource))
					return true;
			} catch (IOException e) {
			}
		}

		String url = tileSource.getTileUrl(zoom, x, y);

		System.out.println("Downloading "+url);
		URL u = new URL(url);
		HttpURLConnection huc = (HttpURLConnection) u.openConnection();

		huc.setRequestMethod("GET");
		huc.connect();

		InputStream is = huc.getInputStream();
		int code = huc.getResponseCode();

		File output;
		if (code != HttpURLConnection.HTTP_OK)
			throw new IOException("Invaild HTTP response: " + code);

		byte[] buffer = new byte[4096];
		output = new File(destinationDirectory,"y" + y
				+ "x" + x + ".png");
		FileOutputStream outputStream = new FileOutputStream(output);

		int bytes = 0;
		int sumBytes = 0;

		if (isAtlasDownload) {
			ProcessValues.setNrOfDownloadedBytes(ProcessValues.getNrOfDownloadedBytes()
					+ (double) huc.getContentLength());
		}

		while ((bytes = is.read(buffer)) > 0) {
			sumBytes += bytes;
			outputStream.write(buffer, 0, bytes);
		}
		outputStream.close();
		huc.disconnect();

		if (s.isTileStoreEnabled()) {

			// Copy the file from the download folder to the persistent
			// tilestore folder
			File tileStoreFile = ts.getTileFile(x, y, zoom, tileSource);

			FileChannel source = null;
			FileChannel destination = null;
			try {
				source = new FileInputStream(destFile).getChannel();
				destination = new FileOutputStream(tileStoreFile).getChannel();
				destination.transferFrom(source, 0, source.size());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				if (source != null) {
					source.close();
				}
				if (destination != null) {
					destination.close();
				}
			}
		}
		return true;
	}

}