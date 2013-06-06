/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.common.controller;

/**
 *
 * @author Valentin SEITZ
 */
public class BikeController {

	private static BikeController bikeController;

	public static BikeController getBikeController() {
		if (BikeController.bikeController == null) {
			BikeController.bikeController = new BikeController();
		}
		return BikeController.bikeController;
	}

	private BikeController() {
	}
}
