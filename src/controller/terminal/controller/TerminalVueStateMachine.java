/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.terminal.controller;

/**
 *
 * @author Valentin SEITZ
 */
class TerminalVueStateMachine {

	public static int getState() {
		return state;
	}
	//The vues, first dimensions of possibilites array
	private static final int IMPOSSIBLE = -1;
	private static final int VUE_WELCOME = 0;
	private static final int VUE_RENT = 1;
	private static final int VUE_PAY = 2;
	//The actions which can change the vue, second dimension of possibilites
	public static final int ACTION_ASK_RENT = 0;
	public static final int ACTION_ASK_PAYEMENT = 1;
	//The possibilites array
	private static int[][] possibilities = {
		{VUE_RENT, IMPOSSIBLE},
		{IMPOSSIBLE, VUE_PAY},
		{IMPOSSIBLE, IMPOSSIBLE}
	};
	//The state of machine
	private static int state = VUE_WELCOME;

	public static boolean change(int action) {
		boolean possible;
		int nextState;
		//State index ok?
		possible = (0 <= state && state < possibilities.length);
		if (possible) {
			//Action index ok?
			possible = (0 <= action && action < possibilities[state].length);
		}
		if (possible) {
			//Reading next state, if not impossible
			nextState = possibilities[state][action];
			possible = (nextState != IMPOSSIBLE);
			if (possible) {
				state = nextState;
			}
		}
		return possible;
	}
}
