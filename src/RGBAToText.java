import org.apache.commons.lang3.ArrayUtils;

public class RGBAToText {
//	String[][] textRGB = new String[][]{
//		  {"255","255","255","1"},
//		  {"60","255","255","1"},
//		  {"255","255","255","1"},
//		  {"255","255","255","1"},
//		  {"255","255","255","1"},
//		};
//		
//	String[][] keyRGB = new String[][]{
//		  {"255","255","255","1"},
//		  {"60","255","255","1"},
//		  {"255","255","255","1"},
//		  {"255","255","255","1"},
//		  {"255","255","255","1"},
//		};
		
	public String[] getText(int[] textRGBInt) {
		int size = textRGBInt.length;
		String[] textArray = new String[0];
		
		for (int i=0;i<size;i++) {
			int rgbAsInt = textRGBInt[i];
			int red = rgbAsInt & 255;
			char character = (char) red;
			String characterStr = String.valueOf(character);
			textArray = ArrayUtils.addAll(textArray, characterStr);
		}
		
		//String text = String.join("", textArray);
		return textArray;
	}
	
	public String[] getKey(int[] keyRGB) {
		int size = keyRGB.length;
		String[] keyArray = new String[0];
		
		for (int i=0;i<size;i++) {
			int red = keyRGB[i];
			//int optimizedInt = Integer.parseInt(red);
			int actualInt = red - 128;
			char character = (char) actualInt;
			String characterStr = String.valueOf(character);
			keyArray = ArrayUtils.addAll(keyArray, characterStr);
		}
		System.out.println("MAX's wee kee is likeee something along the lynes of this");
		for(int i = 0; i<size; i++) {
			System.out.print(keyArray[i] + " ");
		}
		System.out.println("I just printed his key lol... it is this many characters long :D " + keyArray.length);
		//String key = String.join(",", keyArray);
		return keyArray;
	}
}
