//import java.awt.Color;
import org.apache.commons.lang.ArrayUtils;

public class TextToRGBA {
	String privateKey = "";
	//Color colourObj;
	int height;
	int width;
	
	TextToRGBA() {
		 //colourObj = new Color(height, height, height, height);
		 height = 512;
		 width = 512;
	}
	
	/** Splits the private key into an array of characters */
	private char[] splitKey() {
		int size = privateKey.length();
		char[] characterArray = new char[size]; 
		characterArray = privateKey.toCharArray();
		return characterArray;
	}
	
	/** Converts characters into integer array */
	private int[] convertInt(char[] characterArray) {
		int size = characterArray.length;
		int[] intArray = new int[size];
		for (int i=0;i>size;i++) {
			intArray[i] = (int) characterArray[i];
		}
		return intArray;
	}
	
	private int[] genAll(int[] intArray) {
		
		int size = intArray.length;
		int[] pixelArray = new int[size*4];
		for (int i=1;i<=size;i++) {
			int[] onePixelArray = genPixel(intArray[i]);
			int[] combined = ArrayUtils.addAll(pixelArray, onePixelArray);
		}
		
	}
	private int[] genPixel(int ascii) {
		int red = ascii;
		int green_prov = 128 - ascii;
		int green;
		int blue = 256 - ascii;
		int opacity = 1;
		
		if (green_prov < 0) {
			green = green_prov*-1;
		}
		else {
			green = green_prov;
		}
		
		int onePixelArray[] = {red,green,blue,opacity};
		return onePixelArray;
	}
}