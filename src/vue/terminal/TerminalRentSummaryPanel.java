/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.data.RentSummary;
import controller.terminal.controller.TerminalRentSummaryController;
import controller.terminal.interfacesGUI.TerminalRentSummary;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentSummaryPanel extends AbstractTerminalPanel implements TerminalRentSummary {

	//Content
	private JTextField textDuration;
	private JTextField textPricePerBike;
	private JTextField textQuantity;
	private JTextField textRentPrice;
	private JTextField textGuarantee;
	private JTextField textFinalPrice;
	//Actions
	private JButton btnPay;

	public TerminalRentSummaryPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalRentSummaryPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalRentSummaryPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalRentSummaryPanel() {
		initialize();
	}

	private void initialize() {
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc;

		{//Content
			gbl.columnWidths = new int[]{0, 42, 0, 0, 0, 0, 0};
			//The white space have at least the specified row height
			gbl.rowHeights = new int[]{0, 0, 0, TerminalMainFrame.ROW_HEIGHT, 0, 0, TerminalMainFrame.ROW_HEIGHT, 0, 0, 0};
			gbl.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			this.getPanelContent().setLayout(gbl);

			{//Per bike sum up
				this.textDuration = new JTextField();
				{
					this.textDuration.setColumns(10);
					this.textDuration.setEditable(false);
					{//Position
						gbc = new GridBagConstraints();
						gbc.gridwidth = 2;
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridx = 1;
						gbc.gridy = 1;
					}
				}
				this.getPanelContent().add(this.textDuration, gbc);

				this.textPricePerBike = new JTextField();
				{
					this.textPricePerBike.setColumns(10);
					this.textPricePerBike.setEditable(false);
					{//Position
						gbc = new GridBagConstraints();
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridx = 3;
						gbc.gridy = 1;
					}
				}
				this.getPanelContent().add(this.textPricePerBike, gbc);


				JLabel lblVelo = new JLabel("\u20AC / v\u00E9lo");
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
					gbc.gridx = 4;
					gbc.gridy = 1;
				}
				this.getPanelContent().add(lblVelo, gbc);
			}//Per bike sum up

			{//Quantity of bikestextQuantity = new JTextField();
				this.textQuantity = new JTextField();
				{
					this.textQuantity.setColumns(10);
					this.textQuantity.setEditable(false);
					{//Position
						gbc = new GridBagConstraints();
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridx = 3;
						gbc.gridy = 2;
					}
				}
				this.getPanelContent().add(this.textQuantity, gbc);
				

				JLabel lblQuantity = new JLabel("Quantit\u00E9");
				{
					lblQuantity.setLabelFor(this.textQuantity);
					{//Position
						gbc = new GridBagConstraints();
						gbc.gridwidth = 2;
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.anchor = GridBagConstraints.EAST;
						gbc.gridx = 1;
						gbc.gridy = 2;
					}
				}
				this.getPanelContent().add(lblQuantity, gbc);
			}//Quantity of bikes
			
			{//Price of rental
				this.textRentPrice = new JTextField();
				{
					this.textRentPrice.setEditable(false);
					this.textRentPrice.setColumns(10);
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.gridx = 3;
					gbc.gridy = 4;
					}
				}
				this.getPanelContent().add(this.textRentPrice, gbc);

				JLabel lblRentPrice = new JLabel("Location");
				{
					lblRentPrice.setLabelFor(this.textRentPrice);
					{//Position
						gbc = new GridBagConstraints();
						gbc.gridwidth = 2;
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.anchor = GridBagConstraints.EAST;
						gbc.gridx = 1;
						gbc.gridy = 4;
					}
				}
				this.getPanelContent().add(lblRentPrice, gbc);
			}//Price of rental

			{//Price of guarantee
				this.textGuarantee = new JTextField();
				{
					this.textGuarantee.setEditable(false);
					this.textGuarantee.setColumns(10);
					{//Position
						gbc = new GridBagConstraints();
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridx = 3;
						gbc.gridy = 5;
					}
				}
				this.getPanelContent().add(this.textGuarantee, gbc);

				JLabel lblGuarantee = new JLabel("Caution");
				{
					lblGuarantee.setLabelFor(this.textGuarantee);
					{//Position
						gbc = new GridBagConstraints();
						gbc.gridwidth = 2;
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.anchor = GridBagConstraints.EAST;
						gbc.gridx = 1;
						gbc.gridy = 5;
					}
				}
				this.getPanelContent().add(lblGuarantee, gbc);
			}//Price of guarantee

			{//End price
				this.textFinalPrice = new JTextField();
				{
					this.textFinalPrice.setEditable(false);
					this.textFinalPrice.setColumns(10);
					{//Position
						gbc = new GridBagConstraints();
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.fill = GridBagConstraints.HORIZONTAL;
						gbc.gridx = 3;
						gbc.gridy = 7;
					}
				}
				this.getPanelContent().add(this.textFinalPrice, gbc);

				JLabel lblPrice = new JLabel("Total");
				{
				lblPrice.setLabelFor(this.textFinalPrice);
					{//Position
						gbc = new GridBagConstraints();
						gbc.gridwidth = 2;
						gbc.insets = new Insets(0, 0, TerminalMainFrame.VERTICAL_GAP, TerminalMainFrame.HORIZONTAL_GAP);
						gbc.anchor = GridBagConstraints.EAST;
						gbc.gridx = 1;
						gbc.gridy = 7;
					}
				}
				this.getPanelContent().add(lblPrice, gbc);
			}//End price
		}
	}

	{//Actions
		this.getPanelActions().setLayout(new GridLayout(1, 1));

		this.btnPay = new JButton("Payer");
		{
			this.btnPay.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent ae) {
					TerminalRentSummaryController.getTerminalPayController().askPay();
				}
			});
		}
		this.getPanelActions().add(this.btnPay);
	}

	@Override
	public void init() {
		RentSummary amount = TerminalRentSummaryController.getTerminalPayController().getRentSummary();
		if (amount != null) {
			this.textDuration.setText(amount.getDuration() + " " + amount.getDurationUnit());
			this.textPricePerBike.setText("" + amount.getDurationPricePerUnit());
			this.textQuantity.setText("" + amount.getBikeQuantity());
			this.textRentPrice.setText("" + amount.getRentAmount());
			this.textGuarantee.setText("" + amount.getGuaranteeAmount());
			this.textFinalPrice.setText("" + amount.getTotalAmount());
		} else {
			this.textDuration.setText("");
			this.textPricePerBike.setText("");
			this.textQuantity.setText("");
			this.textRentPrice.setText("");
			this.textGuarantee.setText("");
			this.textFinalPrice.setText("");
		}
	}
}
