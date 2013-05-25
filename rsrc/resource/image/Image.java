package resource.image;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Image {

	public static ImageIcon resize(ImageIcon img, int newW, int newH) {
		ImageIcon result;
		if (img != null) {
			result = new ImageIcon(((img).getImage()).getScaledInstance(newW, newH, java.awt.Image.SCALE_SMOOTH));
		} else {
			result = null;
		}
		return result;
	} 

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		BufferedImage result;
		int w;
		int h;
		if (img != null) {
			w = img.getWidth();
			h = img.getHeight();
			result = new BufferedImage(newW, newH, img.getType());
			Graphics2D g = result.createGraphics();
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
			g.dispose();
		} else {
			result = null;
		}
		return result;
	}

}
