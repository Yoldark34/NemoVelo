/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal.secondaryFramed;

import controller.terminal.interfacesGUI.TerminalMainVue;
import controller.terminal.interfacesGUI.TerminalPay;
import controller.terminal.interfacesGUI.TerminalRent;
import controller.terminal.interfacesGUI.TerminalRentSummary;
import controller.terminal.interfacesGUI.TerminalReturn;
import controller.terminal.interfacesGUI.TerminalReturnSummary;
import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Valentin SEITZ
 */
public class FramedTerminalManager implements TerminalMainVue {

	private TerminalWelcomeFrame welcomeFrame;
	private TerminalRentFrame rentFrame;
	private TerminalRentSummaryFrame rentSummaryFrame;
	private TerminalReturnFrame returnFrame;
	private TerminalReturnSummaryFrame returnSummaryFrame;
	private TerminalPayFrame payFrame;
	private JFrame currentFrame;
	private boolean visible;

	public FramedTerminalManager() {
		this.welcomeFrame = new TerminalWelcomeFrame();
		this.rentFrame = new TerminalRentFrame();
		this.rentSummaryFrame = new TerminalRentSummaryFrame();
		this.returnFrame = new TerminalReturnFrame();
		this.returnSummaryFrame = new TerminalReturnSummaryFrame();
		this.payFrame = new TerminalPayFrame();
	}

	public void setTitle(String title) {
		this.welcomeFrame.setTitle(title);
		this.rentFrame.setTitle(title + " - location");
		this.rentSummaryFrame.setTitle(title + " - résumé de location");
		this.returnFrame.setTitle(title + " - rendu");
		this.returnSummaryFrame.setTitle(title + " - résumé de rendu");
		this.payFrame.setTitle(title + " - paiement");
	}

	public void setIconImage(Image icon) {
		this.welcomeFrame.setIconImage(icon);
		this.rentFrame.setIconImage(icon);
		this.rentSummaryFrame.setIconImage(icon);
		this.returnFrame.setIconImage(icon);
		this.returnSummaryFrame.setIconImage(icon);
		this.payFrame.setIconImage(icon);
	}

	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}


	public void setMinimumSize(Dimension size) {
		Dimension secundarySize;
		secundarySize = new Dimension(size.width - 20, size.height - 20);
		this.welcomeFrame.setMinimumSize(size);
		this.rentFrame.setMinimumSize(secundarySize);
		this.rentSummaryFrame.setMinimumSize(secundarySize);
		this.returnFrame.setMinimumSize(secundarySize);
		this.returnSummaryFrame.setMinimumSize(secundarySize);
		this.payFrame.setMinimumSize(secundarySize);
	}

	public void pack() {
		this.welcomeFrame.pack();
		this.rentFrame.pack();
		this.rentSummaryFrame.pack();
		this.returnFrame.pack();
		this.returnSummaryFrame.pack();
		this.payFrame.pack();
	}

	public void setLocationRelativeTo(Component component) {
		this.welcomeFrame.setLocationRelativeTo(component);
	}

	@Override
	public TerminalWelcome getTerminalWelcome() {
		return this.welcomeFrame;
	}

	@Override
	public TerminalRent getTerminalRent() {
		return this.rentFrame;
	}

	@Override
	public TerminalRentSummary getTerminalRentSummary() {
		return this.rentSummaryFrame;
	}

	@Override
	public TerminalReturn getTerminalReturn() {
		return this.returnFrame;
	}

	@Override
	public TerminalReturnSummary getTerminalReturnSummary() {
		return this.returnSummaryFrame;
	}

	@Override
	public TerminalPay getTerminalPay() {
		return this.payFrame;
	}

	@Override
	public void displayTerminalWelcome() {
		this.displayVue(this.welcomeFrame);
	}

	@Override
	public void displayTerminalRent() {
		this.displayVue(this.rentFrame);
	}

	@Override
	public void displayTerminalRentSummary() {
		this.displayVue(this.rentSummaryFrame);
	}

	@Override
	public void displayTerminalReturn() {
		this.displayVue(this.returnFrame);
	}

	@Override
	public void displayTerminalReturnSummary() {
		this.displayVue(this.returnSummaryFrame);
	}

	@Override
	public void displayTerminalPay() {
		this.displayVue(this.payFrame);
	}

	private void displayVue(JFrame vue) {
		if (this.currentFrame != null && this.currentFrame != this.welcomeFrame) {
			this.currentFrame.setVisible(false);
		}
		this.currentFrame = vue;
		if (this.currentFrame != this.welcomeFrame) {
			this.currentFrame.setLocationRelativeTo(this.welcomeFrame);
		}
		this.welcomeFrame.setEnabled(false);
		this.currentFrame.setEnabled(true);
		this.setVisible(this.visible);
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
		this.welcomeFrame.setVisible(visible);
		this.currentFrame.setVisible(visible);
	}

	@Override
	public void showInformation(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void showError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erreur", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void showWarning(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Avertissement", JOptionPane.WARNING_MESSAGE);
	}
}
