
public class Tester {

	public static void main(String[] args) {
		Tester testObj = new Tester();
		testObj.maxTests();
	}
	
	public void maxTests() {
		String[] encryptionArray = {"7Xtej373v","-35,46,21,74,-32,53,-2"};
		TextToRGBA textToRGBAObj = new TextToRGBA();
		int[] keyRGBArray = textToRGBAObj.getKeyRGB(encryptionArray);
		
		for (int i=0;i<keyRGBArray.length;i++) {
			System.out.printf(keyRGBArray[i] + ",");
		}
	}

}
