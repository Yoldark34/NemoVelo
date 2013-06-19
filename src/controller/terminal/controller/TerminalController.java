/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

import controller.terminal.interfacesGUI.TerminalMainVue;
import java.util.ArrayList;
import java.util.HashSet;
import model.database.TerminalMapper;
import model.object.Bike;
import model.object.BikeUsage;
import model.object.Terminal;

/**
 *
 * @author Valentin SEITZ
 */
public class TerminalController {

	private static TerminalMainVue mainVue;
	private static Terminal terminal;
	private static boolean doAutoCancel;
	private static boolean doAlertBeforeAutoCancel;
	private static int anonymousUserId;
	private static PayAmount amountToPay;
	private static RentSummary rentSummary;
	private static ArrayList<Integer> idBikeUsagesToResetEndDate = new ArrayList<>();
	private static ArrayList<Integer> idBikeUsagesToDelete = new ArrayList<>();

	public static ArrayList<Integer> getIdBikeUsagesToResetEndDate() {
		return idBikeUsagesToResetEndDate;
	}

	public static void setIdBikeUsagesToResetEndDate(ArrayList<Integer> BikeUsagesToResetEndDate) {
		TerminalController.idBikeUsagesToResetEndDate = BikeUsagesToResetEndDate;
	}

	public static ArrayList<Integer> getIdBikeUsagesToDelete() {
		return idBikeUsagesToDelete;
	}

	public static void setIdBikeUsagesToDelete(ArrayList<Integer> BikeUsagesToDelete) {
		TerminalController.idBikeUsagesToDelete = BikeUsagesToDelete;
	}

	public static int getAnonymousUserId() {
		return anonymousUserId;
	}

	public static void setAnonymousUserId(int anonymousUserId) {
		TerminalController.anonymousUserId = anonymousUserId;
	}

	public static PayAmount getAmountToPay() {
		return amountToPay;
	}

	private static void setAmountToPay(PayAmount amountToPay) {
		TerminalController.amountToPay = amountToPay;
	}

	public static void setDoAutoCancel(boolean doAutoCancel) {
		TerminalController.doAutoCancel = doAutoCancel;
	}

	public static boolean isDoAutoCancel() {
		return doAutoCancel;
	}

	public static void setDoAlertBeforeAutoCancel(boolean doAlertBeforeAutoCancel) {
		TerminalController.doAlertBeforeAutoCancel = doAlertBeforeAutoCancel;
	}

	public static boolean isDoAlertBeforeAutoCancel() {
		return doAlertBeforeAutoCancel;
	}

	public static TerminalMainVue getMainVue() {
		return TerminalController.mainVue;
	}

	public static Terminal getTerminal() {
		return TerminalController.terminal;
	}

	private static void setMainVue(TerminalMainVue mainVue) {
		TerminalController.mainVue = mainVue;
	}

	public static RentSummary getRentSummary() {
		return rentSummary;
	}

	public static void setRentSummary(RentSummary rentSummary) {
		TerminalController.rentSummary = rentSummary;
	}

	public TerminalController(TerminalMainVue mainVue) {
		TerminalMapper terminalMapper = new TerminalMapper();
		terminal = terminalMapper.getTerminal(1);
		setAmountToPay(new PayAmount());
		setMainVue(mainVue);
		mainVue.displayTerminalWelcome();
	}

	public void doExit() {
		//TODO : cancel current operation
		System.exit(0);
	}
}
