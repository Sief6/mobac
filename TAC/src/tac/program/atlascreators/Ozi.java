package tac.program.atlascreators;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openstreetmap.gui.jmapviewer.interfaces.MapSource;

import tac.exceptions.MapCreationException;
import tac.mapsources.mapspace.MercatorPower2MapSpace;
import tac.program.interfaces.MapInterface;
import tac.utilities.Utilities;
import tac.utilities.imageio.PngXxlWriter;
import tac.utilities.tar.TarIndex;

public class Ozi extends TrekBuddy {

	protected File mapDir = null;
	protected String mapName = null;

	@Override
	public boolean testMapSource(MapSource mapSource) {
		return (mapSource.getMapSpace() instanceof MercatorPower2MapSpace);
	}

	@Override
	public void initializeMap(MapInterface map, TarIndex tarTileIndex) {
		super.initializeMap(map, tarTileIndex);
		mapDir = new File(atlasDir, map.getLayer().getName());
		mapName = map.getName();
	}

	public void createMap() throws MapCreationException {
		try {
			Utilities.mkDir(mapDir);
		} catch (IOException e1) {
			throw new MapCreationException(e1);
		}
		try {
			createTiles();
			writeMapFile();
		} catch (InterruptedException e) {
			// User has aborted process
			return;
		}
	}

	@Override
	protected void writeMapFile() {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(new File(mapDir, mapName + ".map"));
			writeMapFile(map.getName() + ".png", fout);
		} catch (Exception e) {
			log.error("", e);
		} finally {
			Utilities.closeStream(fout);
		}
	}

	/**
	 * Writes the large picture (tile) line by line. Each line has the full
	 * width of the map and the height of one tile (256 pixels).
	 */
	@Override
	protected void createTiles() throws InterruptedException {
		atlasProgress.initMapCreation((xMax - xMin + 1) * (yMax - yMin + 1));
		ImageIO.setUseCache(false);

		int width = (xMax - xMin + 1) * tileSize;
		int height = (yMax - yMin + 1) * tileSize;
		int tileLineHeight = tileSize;

		FileOutputStream fileOs = null;
		try {
			fileOs = new FileOutputStream(new File(mapDir, mapName + ".png"));
			PngXxlWriter pngWriter = new PngXxlWriter(width, height, fileOs);

			for (int y = yMin; y <= yMax; y++) {
				BufferedImage lineImage = new BufferedImage(width, tileLineHeight,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D graphics = lineImage.createGraphics();
				try {
					graphics.setColor(mapSource.getBackgroundColor());
					graphics.fillRect(0, 0, width, tileLineHeight);
					int lineX = 0;
					for (int x = xMin; x <= xMax; x++) {
						checkUserAbort();
						atlasProgress.incMapCreationProgress();
						try {
							BufferedImage tile = mapDlTileProvider.getTileImage(x, y);
							if (tile != null)
								graphics.drawImage(tile, lineX, 0, Color.WHITE, null);
						} catch (IOException e) {
							log.error("", e);
						}
						lineX += tileSize;
					}
				} finally {
					graphics.dispose();
				}
				pngWriter.writeTileLine(lineImage);
			}
			pngWriter.finish();
		} catch (IOException e) {
			log.error("", e);
		} finally {
			Utilities.closeStream(fileOs);
		}
	}
}