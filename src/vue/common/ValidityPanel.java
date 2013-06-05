/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vue.common;

import java.awt.Graphics;
import java.awt.LayoutManager;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import resource.Resource;
import resource.image.Image;

/**
 *
 * @author Valentin SEITZ
 */
public class ValidityPanel extends JPanel {

	public static final int VALID = 1;
	public static final int INVALID = 0;
	public static final int NONE = -1;
	//Images
	private int valid;
	private ImageIcon imgValid;
	private ImageIcon imgInvalid;

	private int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public ValidityPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		initialize();
	}

	public ValidityPanel(LayoutManager lm) {
		super(lm);
		initialize();
	}

	public ValidityPanel(boolean bln) {
		super(bln);
		initialize();
	}

	public ValidityPanel() {
		initialize();
	}

	private void initialize() {
		URL imgUrl;
		imgUrl = Resource.getResource(Resource.IMAGE_VALID);
		if (imgUrl != null) {
			this.imgValid = new ImageIcon(imgUrl);
		}
		imgUrl = Resource.getResource(Resource.IMAGE_INVALID);
		if (imgUrl != null) {
			this.imgInvalid = new ImageIcon(imgUrl);
		}
		this.setValid(NONE);
	}

	@Override
	public void paint(Graphics grphcs) {
		super.paint(grphcs);
		float resizeCoef;
		int newWidth;
		int newHeight;
		ImageIcon img;
		ImageIcon imgResized;
		//Select image that is to draw
		switch (this.getValid()) {
			case VALID:
				img = this.imgValid;
				break;
			case INVALID:
				img = this.imgInvalid;
				break;
			case NONE:
				img = null;
				break;
			default:
				img = null;
		}
		//Selected image?
		if (img != null) {
			//Draw image
			resizeCoef = Math.min(
					(float) (this.getWidth()) / (float) (img.getIconWidth()),
					(float) (this.getHeight()) / (float) (img.getIconHeight()));
			newWidth = (int) (img.getIconWidth() * resizeCoef);
			newHeight = (int) (img.getIconHeight() * resizeCoef);
			if (img.getIconWidth() != newWidth || img.getIconHeight() != newHeight) {
				imgResized = Image.resize(img, newWidth, newHeight);
				imgResized.paintIcon(this, grphcs, (this.getWidth() - newWidth) / 2, (this.getHeight() - newHeight) / 2);
			} else {
				img.paintIcon(this, grphcs, (this.getWidth() - newWidth) / 2, (this.getHeight() - newHeight) / 2);
			}
		}
	}
}
