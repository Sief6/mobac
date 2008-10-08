package tac.program;

import javax.swing.JCheckBox;

public class SelectedZoomLevels {
	private boolean[] zoomLevels;
	private int nrOfLayers;

	public SelectedZoomLevels(JCheckBox[] zoomCheckboxes) {
		this(zoomCheckboxes.length);
		for (int i = 0; i < zoomCheckboxes.length; i++) {
			if (zoomCheckboxes[i].isSelected())
				setZoomLevelSelected(i);
		}
	}

	public SelectedZoomLevels(int zommLevelCount) {
		zoomLevels = new boolean[zommLevelCount];
		for (int i = 0; i < zoomLevels.length; i++)
			zoomLevels[i] = false;
		nrOfLayers = 0;
	}

	public void setZoomLevelSelected(int zoomLevel) {
		zoomLevels[zoomLevel] = true;
		nrOfLayers++;
	}

	public int[] getZoomLevels() {
		int result[] = new int[nrOfLayers];
		int j = 0;
		for (int i = 0; i < zoomLevels.length; i++) {
			if (zoomLevels[i])
				result[j++] = i;
		}
		return result;
	}

	public int getNrOfLayers() {
		return nrOfLayers;
	}

}