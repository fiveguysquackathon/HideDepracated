import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	
	private Vernam vernam;
	private TextToRGBA textToRGBA;
	
    public static void main(String[] args) {
        Menu menu = new Menu();
        if(menu.password()) {
            menu.display();
        } else {
            System.out.println("Password Incorrect");
        }
        
    }

    public boolean password() {
        FileReader fReader;
        BufferedReader bReader;
        String textInput;
        try {
            // Getting the password from the file
            fReader = new FileReader("data/password.txt");
            bReader = new BufferedReader(fReader);
            textInput = bReader.readLine();
            // Makes sure the password is not null
            if (bReader.readLine() != null) {
                textInput = bReader.readLine();
            }
            
            // Allows the user to input validation
            @SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the password to begin the program:");

        String input = scanner.nextLine();
        int password = input.hashCode();
        if (Integer.parseInt(textInput) == password) {
            return true;
        } else {

        }

        } catch(FileNotFoundException e) {

        } catch(IOException e) {
            System.out.println("There was not a valid password found. Call 0124710240 for Tech Support!");
        }

        

        return false;


        
    }

    public void display() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Please enter the data you would like to hide (max 150 characters)");
        System.out.println("If you would like to exit the program, please type 'exit'");

        String data = scanner.nextLine();
        
        do {
        	if (data.length() > 150) {
        		System.out.println("The message was too long, try another:");
        	} else if (!data.equals("exit")) {
        		System.out.println("Encrypting... " + data);
        		
        		if (data.equals("toggle")) {
        			while (!data.equals("exit")) {
        				encryption(data);
                    data = scanner.nextLine();
        			}
                }
        		data = scanner.nextLine();
        		
        	} else {
        		data = scanner.nextLine();
        	}
            
        } while(!data.equals("exit"));
        scanner.close();
        return;
    }
    
    public void encryption(String data) {
    	
//    	GETTING EVERYTHING FROM NICK
    	
    	vernam = new Vernam();
        textToRGBA = new TextToRGBA();
        String[] cipherAndKey = vernam.encrypt(data);
        System.out.println("Cipher text " + cipherAndKey[0]);
        System.out.println("Cipher key " + cipherAndKey[1]);
        
//        GETTING EVERYTHING FROM MAX
        
        int[] textRGB = textToRGBA.getTextRGB(cipherAndKey[0].split(""));
        int[] keyRGB = textToRGBA.getKeyRGB(cipherAndKey[1].split(","));
        
        for (int i = 0; i < textRGB.length; i++) {
        	System.out.println(textRGB[i]);
        }
        for (int i = 0; i < keyRGB.length; i++) {
        	System.out.println(keyRGB[i]);
        }
        
//        GETTING EVERYTHING FROM ELLIE
        
        
        
        
//        GETTING EVERYTHING TO BRANDON
        
    }
    
    public void decryption() {
    	
    }
}