/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalReturnController;
import controller.terminal.interfacesGUI.TerminalReturn;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalReturnPanel extends AbstractTerminalPanel implements TerminalReturn {

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

		{//Actions
			this.getPanelActions().setLayout(new GridLayout(1, 1));

			this.btnReturn = new JButton("Rendre");
			{
				this.btnReturn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalReturnController.getTerminalReturnController().doReturn();
					}
				});
			}
			this.getPanelActions().add(this.btnReturn);
		}
	}
}
