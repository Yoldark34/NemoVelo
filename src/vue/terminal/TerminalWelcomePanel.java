/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalWelcomeController;
import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalWelcomePanel extends AbstractTerminalPanel implements TerminalWelcome {

	private JButton btnRent;
	private JButton btnReturn;

	public TerminalWelcomePanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public TerminalWelcomePanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public TerminalWelcomePanel(boolean bln) {
		super(bln);
		initialize();
	}

	public TerminalWelcomePanel() {
		initialize();
	}

	private void initialize() {

		{//Actions
			this.getPanelActions().setLayout(new GridLayout(1, 2));
			//Rent button
			btnRent = new JButton("Louer");
			{
				btnRent.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalWelcomeController.getTerminalWelcomeController().askRent();
					}
				});
			}
			this.getPanelActions().add(btnRent);

			//Return button
			btnReturn = new JButton("Rendre");
			{
				btnReturn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent ae) {
						TerminalWelcomeController.getTerminalWelcomeController().askReturn();
					}
				});
			}
			this.getPanelActions().add(btnReturn);
		}
	}

	@Override
	public void init() {
		//Nothing to do
	}
}
