
public class TesterMaximus {
//
	public static void main(String[] args) {
		TesterMaximus testObj = new TesterMaximus();
		testObj.maxTests();
	}
//	
	public void maxTests() {
//		String[] encryptionArray = {" ","-35,46,21,74,-32,53,-2"};
//		TextToRGBA textToRGBAObj = new TextToRGBA();
//		int[] keyRGBArray = textToRGBAObj.getTextRGB(encryptionArray);
//		
//		for (int i=0;i<keyRGBArray.length;i++) {
//			System.out.printf(keyRGBArray[i] + ",");
//		}
		RGBAToText rgbToTextObj = new RGBAToText();
		int[] textArray = {};
		int[][] keyArray = {
			
		};
		
		String[] text = rgbToTextObj.getText(textArray);
		String[] key = rgbToTextObj.getKey(keyArray);
		
		for (int i=0;i<key.length;i++) {
			System.out.printf(key[i] + ",");
		}
		
		System.out.println("");
		for (int i=0;i<text.length;i++) {
			System.out.printf(text[i] + ",");
		}
//		System.out.println(text);
//		System.out.println(key);
	}

}
