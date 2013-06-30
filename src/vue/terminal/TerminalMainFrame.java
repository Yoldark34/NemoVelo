/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import controller.terminal.controller.TerminalController;
import controller.terminal.interfacesGUI.TerminalMainVue;
import controller.terminal.interfacesGUI.TerminalPay;
import controller.terminal.interfacesGUI.TerminalRentSummary;
import controller.terminal.interfacesGUI.TerminalRent;
import controller.terminal.interfacesGUI.TerminalReturn;
import controller.terminal.interfacesGUI.TerminalReturnSummary;
import controller.terminal.interfacesGUI.TerminalWelcome;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
	private static final int BANNERSOUTH_MARGIN = 10;
	public static final int ROW_HEIGHT = 32;
	public static final int VERTICAL_GAP = 5;
	public static final int HORIZONTAL_GAP = 5;

	private static final String CARD_WELCOME = "WELCOME";
	private static final String CARD_RENT = "RENT";
	private static final String CARD_RENT_SUMMARY = "RENT_SUMMARY";
	private static final String CARD_RETURN = "RETURN";
	private static final String CARD_RETURN_SUMMARY = "RETURN_SUMMARY";
	private static final String CARD_PAY = "PAY";
	//The banner of application
	JPanel banner;
	//Vues are managed as cards
	JPanel cards;
	CardLayout cardsLayout;
	//Vues
	private TerminalWelcomePanel welcomeVue;
	private TerminalRentPanel rentVue;
	private TerminalRentSummaryPanel rentSummaryVue;
	private TerminalReturnPanel returnVue;
	private TerminalReturnSummaryPanel returnSummaryVue;
	private TerminalPayPanel payVue;

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
		BorderLayout bdl = new BorderLayout();
		bdl.setVgap(BANNERSOUTH_MARGIN);
		this.setLayout(bdl);
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

			//Rent summary vue
			this.rentSummaryVue = new TerminalRentSummaryPanel();
			this.cards.add(this.rentSummaryVue, CARD_RENT_SUMMARY);

			//Return vue
			this.returnVue = new TerminalReturnPanel();
			this.cards.add(this.returnVue, CARD_RETURN);

			//ReturnSummary vue
			this.returnSummaryVue = new TerminalReturnSummaryPanel();
			this.cards.add(this.returnSummaryVue, CARD_RETURN_SUMMARY);

			//Pay vue
			this.payVue = new TerminalPayPanel();
			this.cards.add(this.payVue, CARD_PAY);
		}
		this.add(this.cards, BorderLayout.CENTER);

		//Just exit application
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				TerminalController.doExit();
			}
		});
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
	public void displayTerminalRentSummary() {
		this.cardsLayout.show(this.cards, CARD_RENT_SUMMARY);
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
	public void displayTerminalPay() {
		this.cardsLayout.show(this.cards, CARD_PAY);
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
	public TerminalRentSummary getTerminalRentSummary() {
		return this.rentSummaryVue;
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
	public TerminalPay getTerminalPay() {
		return payVue;
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
