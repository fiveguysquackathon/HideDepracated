import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PhotoManipulation {
	BufferedImage img = null;
	File input = null;
	File output = null;

	public void openFile() {
		try {
			input = new File("./media/image.png");
			img = ImageIO.read(input);
		} catch (IOException e) {
			System.out.println(e);
		}

	}

	public void writeToFile() {
		try {
			output = new File("./media/image2.png");
			ImageIO.write(img, "png", output);
		} catch (IOException t) {
			System.out.println(t);
		}
	}

	public int getWidth() {
		return img.getWidth();

	}

	public int getHeight() {
		return img.getHeight();
	}

	public int RGB_INT(int r, int g, int b) {
		Color tempColor = new Color(r, g, b);
		int rgb = tempColor.getRGB();
		return rgb;
	}

	public void changePixel(int rgb, int x, int y) {
		img.setRGB(x, y, rgb);
	}

	public int getPixel(int x, int y) {
		return img.getRGB(x, y);

	}

}
