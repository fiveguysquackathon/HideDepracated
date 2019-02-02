import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Arrays;

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
            char character = text.charAt(0);
            int ascii = (int) character;
            int[] shiftAndVal = genChar(ascii);

            shiftList.add(Integer.toString(shiftAndVal[0]));
            char newCharacter = (char) shiftAndVal[1];
            asciiList.add(Character.toString(newCharacter));
        }
        String[] asciiArrary = asciiList.toArray(new String[0]);
        return new String[] {Arrays.toString(asciiArrary), Arrays.toString(shiftList.toArray(new String[0]))};
    }

    private int[] genChar(int val){
        int shift = 0;
        int newVal = 0;
        boolean valid = false;
        while (!valid){
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

}
