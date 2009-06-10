package tac.gui.panels;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tac.gui.components.JCoordinateField;
import tac.program.MapSelection;
import tac.program.model.EastNorthCoordinate;
import tac.utilities.GBC;

/**
 * Encapsulates all interface components and code for the panel that shows the
 * coordinates of the current selection and allows the user to enter own
 * coordinates.
 */
public class JCoordinatesPanel extends JPanel {

	private JCoordinateField latMinTextField;
	private JCoordinateField latMaxTextField;
	private JCoordinateField lonMinTextField;
	private JCoordinateField lonMaxTextField;
	private JButton displaySelectionButton;

	public JCoordinatesPanel() {
		super(new GridBagLayout());

		setBorder(BorderFactory.createTitledBorder("Selection coordinates (min/max)"));

		// coordinates panel
		latMaxTextField = new JCoordinateField(MapSelection.LAT_MIN, MapSelection.LAT_MAX, true);
		latMaxTextField.setActionCommand("latMaxTextField");
		lonMinTextField = new JCoordinateField(MapSelection.LON_MIN, MapSelection.LON_MAX, false);
		lonMinTextField.setActionCommand("longMinTextField");
		lonMaxTextField = new JCoordinateField(MapSelection.LON_MIN, MapSelection.LON_MAX, true);
		lonMaxTextField.setActionCommand("longMaxTextField");
		latMinTextField = new JCoordinateField(MapSelection.LAT_MIN, MapSelection.LAT_MAX, false);
		latMinTextField.setActionCommand("latMinTextField");

		displaySelectionButton = new JButton("Display selection");

		JLabel latMaxLabel = new JLabel("N ", JLabel.CENTER);
		JLabel lonMinLabel = new JLabel("W ", JLabel.CENTER);
		JLabel lonMaxLabel = new JLabel("E ", JLabel.CENTER);
		JLabel latMinLabel = new JLabel("S ", JLabel.CENTER);

		add(Box.createHorizontalGlue(), GBC.std().fill(GBC.HORIZONTAL));
		add(latMaxLabel);
		add(latMaxTextField);
		add(Box.createHorizontalGlue(), GBC.eol().fill(GBC.HORIZONTAL));

		JPanel eastWestPanel = new JPanel(new GridBagLayout());
		eastWestPanel.add(lonMinLabel);
		eastWestPanel.add(lonMinTextField);
		eastWestPanel.add(lonMaxLabel, GBC.std().insets(10, 0, 0, 0));
		eastWestPanel.add(lonMaxTextField);
		add(eastWestPanel, GBC.eol().fill().insets(0, 5, 0, 5));

		add(Box.createHorizontalGlue(), GBC.std().fill(GBC.HORIZONTAL));
		add(latMinLabel);
		add(latMinTextField);
		add(Box.createHorizontalGlue(), GBC.eol().fill(GBC.HORIZONTAL));

		add(displaySelectionButton, GBC.eol().anchor(GBC.CENTER).insets(0, 5, 0, 0));

	}

	public void setMaxCoordinate(EastNorthCoordinate coordinate) {
		latMaxTextField.setCoordinate(coordinate.lat);
		lonMaxTextField.setCoordinate(coordinate.lon);
	}

	public void setMinCoordinate(EastNorthCoordinate coordinate) {
		latMinTextField.setCoordinate(coordinate.lat);
		lonMinTextField.setCoordinate(coordinate.lon);
	}

	public EastNorthCoordinate getMaxCoordinate() {
		return new EastNorthCoordinate(latMaxTextField.getCoordinateOrNaN(), lonMaxTextField
				.getCoordinateOrNaN());
	}

	public EastNorthCoordinate getMinCoordinate() {
		return new EastNorthCoordinate(latMinTextField.getCoordinateOrNaN(), lonMinTextField
				.getCoordinateOrNaN());
	}

	public void addButtonActionListener(ActionListener l) {
		displaySelectionButton.addActionListener(l);
	}

	public String getValidationErrorMessages() {
		String errorText = new String();
		if (!lonMinTextField.isInputValid())
			errorText += "Value of \"Longitude Min\" must be between -179 and 179. \n";

		if (!lonMaxTextField.isInputValid())
			errorText += "Value of \"Longitude Max\" must be between -179 and 179. \n";

		if (!latMaxTextField.isInputValid())
			errorText += "Value of \"Latitude Max\" must be between -85 and 85. \n";

		if (!latMinTextField.isInputValid())
			errorText += "Value of \"Latitude Min\" must be between -85 and 85. \n";
		return errorText;
	}
}
