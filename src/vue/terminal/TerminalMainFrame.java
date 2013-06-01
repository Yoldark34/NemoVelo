/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.interfacesGUI.TerminalMainVue;
import controller.terminal.interfacesGUI.TerminalPay;
import controller.terminal.interfacesGUI.TerminalRent;
import controller.terminal.interfacesGUI.TerminalReturn;
import controller.terminal.interfacesGUI.TerminalReturnSummary;
import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vue.common.BannerPanel;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalMainFrame extends JFrame implements TerminalMainVue {

	private static final int BANNER_HEIGHT = 50;

	private static final String CARD_WELCOME = "WELCOME";
	private static final String CARD_RENT = "RENT";
	private static final String CARD_PAY = "PAY";
	private static final String CARD_RETURN = "RETURN";
	private static final String CARD_RETURN_SUMMARY = "RETURN_SUMMARY";
	//The banner of application
	JPanel banner;
	//Vues are managed as cards
	JPanel cards;
	CardLayout cardsLayout;
	//Vues
	private TerminalWelcomePanel welcomeVue;
	private TerminalRentPanel rentVue;
	private TerminalPayPanel payVue;
	private TerminalReturnPanel returnVue;
	private TerminalReturnSummaryPanel returnSummaryVue;

	public TerminalMainFrame() throws HeadlessException {
		initialize();
	}

	public TerminalMainFrame(GraphicsConfiguration gc) {
		super(gc);
		initialize();
	}

	public TerminalMainFrame(String string) throws HeadlessException {
		super(string);
		initialize();
	}

	public TerminalMainFrame(String string, GraphicsConfiguration gc) {
		super(string, gc);
		initialize();
	}

	private void initialize() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(640, 480));

		//Initialize banner
		this.banner = new BannerPanel();
		{
			this.banner.setPreferredSize(new Dimension((int) (this.banner.getPreferredSize().getWidth()), BANNER_HEIGHT));
		}
		this.add(this.banner, BorderLayout.NORTH);

		//Initialize cards
		this.cards = new JPanel();
		this.cardsLayout = new CardLayout();
		this.cards.setLayout(this.cardsLayout);
		{
			//Welcome vue
			this.welcomeVue = new TerminalWelcomePanel();
			this.cards.add(this.welcomeVue, CARD_WELCOME);

			//Rent vue
			this.rentVue = new TerminalRentPanel();
			this.cards.add(this.rentVue, CARD_RENT);

			//Pay vue
			this.payVue = new TerminalPayPanel();
			this.cards.add(this.payVue, CARD_PAY);

			//Return vue
			this.returnVue = new TerminalReturnPanel();
			this.cards.add(this.returnVue, CARD_RETURN);

			//ReturnSummary vue
			this.returnSummaryVue = new TerminalReturnSummaryPanel();
			this.cards.add(this.returnSummaryVue, CARD_RETURN_SUMMARY);
		}
		this.add(this.cards, BorderLayout.CENTER);

		//Just exit application
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void displayTerminalWelcome() {
		this.cardsLayout.show(this.cards, CARD_WELCOME);
	}

	@Override
	public void displayTerminalRent() {
		this.cardsLayout.show(this.cards, CARD_RENT);
	}

	@Override
	public void displayTerminalPay() {
		this.cardsLayout.show(this.cards, CARD_PAY);
	}

	@Override
	public void displayTerminalReturn() {
		this.cardsLayout.show(this.cards, CARD_RETURN);
	}

	@Override
	public void displayTerminalReturnSummary() {
		this.cardsLayout.show(this.cards, CARD_RETURN_SUMMARY);
	}

	@Override
	public TerminalWelcome getTerminalWelcome() {
		return this.welcomeVue;
	}

	@Override
	public TerminalRent getTerminalRent() {
		return this.rentVue;
	}

	@Override
	public TerminalPay getTerminalPay() {
		return this.payVue;
	}

	@Override
	public TerminalReturn getTerminalReturn() {
		return this.returnVue;
	}

	@Override
	public TerminalReturnSummary getTerminalReturnSummary() {
		return returnSummaryVue;
	}

	@Override
	public void showError(String msg) {
		//TODO
		JOptionPane.showConfirmDialog(null, msg);
	}
}
