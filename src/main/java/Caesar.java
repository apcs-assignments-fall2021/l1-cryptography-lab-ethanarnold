import java.util.Scanner;



public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"

    //checks chars to see if they are letters
    public static boolean isLetter(char ch) {
        return(ch>='A' && ch<='Z' || ch>='a' && ch<='z');
    }

    //Letter shifter to make stuff easier: takes a char to be shifted and an int for how much to shift.
    //Only shifts letters.
    public static char charEncrypt(char ch, int n) {
        if(n>26) n -= (n/26)*26;
        if(!(isLetter(ch))) return ch;
        if(ch>='A' && ch<='Z' && ch+n>'Z') {
            return (char) (ch+n-26);
        }
        if(ch>='a' && ch<='z' && ch+n>'z') {
            return (char) (ch+n-26);
        }
        return (char) (ch+n);
    }

    public static char charDecrypt(char ch, int n) {
        if(n>26) n -= (n/26)*26;
        if(!(isLetter(ch))) return ch;
        if(ch>='A' && ch<='Z' && ch-n<'A') {
            return (char) (ch-n+26);
        }
        if(ch>='a' && ch<='z' && ch-n<'a') {
            return (char) (ch-n+26);
        }
        return (char) (ch-n);
    }


    public static String encryptCaesar(String message) {
        String res = "";
        for(int i=0; i<message.length(); i++) {
            res += charEncrypt(message.charAt(i), 3);
        }
        return res;
    }

    public static String decryptCaesar(String message) {
        String res = "";
        for(int i=0; i<message.length(); i++) {
            res += charDecrypt(message.charAt(i), 3);
        }
        return res;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String res = "";
        for(int i=0; i<message.length(); i++) {
            res += charEncrypt(message.charAt(i), key);
        }
        return res;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String res = "";
        for(int i=0; i<message.length(); i++) {
            res += charDecrypt(message.charAt(i), key);
        }
        return res;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        while(!(command.equals("encrypt") || command.equals("decrypt"))) {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
            command = scan.nextLine().trim().toLowerCase();
        }

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your encryption key.");
            int key = scan.nextInt();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesarKey(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter your decryption key.");
            int key = scan.nextInt();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesarKey(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
