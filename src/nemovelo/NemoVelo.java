/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package nemovelo;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
* @author Admin
*/
public class NemoVelo {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		view_user view = new view_user();
		JFrame jf = new JFrame();
		jf.setContentPane(view);
		jf.setTitle("BorderTest");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setResizable(false);
		jf.setVisible(true);
		// TODO code application logic here
	}
        
        //Test initialisation Valentin
}
