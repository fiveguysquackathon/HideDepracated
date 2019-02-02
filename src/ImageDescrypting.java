import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;
import java.util.Random;
import java.util.Scanner;

public class ImageDescrypting {

	public int[] ImageDescrypting() throws IOException {
		 
		BufferedImage image = ImageEncrypting.imageRead();
		
		// lets the user input the key
		Scanner a = new Scanner(System.in) ;
		System.out.print("Enter the key: ");
		String key = a.nextLine();
		
		//splits the string and adds it into a array of strings
		String[] parts = key.split(",");
		
		// the number of full random pixels and not full random pixels
		int fullRandom = Integer.parseInt(parts[parts.length-2]);
		int NOTfullRandom = Integer.parseInt(parts[parts.length-1]);
		
		// how many random pixels there are
		int randomPixels = fullRandom;
		if (NOTfullRandom!=0) randomPixels++;
		
		
		int[] x = new int[parts.length-2];
		int[] y = new int[parts.length-2];
		
		//save the coordinates of the random pixels
		for (int i=0;i<parts.length-2;i+=2) {
			x[i] = Integer.parseInt(parts[i]);
			y[i] = Integer.parseInt(parts[i+1]);
		}
		
		// number of pixels
		int pixelsQ = fullRandom*4 + NOTfullRandom;
		int[] pixels = new int[pixelsQ];
		
		// decryptes the pixels  
		
				//full random pixels ()
				int count=0;
					for (int i=0;i<fullRandom;i++) {
						pixels[count]=image.getRGB(x[i], y[i]-1);
						pixels[count+1]=image.getRGB(x[i]+1, y[i]);
						pixels[count+2]=image.getRGB(x[i], y[i]+1);
						pixels[count+3]=image.getRGB(x[i]-1, y[i]);
						count=count+4;
					}
				
				
				// NOT full random pixels
				
				if (NOTfullRandom!=0) {
					if (NOTfullRandom!=1) {
						pixels[count]=image.getRGB(x[randomPixels-1], y[randomPixels-1]-1);
					}
					if (NOTfullRandom!=2) {
						pixels[count]=image.getRGB(x[randomPixels-1], y[randomPixels-1]-1);
						pixels[count+1]=image.getRGB(x[randomPixels-1]+1, y[randomPixels-1]);			
					}
					if (NOTfullRandom!=3) {
						pixels[count]=image.getRGB(x[randomPixels-1], y[randomPixels-1]-1);
						pixels[count+1]=image.getRGB(x[randomPixels-1]+1, y[randomPixels-1]);
						pixels[count+2]=image.getRGB(x[randomPixels-1], y[randomPixels-1]+1);
					}
				}
				
				return pixels;
		
		
		
		
	}
}
