/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.common.controller;

/**
 *
 * @author valentin.seitz
 */
public class NemoUserController {

	private static NemoUserController nemoUserController;

	public static final NemoUserController getBikeController() {
		if (NemoUserController.nemoUserController == null) {
			NemoUserController.nemoUserController = new NemoUserController();
		}
		return NemoUserController.nemoUserController;
	}

	private NemoUserController() {
	}
}