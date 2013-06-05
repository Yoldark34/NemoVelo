/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalRentController;
import controller.terminal.interfacesGUI.TerminalRent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import vue.common.ValidityPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalRentPanel extends JPanel implements TerminalRent {

	//Maximal amount of bikes that can be selected
	private static final int MAXSELECTABLE_NBBIKE = 20;
	private static final int ROWHEIGHT = 32;
	//Panel to manage informations
	private JPanel panelInformations;
	private GridBagLayout gblInformations;
	private JLabel lblNbBikes;
	private JComboBox cboNbBikes;
	private ValidityPanel panelNbBikesValid;
	//Panel to fire actions
	private JPanel panelActions;
	private JButton btnRent;

	public TerminalRentPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalRentPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalRentPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalRentPanel() {
		initialize();
	}

	private void initialize() {
		GridBagConstraints gbc;

		this.setLayout(new BorderLayout());

		this.panelInformations = new JPanel();
		{
			this.gblInformations = new GridBagLayout();
			{
				this.gblInformations.columnWidths = new int[]{0, 0, ROWHEIGHT, 0};
				this.gblInformations.rowHeights = new int[]{ROWHEIGHT, 0};
				this.gblInformations.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
				this.gblInformations.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			}
			this.panelInformations.setLayout(this.gblInformations);

			//Nb selector
			this.cboNbBikes = new JComboBox();
			{
				for (int i = 0; i <= MAXSELECTABLE_NBBIKE; i++) {
					this.cboNbBikes.addItem(new Integer(i));
				}
				{
					this.cboNbBikes.addItemListener(new ItemListener() {
						@Override
						public void itemStateChanged(ItemEvent ie) {
							if (cboNbBikes.getSelectedIndex() == -1) {
								panelNbBikesValid.setValid(ValidityPanel.NONE);
							} else {
								if (TerminalRentController.getTerminalRentController()
										.getBikesAreAvailable(
										((Integer) (cboNbBikes.getSelectedItem())).intValue())) {
									panelNbBikesValid.setValid(ValidityPanel.VALID);
								} else {
									panelNbBikesValid.setValid(ValidityPanel.INVALID);
								}
							}
							panelNbBikesValid.repaint();
						}
					});
				}
				{
					gbc = new GridBagConstraints();
					gbc.insets = new Insets(0, 0, 0, 5);
					gbc.fill = GridBagConstraints.BOTH;
					gbc.gridx = 1;
					gbc.gridy = 0;
				}
			}
			this.panelInformations.add(this.cboNbBikes, gbc);
			//Label
			this.lblNbBikes = new JLabel("Nombre de vélos");
			{
				this.lblNbBikes.setLabelFor(this.cboNbBikes);
				{
					gbc = new GridBagConstraints();
					gbc.fill = GridBagConstraints.VERTICAL;
					gbc.insets = new Insets(0, 5, 0, 5);
					gbc.anchor = GridBagConstraints.EAST;
					gbc.gridx = 0;
					gbc.gridy = 0;
				}
			}
			this.panelInformations.add(this.lblNbBikes, gbc);
			//Validity
			this.panelNbBikesValid = new ValidityPanel();
			{
				gbc = new GridBagConstraints();
				gbc.fill = GridBagConstraints.BOTH;
				gbc.gridx = 2;
				gbc.gridy = 0;
			}
			this.panelInformations.add(this.panelNbBikesValid, gbc);
		}
		this.add(this.panelInformations, BorderLayout.NORTH);

		this.panelActions = new JPanel();
		{
			this.panelActions.setLayout(new GridLayout(1, 1));

			this.btnRent = new JButton("Louer");
			{
				this.btnRent.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalRentController.getTerminalRentController().doRent();
					}
				});
			}
			this.panelActions.add(this.btnRent);
			//TODO : Add Sign in button
		}
		this.add(this.panelActions, BorderLayout.CENTER);
	}
}
