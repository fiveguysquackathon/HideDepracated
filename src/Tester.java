
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhotoManipulation test = new PhotoManipulation();
		int[] nums = { 12345678, -12345678, 87654321, -87654321, 18273645, -18273645, 81726354, -81726354, 45362718,
				-45362718, 54637281, -54637281 };
		test.openFile();
		test.createImage(nums);
		test.writeToFile();
	}

}
