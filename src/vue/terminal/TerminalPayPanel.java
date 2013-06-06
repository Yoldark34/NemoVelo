/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalPayController;
import controller.terminal.controller.TerminalRentController;
import controller.terminal.interfacesGUI.TerminalPay;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalPayPanel extends JPanel implements TerminalPay {

	private JPanel panelActions;
	private JButton btnPay;

	public TerminalPayPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalPayPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalPayPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalPayPanel() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());

		this.panelActions = new JPanel();
		{
			this.panelActions.setLayout(new GridLayout(1, 1));

			this.btnPay = new JButton("Payer");
			{
				this.btnPay.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalPayController.getTerminalPayController().doPay();
					}
				});
			}
			this.panelActions.add(this.btnPay);
			//TODO : Add Sign in button
		}
		this.add(this.panelActions, BorderLayout.CENTER);
	}
}
