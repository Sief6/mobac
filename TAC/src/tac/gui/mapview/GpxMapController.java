package tac.gui.mapview;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import javax.swing.JOptionPane;

import org.openstreetmap.gui.jmapviewer.JMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.OsmMercator;

import tac.data.gpx.gpx10.Gpx10;
import tac.data.gpx.gpx11.Gpx11;
import tac.data.gpx.interfaces.Gpx;
import tac.gui.panels.JGpxPanel.ListModelEntry;

public class GpxMapController extends JMapController implements MouseListener {

	private ListModelEntry entry;

	public GpxMapController(JMapViewer map, ListModelEntry entry, boolean enabled) {
		super(map, enabled);
		this.entry = entry;
	}

	public void mouseClicked(MouseEvent e) {
		// Add new GPX point to currently selected GPX file
		disable();
		if (e.getButton() == MouseEvent.BUTTON1) {
			Gpx gpx = entry.getLayer().getGpx();
			Point p = e.getPoint();
			Point tl = ((PreviewMap) map).getTopLeftCoordinate();
			p.x += tl.x;
			p.y += tl.y;
			double lon = OsmMercator.XToLon(p.x, map.getZoom());
			double lat = OsmMercator.YToLat(p.y, map.getZoom());
			String name = JOptionPane
					.showInputDialog(null, "Plase input a name for the new point:");
			if (name == null)
				return;
			if (gpx instanceof Gpx10) {
				Gpx10 gpx10 = (Gpx10) gpx;
				tac.data.gpx.gpx10.WptType wpt = new tac.data.gpx.gpx10.WptType();
				wpt.setName(name);
				wpt.setLat(new BigDecimal(lat));
				wpt.setLon(new BigDecimal(lon));
				gpx10.getWpt().add(wpt);
			}
			if (gpx instanceof Gpx11) {
				Gpx11 gpx11 = (Gpx11) gpx;
				tac.data.gpx.gpx11.WptType wpt = new tac.data.gpx.gpx11.WptType();
				wpt.setName(name);
				wpt.setLat(new BigDecimal(lat));
				wpt.setLon(new BigDecimal(lon));
				gpx11.getWpt().add(wpt);
			}
		}
		map.repaint();
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void disable() {
		super.disable();
		((PreviewMap) map).getMapSelectionController().enable();
	}

}
