
public class Tester {

	public static void main(String[] args) {
		Tester testObj = new Tester();
		testObj.maxTests();
	}
	
	public void maxTests() {
		TextToRGBA textToRGBAObj = new TextToRGBA();
		char[] characterArray = textToRGBAObj.splitKey();
		int[] intArray = textToRGBAObj.convertInt(characterArray);
		int[] pixelArray = textToRGBAObj.genAll(intArray);
		
		for (int i=0;i<pixelArray.length;i++) {
			System.out.printf(pixelArray[i] + ",");
		}
	}

}
