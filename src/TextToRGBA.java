//import java.awt.Color;
import org.apache.commons.lang3.ArrayUtils;

public class TextToRGBA {
	String cipherText = "Xb372ssg4";
	//Color colourObj;
	
	TextToRGBA() {
		 //colourObj = new Color(height, height, height, height);
	}
	
	/** Splits the private key into an array of characters */
	public char[] splitKey() {
		int size = cipherText.length();
		char[] characterArray = new char[size]; 
		characterArray = cipherText.toCharArray();
		return characterArray;
	}
	
	/** Converts characters into integer array */
	public int[] convertInt(char[] characterArray) {
		int size = characterArray.length;
		int[] intArray = new int[size];
		for (int i=0;i<size;i++) {
			intArray[i] = (int) characterArray[i];
		}
		return intArray;
	}
	
	public int[] genAll(int[] intArray) {
		int size = intArray.length;
		int[] pixelArray = {intArray[0]};
		for (int i=1;i<size;i++) {
			int[] onePixelArray = genPixel(intArray[i]);
			pixelArray = ArrayUtils.addAll(pixelArray, onePixelArray);
		}
		return pixelArray;
	}
	
	public int[] genPixel(int ascii) {
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
