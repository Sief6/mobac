package tac.program.model;

import java.awt.Dimension;
import java.awt.Point;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.swing.tree.TreeNode;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;

import org.apache.log4j.Logger;
import org.openstreetmap.gui.jmapviewer.Tile;
import org.openstreetmap.gui.jmapviewer.interfaces.MapSource;

import tac.exceptions.InvalidNameException;
import tac.program.DownloadJobEnumerator;
import tac.program.JobDispatcher.Job;
import tac.program.interfaces.CapabilityDeletable;
import tac.program.interfaces.CapabilityRenameable;
import tac.program.interfaces.DownloadJobListener;
import tac.program.interfaces.DownloadableElement;
import tac.program.interfaces.LayerInterface;
import tac.program.interfaces.MapInterface;
import tac.program.interfaces.ToolTipProvider;
import tac.tar.TarIndexedArchive;
import tac.utilities.MyMath;

public class Map implements MapInterface, ToolTipProvider, CapabilityDeletable,
		CapabilityRenameable, TreeNode, DownloadableElement {

	private String name;

	private Layer layer;

	private TileImageParameters parameters = null;

	@XmlAttribute
	private Point maxTileCoordinate = null;

	@XmlAttribute
	private Point minTileCoordinate = null;

	@XmlAttribute
	private MapSource mapSource = null;

	private Dimension tileDimension = null;

	@XmlAttribute
	private int zoom = -1;

	private static Logger log = Logger.getLogger(Map.class);

	protected Map() {
	}

	protected Map(Layer layer, String name, MapSource mapSource, int zoom, Point minTileCoordinate,
			Point maxTileCoordinate, TileImageParameters parameters) {
		this.layer = layer;
		this.maxTileCoordinate = maxTileCoordinate;
		this.minTileCoordinate = minTileCoordinate;
		this.name = name;
		this.mapSource = mapSource;
		this.zoom = zoom;
		this.parameters = parameters;
		calculateRuntimeValues();
	}

	protected void calculateRuntimeValues() {
		if (parameters == null)
			tileDimension = new Dimension(Tile.SIZE, Tile.SIZE);
		else
			tileDimension = new Dimension(parameters.width, parameters.height);
	}

	public LayerInterface getLayer() {
		return layer;
	}

	public MapSource getMapSource() {
		return mapSource;
	}

	public Point getMaxTileCoordinate() {
		return maxTileCoordinate;
	}

	public Point getMinTileCoordinate() {
		return minTileCoordinate;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public int getZoom() {
		return zoom;
	}

	@Override
	public String toString() {
		return getName();
	}

	public TileImageParameters getParameters() {
		return parameters;
	}

	public void setParameters(TileImageParameters parameters) {
		this.parameters = parameters;
	}

	public String getToolTip() {
		EastNorthCoordinate tl = new EastNorthCoordinate(zoom, minTileCoordinate.x,
				minTileCoordinate.y);
		EastNorthCoordinate br = new EastNorthCoordinate(zoom, maxTileCoordinate.x,
				maxTileCoordinate.y);

		StringWriter sw = new StringWriter(1024);
		sw.write("<html>");
		sw.write("<b>Map area</b><br>");
		sw.write("Map source: " + mapSource.getName() + "<br>");
		sw.write("Zoom level: " + zoom + "<br>");
		sw.write("Area start: " + tl + " (" + minTileCoordinate.x + " / " + minTileCoordinate.y
				+ ")<br>");
		sw.write("Area end: " + br + " (" + maxTileCoordinate.x + " / " + maxTileCoordinate.y
				+ ")<br>");
		sw.write("Map size: " + (maxTileCoordinate.x - minTileCoordinate.x + 1) + "x"
				+ (maxTileCoordinate.y - minTileCoordinate.y + 1) + " pixel<br>");
		if (parameters != null) {
			sw.write("Tile size: " + parameters.width + "x" + parameters.height + "<br>");
			sw.write("Tile format: " + parameters.format + "<br>");
		} else
			sw.write("Tile size: 256x256 (no processing)<br>");
		sw.write("Maximum tiles to download: " + calculateTilesToDownload() + "<br>");
		sw.write("</html>");
		return sw.toString();
	}

	public Dimension getTileSize() {
		return tileDimension;
	}

	public void delete() {
		layer.deleteMap(this);
	}

	public void setName(String newName) throws InvalidNameException {
		if (layer != null) {
			for (MapInterface map : layer) {
				if ((map != this) && (newName.equals(map.getName())))
					throw new InvalidNameException("There is already a map named \"" + newName
							+ "\" in this layer.\nMap names have to unique within an layer.");
			}
		}
		this.name = newName;
	}

	public Enumeration<?> children() {
		return null;
	}

	public boolean getAllowsChildren() {
		return false;
	}

	public TreeNode getChildAt(int childIndex) {
		return null;
	}

	public int getChildCount() {
		return 0;
	}

	public int getIndex(TreeNode node) {
		return 0;
	}

	public TreeNode getParent() {
		return (TreeNode) layer;
	}

	public boolean isLeaf() {
		return true;
	}

	public int calculateTilesToDownload() {
		int width = MyMath.divCeil((maxTileCoordinate.x - minTileCoordinate.x) + 1, Tile.SIZE);
		int height = MyMath.divCeil((maxTileCoordinate.y - minTileCoordinate.y) + 1, Tile.SIZE);
		return width * height;
	}

	public boolean checkData() {
		log.debug("Checking data: map \"" + name + "\"");
		if (name == null || layer == null || maxTileCoordinate == null || minTileCoordinate == null
				|| mapSource == null || parameters == null || zoom < 0)
			return true;
		return false;
	}

	public void afterUnmarshal(Unmarshaller u, Object parent) {
		this.layer = (Layer) parent;
		calculateRuntimeValues();
	}

	public Enumeration<Job> getDownloadJobs(TarIndexedArchive tileArchive,
			DownloadJobListener listener) {
		return new DownloadJobEnumerator(this, tileArchive, listener);
	}

}
