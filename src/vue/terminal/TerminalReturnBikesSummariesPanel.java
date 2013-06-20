/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.BikeRentSummary;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnBikesSummariesPanel extends JPanel {

	private List<TerminalReturnBikeSummaryPanel> bikeSummaryPanels;

	public TerminalReturnBikesSummariesPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		this.initialize();
	}

	public TerminalReturnBikesSummariesPanel(LayoutManager lm) {
		super(lm);
		this.initialize();
	}

	public TerminalReturnBikesSummariesPanel(boolean bln) {
		super(bln);
		this.initialize();
	}

	public TerminalReturnBikesSummariesPanel() {
		this.initialize();


	}

	private void initialize() {
		this.bikeSummaryPanels = new ArrayList<>();
	}

	public void setSummary(List<BikeRentSummary> bikeRentSummaries) {
		GridBagLayout gbl;
		int[] rowHeights;
		double[] rowWeights;
		GridBagConstraints gbc;
		TerminalReturnBikeSummaryPanel bikeSummaryPanel;

		{//Remove old panels
			for (TerminalReturnBikeSummaryPanel panel : this.bikeSummaryPanels) {
				//From GUI
				this.remove(panel);
			}
			//From panel list
			this.bikeSummaryPanels.clear();
		}

		{//Add new Panels
			//One panel per line
			gbl = new GridBagLayout();
			{//Layout settings
				gbl.columnWidths = new int[]{0, 0};
				gbl.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				{//Rows
					rowHeights = new int[bikeRentSummaries.size() + 1];
					rowWeights = new double[bikeRentSummaries.size() + 1];
					for (int i = 0; i < bikeRentSummaries.size(); i++) {
						rowHeights[i] = 0;
						rowWeights[i] = 0.0;
					}
					rowHeights[bikeRentSummaries.size()] = 0;
					rowWeights[bikeRentSummaries.size()] = Double.MIN_VALUE;
					gbl.rowHeights = rowHeights;
					gbl.rowWeights = rowWeights;
				}
			}
			this.setLayout(gbl);
			//As many panels as bike summaries
			for (int i = 0; i < bikeRentSummaries.size(); i++) {
				bikeSummaryPanel = new TerminalReturnBikeSummaryPanel(bikeRentSummaries.get(i));
				{//Constraints
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, 0);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 0;
					gbc.gridy = i;
				}
				//Add to panel list
				this.add(bikeSummaryPanel, gbc);
				//Add to GUI
				this.bikeSummaryPanels.add(bikeSummaryPanel);
			}
		}

		this.validate();
	}


	private class TerminalReturnBikeSummaryPanel extends JPanel {

		BikeRentSummary summary;
		//Fields
		private JTextField txtInitialDuration;
		private JLabel lblInitialDurationUnit;
		private JTextField txtInitialAmount;
		private JTextField txtFinalDuration;
		private JLabel lblFinalDurationUnit;
		private JTextField txtFinalAmount;
		private JTextField txtToPayAmount;
		
		public TerminalReturnBikeSummaryPanel(BikeRentSummary summary, LayoutManager lm, boolean bln) {
			super(lm, bln);
			this.initialize(summary);
		}

		public TerminalReturnBikeSummaryPanel(BikeRentSummary summary, LayoutManager lm) {
			super(lm);
			this.initialize(summary);
		}

		public TerminalReturnBikeSummaryPanel(BikeRentSummary summary, boolean bln) {
			super(bln);
			this.initialize(summary);
		}

		public TerminalReturnBikeSummaryPanel(BikeRentSummary summary) {
			this.initialize(summary);
		}

		private void initialize(BikeRentSummary summary) {
			this.summary = summary;

			GridBagLayout gbl;
			GridBagConstraints gbc;

			gbl = new GridBagLayout();
			{
				gbl.columnWidths = new int[]{2 * TerminalMainFrame.ROW_HEIGHT, 0, 2 * TerminalMainFrame.ROW_HEIGHT, 0, 2 * TerminalMainFrame.ROW_HEIGHT, 0, 0, 0};
				gbl.rowHeights = new int[]{TerminalMainFrame.ROW_HEIGHT, TerminalMainFrame.ROW_HEIGHT, TerminalMainFrame.ROW_HEIGHT, 0};
				gbl.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			}
			this.setLayout(gbl);

			JLabel lblVeloN = new JLabel("Velo N\u00B0");
			{//position
				gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.HORIZONTAL;
				gbc.gridheight = 3;
				gbc.insets = new Insets(0, TerminalMainFrame.HORIZONTAL_GAP, 0, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.gridx = 0;
				gbc.gridy = 0;
			}
			this.add(lblVeloN, gbc);

			JLabel lblInitial = new JLabel("Pr\u00E9vu");
			{//Position
				gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.gridx = 1;
				gbc.gridy = 0;
			}
			this.add(lblInitial, gbc);

			txtInitialDuration = new JTextField();
			{
				txtInitialDuration.setEnabled(false);
				txtInitialDuration.setColumns(10);
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 1;
					gbc.gridy = 1;
				}
			}
			this.add(txtInitialDuration, gbc);

			this.lblInitialDurationUnit = new JLabel("");
			{//Position
				gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.WEST;
				gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.gridx = 2;
				gbc.gridy = 1;
			}
			this.add(this.lblInitialDurationUnit, gbc);

			txtInitialAmount = new JTextField();
			{
				txtInitialAmount.setEnabled(false);
				txtInitialAmount.setColumns(10);
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, 0, TerminalMainFrame.HORIZONTAL_GAP);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 1;
					gbc.gridy = 2;
				}
			}
			this.add(txtInitialAmount, gbc);

			JLabel lblInitialEuro = new JLabel("\u20AC");
			{//Position
				gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.WEST;
				gbc.insets = new Insets(0, 0, 0, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.gridx = 2;
				gbc.gridy = 2;
			}
			this.add(lblInitialEuro, gbc);

			JLabel lblFinal = new JLabel("R\u00E9el");
			{//Position
				gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.gridx = 3;
				gbc.gridy = 0;
			}
			this.add(lblFinal, gbc);

			txtFinalDuration = new JTextField();
			{
				txtFinalDuration.setEnabled(false);
				txtFinalDuration.setColumns(10);
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 3;
					gbc.gridy = 1;
				}
			}
			this.add(txtFinalDuration, gbc);

			this.lblFinalDurationUnit = new JLabel("");
			{//Position
				gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.WEST;
				gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.gridx = 4;
				gbc.gridy = 1;
			}
			add(this.lblFinalDurationUnit, gbc);

			txtFinalAmount = new JTextField();
			{
				txtFinalAmount.setEnabled(false);
				txtFinalAmount.setColumns(10);
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, 0, TerminalMainFrame.HORIZONTAL_GAP);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 3;
					gbc.gridy = 2;
				}
			}
			this.add(txtFinalAmount, gbc);

			JLabel lblFinalEuro = new JLabel("\u20AC");
			{//Position
				gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.WEST;
				gbc.insets = new Insets(0, 0, 0, TerminalMainFrame.HORIZONTAL_GAP);
				gbc.gridx = 4;
				gbc.gridy = 2;
			}
			this.add(lblFinalEuro, gbc);

			JLabel lblAPayer = new JLabel("A payer");
			{
				lblAPayer.setFont(new Font("Tahoma", Font.PLAIN, 9));
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, 0);
					gbc.anchor = GridBagConstraints.SOUTH;
					gbc.gridwidth = 2;
					gbc.gridx = 5;
					gbc.gridy = 1;
				}
			}
			this.add(lblAPayer, gbc);

			txtToPayAmount = new JTextField();
			{
				txtToPayAmount.setEnabled(false);
				txtToPayAmount.setColumns(10);
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, 0, TerminalMainFrame.HORIZONTAL_GAP);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 5;
					gbc.gridy = 2;
				}
			}
			this.add(txtToPayAmount, gbc);

			JLabel lblToPayEuro = new JLabel("\u20AC");
			{//Position
				gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.WEST;
				gbc.gridx = 6;
				gbc.gridy = 2;
			}
			this.add(lblToPayEuro, gbc);

			this.setValues();
		}

		private void setValues() {
			if (this.summary != null) {
				this.txtInitialDuration.setText("" + this.summary.getInitialDuration());
				this.lblInitialDurationUnit.setText(this.summary.getInitialDurationUnit());
				this.txtInitialAmount.setText("" + this.summary.getInitialAmount());
				this.txtFinalDuration.setText("" + this.summary.getFinalDuration());
				this.lblFinalDurationUnit.setText(this.summary.getFinalDurationUnit());
				this.txtFinalAmount.setText("" + this.summary.getFinalAmount());
				this.txtToPayAmount.setText("" + this.summary.getAmountToPay());
			}
		}
	}
}
