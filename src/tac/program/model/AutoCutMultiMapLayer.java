package tac.program.model;

import java.awt.Dimension;
import java.awt.Point;
import java.util.LinkedList;

import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;

import tac.program.interfaces.AtlasInterface;
import tac.program.interfaces.LayerInterface;
import tac.program.interfaces.MapInterface;
import tac.program.interfaces.ToolTipProvider;

/**
 * A layer holding one or multiple maps of the same map source and the same zoom
 * level. The number of maps depends on the size of the covered area - if it is
 * smaller than the specified <code>maxMapSize</code> then there will be only
 * one map.
 * 
 */
public class AutoCutMultiMapLayer implements LayerInterface, ToolTipProvider {

	private AtlasInterface atlas;

	private String name;
	private TileSource mapSource;
	private Point maxTileCoordinate;
	private Point minTileCoordinate;
	private int zoom;
	private Dimension tileSize;
	private Dimension maxMapDimension;

	private LinkedList<SubMap> maps = new LinkedList<SubMap>();

	public AutoCutMultiMapLayer(Atlas atlas, String name, TileSource mapSource, Point minTileCoordinate,
			Point maxTileCoordinate, int zoom, Dimension tileSize, int maxMapSize) {
		this.atlas = atlas;
		this.name = name;
		this.mapSource = mapSource;
		this.minTileCoordinate = minTileCoordinate;
		this.maxTileCoordinate = maxTileCoordinate;
		this.zoom = zoom;
		this.tileSize = tileSize;
		maxMapDimension = new Dimension(maxMapSize, maxMapSize);

		// We adapt the max map size to the tile size so that we do
		// not get ugly cutted/incomplete tiles at the borders
		maxMapDimension.width -= maxMapSize % tileSize.width;
		maxMapDimension.height -= maxMapSize % tileSize.height;
		calculateSubMaps();

		atlas.addLayer(this);
	}

	protected void calculateSubMaps() {
		int mapWidth = maxTileCoordinate.x - minTileCoordinate.x;
		int mapHeight = maxTileCoordinate.y - minTileCoordinate.y;
		maps.clear();
		if (mapWidth < maxMapDimension.width && mapHeight < maxMapDimension.height) {
			SubMap s = new SubMap(0, minTileCoordinate, maxTileCoordinate);
			maps.add(s);
			return;
		}
		int mapCounter = 0;
		for (int mapX = minTileCoordinate.x; mapX < maxTileCoordinate.x; mapX += maxMapDimension.width) {
			for (int mapY = minTileCoordinate.y; mapY < maxTileCoordinate.y; mapY += maxMapDimension.height) {
				Point min = new Point(mapX, mapY);
				Point max = new Point(mapX + maxMapDimension.width, mapY + maxMapDimension.height);
				SubMap s = new SubMap(mapCounter++, min, max);
				maps.add(s);
			}
		}
	}

	public AtlasInterface getAtlas() {
		return atlas;
	}

	public MapInterface getMap(int index) {
		return maps.get(index);
	}

	public int getMapCount() {
		return maps.size();
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getToolTip() {
		return "<html>" + "Map source: " + mapSource.getName() + "<br>" + "Zoom level: " + zoom
				+ "<br>" + "</html>";
	}

	protected class SubMap implements MapInterface, ToolTipProvider {

		private String name;
		private Point maxTileCoordinate;
		private Point minTileCoordinate;

		protected SubMap(int mapNum, Point minTileCoordinate, Point maxTileCoordinate) {
			super();
			this.maxTileCoordinate = maxTileCoordinate;
			this.minTileCoordinate = minTileCoordinate;
			name = String
					.format("%s-%02d", new Object[] { AutoCutMultiMapLayer.this.name, mapNum });
		}

		public LayerInterface getLayer() {
			return AutoCutMultiMapLayer.this;
		}

		public TileSource getMapSource() {
			return mapSource;
		}

		public Point getMaxTileCoordinate() {
			return maxTileCoordinate;
		}

		public Point getMinTileCoordinate() {
			return minTileCoordinate;
		}

		public String getName() {
			return name;
		}

		public Dimension getTileSize() {
			return tileSize;
		}

		public int getZoom() {
			return zoom;
		}

		@Override
		public String toString() {
			return getName();
		}

		public String getToolTip() {
			return "<html>Area start:<br>" + minTileCoordinate + "<br>" + maxTileCoordinate
					+ "</html>";
		}

	}
}
