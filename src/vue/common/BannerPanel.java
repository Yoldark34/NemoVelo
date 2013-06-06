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
 * Panel which display the banner of application
 *
 * @author Valentin SEITZ
 */
public class BannerPanel extends JPanel {

	private ImageIcon imgBanner;

	public BannerPanel(LayoutManager lm, boolean bln) {
		super(lm, bln);
		loadImg();
	}

	public BannerPanel(LayoutManager lm) {
		super(lm);
		loadImg();
	}

	public BannerPanel(boolean bln) {
		super(bln);
		loadImg();
	}

	public BannerPanel() {
		loadImg();
	}

	private void loadImg() {
		URL bannerUrl = Resource.getResource(Resource.IMAGE_BANNER);
		if (bannerUrl != null) {
			this.imgBanner = new ImageIcon(bannerUrl);
		}
	}

	@Override
	public void paint(Graphics grphcs) {
		super.paint(grphcs);
		float resizeCoef;
		int newWidth;
		int newHeight;
		ImageIcon ban;
		if (this.imgBanner != null) {
			resizeCoef = Math.min(
					(float) (this.getWidth()) / (float) (imgBanner.getIconWidth()),
					(float) (this.getHeight()) / (float) (imgBanner.getIconHeight()));
			newWidth = (int) (imgBanner.getIconWidth() * resizeCoef);
			newHeight = (int) (imgBanner.getIconHeight() * resizeCoef);
			if (imgBanner.getIconWidth() != newWidth || imgBanner.getIconHeight() != newHeight) {
				ban = Image.resize(imgBanner, newWidth, newHeight);
				ban.paintIcon(this, grphcs, (this.getWidth() - newWidth) / 2, (this.getHeight() - newHeight) / 2);
			} else {
				imgBanner.paintIcon(this, grphcs, (this.getWidth() - newWidth) / 2, (this.getHeight() - newHeight) / 2);
			}
		}
	}
}
