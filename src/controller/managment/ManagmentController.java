/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.managment;

import controller.interfacesGUI.MainVue;

/**
 *
 * @author valentin.seitz
 */
public class ManagmentController {

	private static MainVue mainVue;

	public static MainVue getMainVue() {
		return ManagmentController.mainVue;
	}

	private static void setMainVue(MainVue mainVue) {
		ManagmentController.mainVue = mainVue;
	}

	public ManagmentController(MainVue mainVue) {
		setMainVue(mainVue);
	}
}
