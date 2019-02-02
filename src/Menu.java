import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
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
        System.err.println(textInput + " " + password);
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
    
        System.out.println("Please enter the data you would like to hide");
        System.out.println("If you would like to exit the program, please type 'exit'");

        String data = scanner.nextLine();

        do {
            System.out.println("Encrypting..." + data);
            data = scanner.nextLine();

            if (data.equals("toggle")) {
                // run encryption methods
            }
        } while(!data.equals("exit"));
        scanner.close();
        return;
    }
}