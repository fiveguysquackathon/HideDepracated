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
			input = new File("./media/blank.png");
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

	public String RGBSeparate(int RGB) {
		Color tempColor = new Color(RGB);
		int red;
		int green;
		int blue;

		red = tempColor.getRed();
		System.out.println(red);
		green = tempColor.getGreen();
		System.out.println(green);
		blue = tempColor.getBlue();
		System.out.println(blue);

		System.out.println(red + "," + green + "," + blue);
		return red + "," + green + "," + blue;
	}

	public void changePixel(int rgb, int x, int y) {
		img.setRGB(x, y, rgb);
	}

	public int getPixel(int x, int y) {
		return img.getRGB(x, y);

	}

	public void createImage(int[] input) {
		int width = img.getWidth();
		int height = img.getHeight();
		int counter = 0;
		int length = input.length;
		System.out.println(height + " " + width + " " + length);

		for (int i = 0; i < height; i++) {

			for (int j = 0; j < width; j++) {

				if (counter < length) {
					changePixel(input[counter], j, i);
					writeToFile();
					counter++;
				} else {
					changePixel(-000000000, j, i);
				}
				System.out.println(i + " " + j);
			}

		}

	}

}
