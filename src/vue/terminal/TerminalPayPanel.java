/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalPayController;
import controller.terminal.interfacesGUI.TerminalPay;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalPayPanel extends AbstractTerminalPanel implements TerminalPay {

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

		this.getPanelActions().setLayout(new GridLayout(1, 1));

		{//Actions
			this.btnPay = new JButton("Payer");
			{
				this.btnPay.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalPayController.getTerminalPayController().doPay();
					}
				});
			}
			this.getPanelActions().add(this.btnPay);
			//TODO : Add Sign in button
		}
	}
}
