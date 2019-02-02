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
		
	public String[] getText(int[][] textRGB) {
		int size = textRGB[0].length;
		String[] textArray = new String[0];
		
		for (int i=0;i<size;i++) {
			int red = textRGB[i][0];
			char character = (char) red;
			String characterStr = String.valueOf(character);
			textArray = ArrayUtils.addAll(textArray, characterStr);
		}
		
		//String text = String.join("", textArray);
		return textArray;
	}
	
	public String[] getKey(String[][] keyRGB) {
		int size = keyRGB.length;
		String[] keyArray = new String[0];
		
		for (int i=0;i<size;i++) {
			String red = keyRGB[i][0];
			int optimizedInt = Integer.parseInt(red);
			int actualInt = optimizedInt - 128;
			char character = (char) actualInt;
			String characterStr = String.valueOf(character);
			keyArray = ArrayUtils.addAll(keyArray, characterStr);
		}
		//String key = String.join(",", keyArray);
		return keyArray;
	}
}
