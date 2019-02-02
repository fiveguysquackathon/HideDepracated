import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;
import java.util.Random;

public class Tester {
	
	private static ImageEncrypting hey = new ImageEncrypting();
	private static ImageDescrypting heyy = new ImageDescrypting();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedImage image = hey.imageRead();
		System.out.print(image.getRGB(231,345)+"   ");
		System.out.print(image.getRGB(271,334)+"   ");
		System.out.print(image.getRGB(2411,445)+"   ");
		System.out.print(image.getRGB(31,32)+"   ");
		System.out.print(image.getRGB(245,445)+"   ");
		System.out.print(image.getRGB(31,328)+"   ");
		
		int[] array = {-14862480,-14862225,-13287045,-15654847,-14866624,-14993041};
		hey.encryptPixels(array);
		
		heyy.ImageDescrypting();
		
	}

}
