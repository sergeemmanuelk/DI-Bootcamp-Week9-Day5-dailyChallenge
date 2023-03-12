import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the keyword: ");
        String keyword = sc.nextLine().toUpperCase();
        String encryptingText = generateEncryptingText(keyword);
        System.out.print("Enter the message to be ciphered: ");
        String message = sc.nextLine().toUpperCase();
        String cipheredText = encryptMessage(message, encryptingText);
        System.out.println("Ciphered String: " + cipheredText);
        String decipheredText = decryptMessage(cipheredText, encryptingText);
        System.out.println("Deciphered String: " + decipheredText);
    }

    // Method to generate the encrypting text
    public static String generateEncryptingText(String keyword) {
        // Remove duplicates from the keyword
        String temp = "";
        for(int i=0; i<keyword.length(); i++) {
            if(!temp.contains(Character.toString(keyword.charAt(i)))) {
                temp += keyword.charAt(i);
            }
        }
        keyword = temp;
        // Add the remaining letters to the keyword
        for(int i=65; i<=90; i++) {
            char letter = (char)i;
            if(!keyword.contains(Character.toString(letter))) {
                keyword += letter;
            }
        }
        return keyword;
    }

    // Method to encrypt the message
    public static String encryptMessage(String message, String encryptingText) {
        String cipheredText = "";
        for(int i=0; i<message.length(); i++) {
            char letter = message.charAt(i);
            if(letter>=65 && letter<=90) {
                cipheredText += encryptingText.charAt(letter-65);
            }
            else {
                cipheredText += letter;
            }
        }
        return cipheredText;
    }

    // Method to decrypt the message
    public static String decryptMessage(String cipheredText, String encryptingText) {
        String decipheredText = "";
        for(int i=0; i<cipheredText.length(); i++) {
            char letter = cipheredText.charAt(i);
            if(letter>=65 && letter<=90) {
                int position = encryptingText.indexOf(letter);
                decipheredText += (char)(position + 65);
            }
            else {
                decipheredText += letter;
            }
        }
        return decipheredText;
    }
}