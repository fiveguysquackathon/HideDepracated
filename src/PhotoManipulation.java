import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class PhotoManipulation {
	BufferedImage img = null;
	File input = null;
	File output = null;

	public void keyController(String Key, int[] nums) {
		openFile();
		encodeCoord(Key);
		encodeKey(nums);
		writeToFile();
	}

	public void openFile() {
		try {
			input = new File("./media/Untitled.png");
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

	public int RGBSeparate(int RGB, int type) {
		Color tempColor = new Color(RGB);
		int output = 0;

		switch (type) {
		case 0:
			output = tempColor.getRed();
		case 1:
			output = tempColor.getGreen();
		case 2:
			output = tempColor.getBlue();
		}

		return output;
	}

	public int[][] returnText(int[] encoded) {
		int[][] temp = null;
		for (int i = 0; i < encoded.length; i++) {
			temp[i][0] = RGBSeparate(encoded[i], 0);
			temp[i][1] = RGBSeparate(encoded[i], 1);
			temp[i][2] = RGBSeparate(encoded[i], 2);

		}
		return null;

	}

	public void changePixel(int rgb, int x, int y) {
		img.setRGB(x, y, rgb);
	}

	public void printVals() {
		for (int i = img.getHeight()-10; i < img.getHeight(); i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(getPixel(j, i) + " ");
			}
			System.out.println("");
		}
	}
	public void encodeCoord(String Key) {
		String[] splitKey = Key.split(",");

		for (int i = 0; i < splitKey.length; i++) {
			changePixel(Integer.parseInt(splitKey[i]), i, 0);
		}
	}
	public void encodeKey(int[] Key) {
		

		for (int j = 0; j < Key.length; j++) {
			changePixel(Key[j], j, img.getHeight() - 1);
		}

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
