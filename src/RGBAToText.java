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
		String[] stringArray = new String[textRGBInt.length];
		
//		for (int i =0; i< size; i++) {
//			textArray[i] = (textRGBInt[i]) + ",";
//		}
		
		for (int i=0;i<size;i++) {
			int rgbAsInt = textRGBInt[i];
			int red = rgbAsInt & 255;
			if( i+1 == size) {
				stringArray[i] = ""+red;
			}else {
				stringArray[i] = ""+red;
			}
			
		}
		
		//String text = String.join("", textArray);
		return stringArray;
	}
	
	public String[] getKey(int[] keyRGB) {
		int size = keyRGB.length;
		String[] keyArray = new String[keyRGB.length];
		for (int i =0; i< size; i++) {
			int actualInt = (keyRGB[i]);
			char character = (char)actualInt;
			if(i+1 == size) {
				String characterStr = String.valueOf(character);
				keyArray[i]=characterStr;
			}else {
			String characterStr = String.valueOf(character);
			keyArray[i]=characterStr+",";
		}
		}
//		for (int i=0;i<size;i++) {
//			int red = keyRGB[i];
////		int optimizedInt = Integer.parseInt(red);
//			int actualInt = red - 128;
//			keyArray = ArrayUtils.addAll(keyArray, characterStr);
//		}
		for(int i = 0; i<size; i++) {
			System.out.print(keyArray[i] + " ");
		}
//		System.out.println("I just printed his key lol... it is this many characters long :D " + keyArray.length);
		//String key = String.join(",", keyArray);
		return keyArray;
	}
}
