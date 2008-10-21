package tac.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.openstreetmap.gui.jmapviewer.interfaces.TileSource;

import tac.gui.preview.MapSources;
import tac.program.Settings;
import tac.program.TileStore;

public class SettingsGUI extends JDialog {
	private static final long serialVersionUID = -5227934684609357198L;

	private JCheckBox tileStoreEnabled;

	private JComboBox mapSize;

	private JTextField proxyHost;
	private JTextField proxyPort;

	private JButton okButton;
	private JButton cancelButton;

	private JTabbedPane tabbedPane;

	private Vector<MapSize> mapSizes;

	public SettingsGUI(JFrame owner) {
		super(owner);
		setModal(true);
		this.createJFrame();
		this.createTabbedPane();
		this.createJButtons();
		this.loadSettings();
		this.addListeners();
	}

	private void createJFrame() {
		Dimension dScreen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension dContent = new Dimension(500, 342);

		this.setLocation((dScreen.width - dContent.width) / 2,
				(dScreen.height - dContent.height) / 2);
		this.setSize(dContent);
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		this.setTitle("Settings");
	}

	// Create tabbed pane
	public void createTabbedPane() {
		tabbedPane = new JTabbedPane();
		tabbedPane.setBounds(0, 0, 492, 275);
		tabbedPane.add(createTileStorePanel(), "Tile store");
		tabbedPane.add(createMapSizePanel(), "Map size");
		tabbedPane.add(createNetworkPanel(), "Network");

		this.getContentPane().add(tabbedPane);
	}

	private JPanel createTileStorePanel() {

		tileStoreEnabled = new JCheckBox("Enable tile store");
		tileStoreEnabled.setBounds(7, 40, 120, 15);

		JPanel leftPanel = new JPanel(null);
		leftPanel.setBounds(5, 5, 300, 240);
		leftPanel.setBorder(BorderFactory.createTitledBorder("Tile store settings"));

		TileSource[] sources = MapSources.getMapSources();

		int rows = sources.length;

		JPanel rightPanel = new JPanel(new GridLayout(rows, 2));
		rightPanel.setBounds(303, 5, 172, 240);
		rightPanel.setBorder(BorderFactory.createTitledBorder("Information"));

		leftPanel.add(tileStoreEnabled);

		TileStore tileStore = TileStore.getInstance();

		for (TileSource ts : MapSources.getMapSources()) {

			rightPanel.add(new JLabel(ts.getName()));
			rightPanel.add(new JLabel(Integer.toString(tileStore.getNrOfTiles(ts))));

		}

		JPanel backGround = new JPanel(null);
		backGround.add(leftPanel);
		backGround.add(rightPanel);

		return backGround;
	}

	private JPanel createMapSizePanel() {

		// Sizes from 512 to 4096
		mapSizes = new Vector<MapSize>(10);
		int valueToAdd = 512;
		for (int i = 0; i < 8; i++) {
			mapSizes.addElement(new MapSize(valueToAdd));
			valueToAdd *= 2;
		}
		mapSizes.addElement(new MapSize(0));

		mapSize = new JComboBox(mapSizes);
		mapSize.setBounds(7, 40, 120, 20);

		JLabel mapSizeLabel = new JLabel("<html>If the image of the selected region to download "
				+ "is larger in height or width than the mapsize it will be splitted into "
				+ "several maps that are no larger than the selected mapsize.</html>");
		mapSizeLabel.setBounds(150, 5, 300, 100);

		JPanel leftPanel = new JPanel(null);
		leftPanel.setBounds(5, 5, 475, 240);
		leftPanel.setBorder(BorderFactory.createTitledBorder("Map size settings"));

		leftPanel.add(mapSize);
		leftPanel.add(mapSizeLabel);

		JPanel thumbNailBackGround = new JPanel(null);
		thumbNailBackGround.add(leftPanel);

		return thumbNailBackGround;
	}

	private JPanel createNetworkPanel() {
		JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
		panel.setBorder(BorderFactory.createTitledBorder("HTTP Proxy"));
		JLabel proxyHostLabel = new JLabel("Proxy host name: ");
		proxyHost = new JTextField(System.getProperty("http.proxyHost"));
		JLabel proxyPortLabel = new JLabel("Proxy port: ");
		proxyPort = new JTextField(System.getProperty("http.proxyPort"));
		panel.add(proxyHostLabel);
		panel.add(proxyHost);
		panel.add(proxyPortLabel);
		panel.add(proxyPort);
		JPanel p = new JPanel(new BorderLayout());
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.add(panel, BorderLayout.NORTH);
		return p;
	}

	public void createJButtons() {
		okButton = new JButton("Ok");
		okButton.setBounds(364, 280, 50, 25);

		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(418, 280, 74, 25);

		this.getContentPane().add(okButton);
		this.getContentPane().add(cancelButton);
	}

	private void loadSettings() {
		Settings s = Settings.getInstance();

		tileStoreEnabled.setSelected(s.isTileStoreEnabled());

		int size = s.getMaxMapsSize();
		int index = mapSizes.indexOf(new MapSize(size));
		if (index < 0)
			index = 0;
		mapSize.setSelectedIndex(index);
	}

	private void applySettings() {
		Settings s = Settings.getInstance();

		s.setTileStoreEnabled(tileStoreEnabled.isSelected());

		int size = ((MapSize) mapSize.getSelectedItem()).getMapSize();
		s.setMaxMapSize(size);

		System.setProperty("http.proxyHost", proxyHost.getText());
		System.setProperty("http.proxyPort", proxyPort.getText());

		// Close the dialog window
		SettingsGUI.this.dispose();
	}

	private void addListeners() {

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				applySettings();
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettingsGUI.this.dispose();
			}
		});
	}

	private static class MapSize implements Comparable<MapSize> {

		private int mapSize;

		public MapSize(int mapSize) {
			super();
			this.mapSize = mapSize;
		}

		@Override
		public String toString() {
			if (mapSize == 0)
				return "Unlimited";
			return Integer.toString(mapSize);
		}

		public int getMapSize() {
			return mapSize;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof MapSize)
				return ((MapSize) obj).mapSize == mapSize;
			return false;
		}

		public int compareTo(MapSize o) {
			return new Integer(mapSize).compareTo(o.mapSize);
		}

	}
}