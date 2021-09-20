import java.util.Scanner;



public class Vigenere {
    public static boolean isLetter(char ch) {
        return(ch>='A' && ch<='Z' || ch>='a' && ch<='z');
    }

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


    public static String encryptVigenere(String message, String key) {
        String res = "";
        int keyIndex = 0;
        int keyCharValue;
        for(int i=0; i<message.length(); i++) {
            keyCharValue = (int) (key.charAt(keyIndex)-'A');

            res += charEncrypt(message.charAt(i), keyCharValue);

            if(isLetter(res.charAt(res.length()-1))) keyIndex++;
            if(keyIndex == key.length()) keyIndex = 0;

        }


        return res;
        // REPLACE THIS WITH YOUR CODE
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

    public static String decryptVigenere(String message, String key) {
        String res = "";
        int keyIndex = 0;
        int keyCharValue;
        for (int i = 0; i < message.length(); i++) {
            keyCharValue = (int) (key.charAt(keyIndex) - 'A');

            res += charDecrypt(message.charAt(i), keyCharValue);

            if(isLetter(res.charAt(res.length()-1))) keyIndex++;
            if(keyIndex == key.length()) keyIndex = 0;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
