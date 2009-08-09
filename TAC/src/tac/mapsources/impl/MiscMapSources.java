package tac.mapsources.impl;


import tac.mapsources.AbstractMapSource;

public class MiscMapSources {
	
	/**
	 * Map from Multimap.com - incomplete for high zoom levels Uses Quad-Tree
	 * coordinate notation?
	 */
	public static class MultimapCom extends AbstractMapSource {

		public MultimapCom() {
			// zoom level supported:
			// 0 (fixed url) world.png
			// 1-5 "mergend binary encoding"
			// 6-? uses MS MAP tiles at some parts of the world
			super("Multimap.com", 1, 17, "png");
		}

		public String getTileUrl(int zoom, int tilex, int tiley) {

			int z = zoom + 1;
			// binary encoding using ones for tilex and twos for tiley.
			// if a bit is set in tilex and tiley we get a three
			char[] num = new char[zoom];
			for (int i = zoom - 1; i >= 0; i--) {
				int n = 0;
				if ((tilex & 1) == 1)
					n += 1;
				if ((tiley & 1) == 1)
					n += 2;
				num[i] = Integer.toString(n).charAt(0);
				tilex >>= 1;
				tiley >>= 1;
			}
			String s = new String(num);
			if (s.length() > 12)
				s = s.substring(0, 6) + "/" + s.substring(6, 12) + "/" + s.substring(12);
			else if (s.length() > 6)
				s = s.substring(0, 6) + "/" + s.substring(6);

			String base;
			if (zoom < 6)
				base = "http://mc1.tiles-cdn.multimap.com/ptiles/map/mi915/";
			else if (zoom < 14)
				base = "http://mc2.tiles-cdn.multimap.com/ptiles/map/mi917/";
			else
				base = "http://mc3.tiles-cdn.multimap.com/ptiles/map/mi931/";
			s = base + z + "/" + s + ".png?client=public_api&service_seq=14458";
			return s;
		}
	}

	public static class YahooMaps extends AbstractMapSource {

		public YahooMaps() {
			super("Yahoo Maps", 1, 16, "jpg");
			tileUpdate = TileUpdate.IfModifiedSince;
		}

		public String getTileUrl(int zoom, int tilex, int tiley) {
			int yahooTileY = (((1 << zoom) - 2) / 2) - tiley;
			int yahooZoom = getMaxZoom() - zoom + 2;
			return "http://maps.yimg.com/hw/tile?locale=en&imgtype=png&yimgv=1.2&v=4.1&x=" + tilex
					+ "&y=" + yahooTileY + "+6163&z=" + yahooZoom;
		}

	}

}
