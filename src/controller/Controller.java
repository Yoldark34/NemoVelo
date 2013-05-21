/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfacesGUI.MainVue;

/**
 *
 * @author valentin.seitz
 */
public class Controller {

	private static MainVue mainVue;

	public static MainVue getMainVue() {
		return Controller.mainVue;
	}

	private static void setMainVue(MainVue mainVue) {
		Controller.mainVue = mainVue;
	}

	public Controller(MainVue mainVue) {
		setMainVue(mainVue);
	}
}
