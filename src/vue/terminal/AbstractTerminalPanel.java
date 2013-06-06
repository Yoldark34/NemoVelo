/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.terminal;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Valentin SEITZ
 */
public abstract class AbstractTerminalPanel extends JPanel {

	//Actions panel height
	private static final int ACTIONS_HEIGHT = 128;
	//Two panels compose a vue
	private JPanel panelActions;
	private JPanel panelContent;

	protected JPanel getPanelActions() {
		if (this.panelActions == null) {
			this.panelActions = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			{
				gbc_panel.insets = new Insets(0, 0, 0, 0);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 1;
			}
			this.add(this.panelActions, gbc_panel);
		}
		return panelActions;
	}

	protected JPanel getPanelContent() {
		if (this.panelContent == null) {
			this.panelContent = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			{
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 0;
			}
			this.add(this.panelContent, gbc_panel);
		}
		return panelContent;
	}

	public AbstractTerminalPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		this.initialize();
	}

	public AbstractTerminalPanel(LayoutManager lm) {
		super(lm);
		this.initialize();
	}

	public AbstractTerminalPanel(boolean bln) {
		super(bln);
		this.initialize();
	}

	public AbstractTerminalPanel() {
		this.initialize();
	}

	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		{
			gridBagLayout.columnWidths = new int[]{0, 0};
			gridBagLayout.rowHeights = new int[]{0, ACTIONS_HEIGHT, 0};
			gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		}
		this.setLayout(gridBagLayout);
	}
}
