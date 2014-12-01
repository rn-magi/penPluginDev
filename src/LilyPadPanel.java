import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LilyPadPanel extends JPanel{
	
	private BufferedImage img;
	private BufferedImage image;
	private Graphics2D imageGraphics;
	
	public LilyPadPanel() {
		try {
			img = ImageIO.read(new File("./plugin/LilyPad/LilyPad.jpg"));
			image = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);
			imageGraphics = (Graphics2D)image.createGraphics();
			imageGraphics.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}

		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent((Graphics2D) g);
		((Graphics2D) g).drawImage(image, 0, 0, this);
	}
}
