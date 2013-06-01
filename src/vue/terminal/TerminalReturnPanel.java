/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalRentController;
import controller.terminal.controller.TerminalReturnController;
import controller.terminal.interfacesGUI.TerminalReturn;
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
public class TerminalReturnPanel extends JPanel implements TerminalReturn {

	private JPanel panelActions;
	private JButton btnReturn;


	public TerminalReturnPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalReturnPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalReturnPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalReturnPanel() {
		initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());

		this.panelActions = new JPanel();
		{
			this.panelActions.setLayout(new GridLayout(1, 1));

			this.btnReturn = new JButton("Rendre");
			{
				this.btnReturn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalReturnController.getTerminalReturnController().doReturn();
					}
				});
			}
			this.panelActions.add(this.btnReturn);
		}
		this.add(this.panelActions, BorderLayout.CENTER);
	}
}
