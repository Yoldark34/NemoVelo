/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalReturnController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
class TerminalReturnBikesPanel extends JPanel {

	//Content
	private List<TerminalReturnBikePanel> bikePanels;
	private Vector<Integer> rentedBikeSerialNumbers;

	public TerminalReturnBikesPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		this.initialize();
	}

	public TerminalReturnBikesPanel(LayoutManager lm) {
		super(lm);
		this.initialize();
	}

	public TerminalReturnBikesPanel(boolean bln) {
		super(bln);
		this.initialize();
	}

	public TerminalReturnBikesPanel() {
		this.initialize();
	}

	private void initialize() {
		this.bikePanels = new ArrayList<>();
		this.rentedBikeSerialNumbers = new Vector<>();
	}

	public void setBikeQuantity(int quantity) {
		GridBagLayout gbl;
		int[] rowHeights;
		double[] rowWeights;
		GridBagConstraints gbc;
		TerminalReturnBikePanel bikePanel;

		{//Remove old panels
			for (TerminalReturnBikePanel panel : this.bikePanels) {
				//From GUI
				this.remove(panel);
			}
			//From panel list
			this.bikePanels.clear();
		}

		this.rentedBikeSerialNumbers.clear();
		this.rentedBikeSerialNumbers.addAll(TerminalReturnController.getTerminalReturnController().getRentedBikeSerialNumbers());
		
		{//Add new Panels
			//One panel per line
			gbl = new GridBagLayout();
			{//Layout settings
				gbl.columnWidths = new int[]{0, 0};
				gbl.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				{//Rows
					rowHeights = new int[quantity + 1];
					rowWeights = new double[quantity + 1];
					for (int i = 0; i < quantity; i++) {
						rowHeights[i] = TerminalMainFrame.ROW_HEIGHT;
						rowWeights[i] = 0.0;
					}
					rowHeights[quantity] = 0;
					rowWeights[quantity] = Double.MIN_VALUE;
					gbl.rowHeights = rowHeights;
					gbl.rowWeights = rowWeights;
				}
			}
			this.setLayout(gbl);
			//As many panels as specified quantity
			for (int i = 0; i < quantity; i++) {
				bikePanel = new TerminalReturnBikePanel(i);
				{//Constraints
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, 0);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 0;
					gbc.gridy = i;
				}
				//Add to panel list
				this.add(bikePanel, gbc);
				//Add to GUI
				this.bikePanels.add(bikePanel);
			}
		}

		this.validate();
	}

	public int getBikeQuantity() {
		return this.bikePanels.size();
	}

	public Set<Integer> getBikeSerialNumbers() {
		Set<Integer> result;
		result = new HashSet<>();
		for (TerminalReturnBikePanel bikePanel : this.bikePanels) {
			result.add(bikePanel.getBikeSerialNumber());
		}
		return result;
	}

	private class TerminalReturnBikePanel extends JPanel {

		private int bikeIndex;
		private JComboBox comboBikeSerialNumber;

		public TerminalReturnBikePanel(int bikeRank, LayoutManager lm, boolean bln) {
			super(lm, bln);
			this.initialize(bikeRank);
		}

		public TerminalReturnBikePanel(int bikeRank, LayoutManager lm) {
			super(lm);
			this.initialize(bikeRank);
		}

		public TerminalReturnBikePanel(int bikeRank, boolean bln) {
			super(bln);
			this.initialize(bikeRank);
		}

		public TerminalReturnBikePanel(int bikeRank) {
			this.initialize(bikeRank);
		}

		private void initialize(int bikeIndex) {
			GridBagConstraints gbc;

			this.bikeIndex = bikeIndex;

			GridBagLayout gbl = new GridBagLayout();
			{
				gbl.columnWidths = new int[]{0, 0, 0};
				gbl.rowHeights = new int[]{0, 0};
				gbl.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			}
			setLayout(gbl);

			JLabel lblBikeNumber = new JLabel("Vélo " + (this.bikeIndex + 1) + ", N\u00B0 de série : ");
			{//Position
				gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.VERTICAL;
				gbc.insets = new Insets(0, TerminalMainFrame.HORIZONTAL_GAP, 0, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.anchor = GridBagConstraints.EAST;
				gbc.gridx = 0;
				gbc.gridy = 0;
			}
			this.add(lblBikeNumber, gbc);

			this.comboBikeSerialNumber = new JComboBox();
			{
				lblBikeNumber.setLabelFor(this.comboBikeSerialNumber);
				this.comboBikeSerialNumber.setModel(new DefaultComboBoxModel(rentedBikeSerialNumbers));
				{//Position
					gbc = new GridBagConstraints();
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 1;
					gbc.gridy = 0;
				}
			}
			this.add(comboBikeSerialNumber, gbc);
		}

		public Integer getBikeSerialNumber() {
			Integer result;

			result = ((Integer) this.comboBikeSerialNumber.getSelectedItem());

			return result;
		}
	}
}
