public class NickTester {

    public static void main(String[] args){
        Vernam vernam = new Vernam();
        String[] cipher = vernam.encrypt("Hello, world");
        System.out.println(cipher[0]);
        System.out.println(cipher[1]);
    }

}
