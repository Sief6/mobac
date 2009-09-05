package tac.gui.mapview;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import org.openstreetmap.gui.jmapviewer.interfaces.MapSpace;

import tac.program.model.UnitSystem;
import tac.utilities.MyMath;

/**
 * Simple scale bar showing the map scale using the selected unit system.
 */
public class ScaleBar {

	/**
	 * Horizontal margin between scale bar and right border of the map
	 */
	private static final int MARGIN_X = 40;

	/**
	 * Vertical margin between scale bar and bottom border of the map
	 */
	private static final int MARGIN_Y = 40;

	private static final int DESIRED_SCALE_BAR_WIDTH = 150;

	public static UnitSystem unitSystem = UnitSystem.Metric;

	public static void paintScaleBar(Graphics g, MapSpace mapSpace, Point tlc, int zoom) {
		Rectangle r = g.getClipBounds();
		int posX;
		int posY = r.height - r.y;
		posY -= MARGIN_Y;
		posX = MARGIN_X;

		// int coordX = tlc.x + posX;
		int coordY = tlc.y + posY;

		int w1 = DESIRED_SCALE_BAR_WIDTH;

		// Calculate the angular distance of our desired scale bar
		double ad = mapSpace.horizontalDistance(zoom, coordY, w1);

		String unit = unitSystem.unitLarge;
		// convert angular into the selected unit system
		double dist1 = ad * unitSystem.earthRadius;
		// distance is smaller that one (km/mi)? the use smaller units (m/ft)
		if (dist1 < 1.0) {
			dist1 *= unitSystem.unitFactor;
			unit = unitSystem.unitSmall;
		}
		// Round everything to a nice value
		double dist2 = MyMath.prettyRound(dist1);
		double factor = dist2 / dist1;
		// apply the round factor to the width of our scale bar
		int w2 = (int) (w1 * factor);

		g.setColor(Color.YELLOW);
		g.fillRect(posX, posY - 10, w2, 20);
		g.setColor(Color.BLACK);
		g.drawRect(posX, posY - 10, w2, 20);
		String value = Integer.toString((int) dist2) + " " + unit;
		g.drawString(value, posX + 10, posY + 4);
	}

}