public class NickTester {

    public static void main(String[] args){
        Vernam vernam = new Vernam();
        String[] cipher = vernam.encrypt("F to pay respects");
        System.out.println(cipher[0]);
        System.out.println(cipher[1]);
        System.out.println();
        System.out.println(vernam.decrypt(cipher));
    }

}
