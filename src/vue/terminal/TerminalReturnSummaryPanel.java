/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalReturnSummaryController;
import controller.terminal.interfacesGUI.TerminalReturnSummary;
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
public class TerminalReturnSummaryPanel extends JPanel implements TerminalReturnSummary {

	private JPanel panelActions;
	private JButton btnConfirm;

	public TerminalReturnSummaryPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalReturnSummaryPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalReturnSummaryPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalReturnSummaryPanel() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());

		this.panelActions = new JPanel();
		{
			this.panelActions.setLayout(new GridLayout(1, 1));

			this.btnConfirm = new JButton("Ok");
			{
				this.btnConfirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalReturnSummaryController.getTerminalReturnSummaryController().doConfirm();
					}
				});
			}
			this.panelActions.add(this.btnConfirm);
		}
		this.add(this.panelActions, BorderLayout.CENTER);
	}
}
