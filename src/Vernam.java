import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Vernam {

    /**
     * Encrypts a string using the vernam cypher.
     *
     * @param text String to encrypt
     * @return Array containing ciphertext [0] and key [1]
     */
    String[] encrypt(String text){
        List<String> asciiList = new ArrayList<>();
        List<String> shiftList = new ArrayList<>();
        for (int i = 0; i < text.length(); i++){
            char character = text.charAt(i);
            int ascii = (int) character;
            int[] shiftAndVal = genChar(ascii);

            shiftList.add(Integer.toString(shiftAndVal[0]));
            char newCharacter = (char) shiftAndVal[1];
            asciiList.add(Character.toString(newCharacter));
        }
        String[] asciiArrary = asciiList.toArray(new String[0]);
        return new String[] {String.join("", asciiArrary), String.join(",", shiftList.toArray(new String[0]))};
    }

    private int[] genChar(int val){
        int shift = 0;
        int newVal = 0;
        boolean valid = false;
        while (!valid){
            newVal = 0;
            shift = genShift(val);
            newVal = shift + val;
            if (32 <= newVal && newVal < 127 && newVal != 92){
                valid = true;
            }
        }
        return new int[]{shift, newVal};
    }

    /**
     * Generates a number to shift the ascii value by.
     *
     * @param val int representing ascii value of character
     * @return int to shift by
     */
    private int genShift(int val){
        Random random = new Random();
        return random.ints(0 - val, (128 - val)).limit(1).findFirst().getAsInt();
    }

    /**
     * Decrypts given ciphertext using given key
     *
     * @param cipher Array containing ciphertext [0] and decryption key [1] as strings
     * @return String of decrypted text
     */
    String decrypt(String[] cipher){
        String cipherText = cipher[0];
        String[] cipherArray = cipherText.split(",");
        String[] keyText = cipher[1].split(",");
        List<String> decryptedText = new ArrayList<>();
        String characterToDecrypt;
        String finalOutput = "";
        int asciiOfCTD;

        System.out.println("");
        System.out.println("Output: \n\n\n");
        
        for (int i = 0; i<cipherArray.length ; i++){
            asciiOfCTD = Integer.parseInt(cipherArray[i]);
            String tempStr = keyText[i];
            char tempChar = tempStr.charAt(0);
            int newVal =  asciiOfCTD - (int)(tempChar);
            char newChar = (char) newVal;
            
            //decryptedText.add(Character.toString(newVal));
            
        	finalOutput += newChar;
        }
        return finalOutput;
    }

}
