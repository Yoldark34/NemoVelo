/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalController;
import controller.terminal.controller.TerminalPayController;
import controller.terminal.interfacesGUI.TerminalPay;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalPayPanel extends AbstractTerminalPanel implements TerminalPay {

	private JTextField txtAmount;
	JCheckBox chkbxUseTerms;
	JCheckBox chkbxPurchaseTerms;
	private JButton btnPay;

	public TerminalPayPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		this.initialize();
	}

	public TerminalPayPanel(LayoutManager lm) {
		super(lm);
		this.initialize();
	}

	public TerminalPayPanel(boolean bln) {
		super(bln);
		this.initialize();
	}

	public TerminalPayPanel() {
		super();
		this.initialize();
	}

	private void initialize() {
		GridBagLayout gbl;
		GridBagConstraints gbc;

		{//Content
			{//Layout
				gbl = new GridBagLayout();
				gbl.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
				gbl.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
				gbl.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
			}
			this.getPanelContent().setLayout(gbl);

			JLabel lblAmount = new JLabel("Montant");
			{//Position
				gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.anchor = GridBagConstraints.EAST;
				gbc.gridx = 1;
				gbc.gridy = 1;
			}
			this.getPanelContent().add(lblAmount, gbc);

			this.txtAmount = new JTextField();
			{
				this.txtAmount.setColumns(10);
				{//Position
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, 5, 5);
					gbc.fill = GridBagConstraints.HORIZONTAL;
					gbc.gridx = 2;
					gbc.gridy = 1;
				}
			}
			this.getPanelContent().add(this.txtAmount, gbc);
			

			JLabel lblEuro = new JLabel("\u20AC");
			{//Position
				gbc = new GridBagConstraints();
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = 3;
				gbc.gridy = 1;
			}
			this.getPanelContent().add(lblEuro, gbc);

			this.chkbxUseTerms = new JCheckBox("J'accepte les CGU");
			{//Position
				gbc = new GridBagConstraints();
				gbc.gridwidth = 2;
				gbc.insets = new Insets(0, 0, 5, 5);
				gbc.gridx = 1;
				gbc.gridy = 3;
			}
			this.getPanelContent().add(this.chkbxUseTerms, gbc);

			this.chkbxPurchaseTerms = new JCheckBox("J'accepte les CGV");
			{//Position
				gbc = new GridBagConstraints();
				gbc.gridwidth = 2;
				gbc.insets = new Insets(0, 0, 0, 5);
				gbc.gridx = 1;
				gbc.gridy = 4;
			}
			this.getPanelContent().add(this.chkbxPurchaseTerms, gbc);
		}

		{//Actions
			this.getPanelActions().setLayout(new GridLayout(1, 1));

			this.btnPay = new JButton("Payer");
			{
				this.btnPay.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						if (!chkbxUseTerms.isSelected()) {
							TerminalController.getMainVue().showWarning("Veuillez accepter les Conditions Générales d'Utilisation");
							chkbxUseTerms.setVisible(true);
						} else if (!chkbxPurchaseTerms.isSelected()) {
							TerminalController.getMainVue().showWarning("Veuillez accepter les Conditions Générales de Vente");
							chkbxPurchaseTerms.setVisible(true);
						} else {
							TerminalPayController.getTerminalPayController().doPay();
						}
					}
				});
			}
			this.getPanelActions().add(this.btnPay);
		}
	}

	@Override
	public void init() {
		this.txtAmount.setText("" + TerminalPayController.getTerminalPayController().getAmount());
		if (TerminalPayController.getTerminalPayController().isMustConfirmUseTerms()) {
			//Not yet confirmed, visible so the user can chk to confirm
			this.chkbxUseTerms.setSelected(false);
			this.chkbxUseTerms.setVisible(true);
		} else {
			//Yet confirmed by system, not visible for user
			this.chkbxUseTerms.setSelected(true);
			this.chkbxUseTerms.setVisible(false);
		}
		if (TerminalPayController.getTerminalPayController().isMustConfirmPurchaseTerms()) {
			//Not yet confirmed, visible so the user can chk to confirm
			this.chkbxPurchaseTerms.setSelected(false);
			this.chkbxPurchaseTerms.setVisible(true);
		} else {
			//Yet confirmed by system, not visible for user
			this.chkbxPurchaseTerms.setSelected(true);
			this.chkbxPurchaseTerms.setVisible(false);
		}
	}
}
