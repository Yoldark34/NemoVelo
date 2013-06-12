/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
class TerminalReturnBikesPanel extends JPanel {

	List<TerminalReturnBikePanel> bikePanels;

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
		bikePanels = new ArrayList<TerminalReturnBikePanel>();
	}

	public void setBikeQuantity(int quantity) {
		//TODO : Implement
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

			JLabel lblBikeNumber = new JLabel("Velo N\u00B0 de série : ");
			{//Position
				gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.VERTICAL;
				gbc.insets = new Insets(0, 5, 0, 5);
				gbc.anchor = GridBagConstraints.EAST;
				gbc.gridx = 0;
				gbc.gridy = 0;
			}
			this.add(lblBikeNumber, gbc);

			this.comboBikeSerialNumber = new JComboBox();
			{
				lblBikeNumber.setLabelFor(this.comboBikeSerialNumber);
				{//Position
					gbc = new GridBagConstraints();
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 1;
					gbc.gridy = 0;
				}
			}
			this.add(comboBikeSerialNumber, gbc);
		}

		public int getBikeSerialNumber() {
			int result;

			result = ((Integer) this.comboBikeSerialNumber.getSelectedItem()).intValue();

			return result;
		}
	}
}
