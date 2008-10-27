package tac.gui.preview;

import org.openstreetmap.gui.jmapviewer.OsmTileSource;
import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;

public class MapSources {

	private static TileSource[] MAP_SOURCES = { new MapSources.GoogleMaps(),
			new MapSources.GoogleEarth(), new MapSources.Mapnik(), new MapSources.TilesAtHome(),
			new MapSources.CycleMap() };

	public static TileSource[] getMapSources() {
		return MAP_SOURCES;
	}

	public static String getDefaultMapSourceName() {
		return getMapSources()[0].getName();
	}
	
	public static TileSource getSourceByName(String name) {
		for (TileSource t : MAP_SOURCES) {
			if (t.getName().equals(name))
				return t;
		}
		return MAP_SOURCES[0];
	}

	public static class GoogleMaps implements TileSource {

		public static final String SERVER_URL = "http://mt%d.google.com/mt?v=w2.86&hl=%s&x=%d&y=%d&z=%d";

		private static int SERVER_NUM = 0;

		public int getMaxZoom() {
			return 17;
		}

		public String getName() {
			return "Google Maps";
		}

		public TileUpdate getTileUpdate() {
			return TileUpdate.IfModifiedSince;
		}

		private int getNextServerNum() {
			int x = SERVER_NUM;
			SERVER_NUM = (SERVER_NUM + 1) % 4;
			return x;
		}

		public String getTileUrl(int zoom, int x, int y) {
			return String.format(SERVER_URL, new Object[] { getNextServerNum(), "de", x, y, zoom });
		}

		@Override
		public String toString() {
			return getName();
		}

		public String getTileType() {
			return "png";
		}

	}

	public static class GoogleEarth implements TileSource {

		public static final String SERVER_URL = "http://khm%d.google.com/kh/v=32&hl=%s&x=%d&y=%d&z=%d";

		private static int SERVER_NUM = 0;

		public int getMaxZoom() {
			return 20;
		}

		public String getName() {
			return "Google Earth";
		}

		public TileUpdate getTileUpdate() {
			return TileUpdate.IfModifiedSince;
		}

		private int getNextServerNum() {
			int x = SERVER_NUM;
			SERVER_NUM = (SERVER_NUM + 1) % 4;
			return x;
		}

		public String getTileUrl(int zoom, int x, int y) {
			return String.format(SERVER_URL, new Object[] { getNextServerNum(), "de", x, y, zoom });
		}

		@Override
		public String toString() {
			return getName();
		}

		public String getTileType() {
			return "jpg";
		}
	}

	public static class Mapnik extends OsmTileSource.Mapnik {

		@Override
		public String toString() {
			return "OpenStreetMap Mapnik";
		}

	}

	public static class TilesAtHome extends OsmTileSource.TilesAtHome {
		@Override
		public String toString() {
			return "OpenStreetMap Osmarenderer";
		}
	}

	public static class CycleMap extends OsmTileSource.CycleMap {
		@Override
		public String toString() {
			return "OpenStreetMap Cyclemap";
		}
	}

}
