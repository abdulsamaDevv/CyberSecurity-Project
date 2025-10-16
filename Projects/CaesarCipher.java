import java.util.Scanner;

/**
 * CaesarCipher - skeleton
 * TODOs:
 *   - implement encrypt()
 *   - implement decrypt()
 *   - optionally implement bruteForce()
 *
 * Hints:
 *  - Use Character.isUpperCase / isLowerCase
 *  - Use 'A' and 'a' as bases when shifting
 *  - (char) ((c - base + shift) % 26 + base)
 */
public class CaesarCipher {

    /** Encrypt text by shifting letters by 'shift'. */
    public static String encrypt(String text, int shift) {
        // TODO:
        //  1. Loop through characters
        //  2. If letter, shift within A–Z or a–z
        //  3. Append to result
        //  4. If not a letter, append unchanged
        throw new UnsupportedOperationException("encrypt not implemented");
    }

    /** Decrypt by reversing the shift. Hint: call encrypt(text, 26 - shift). */
    public static String decrypt(String text, int shift) {
        // TODO:
        //  1. Return encrypt(text, 26 - shift)
        throw new UnsupportedOperationException("decrypt not implemented");
    }

    /** Brute-force all 25 possible shifts and print them. */
    public static void bruteForce(String encryptedText) {
        // TODO:
        //  for shift = 1..25
        //    print shift and decrypt result
        throw new UnsupportedOperationException("bruteForce not implemented");
    }

    // -------------------- MAIN --------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to encrypt: ");
        String text = sc.nextLine().trim();

        System.out.print("Enter shift value (1–25): ");
        int shift = sc.nextInt();
        sc.nextLine();

        if (shift < 1 || shift > 25) {
            System.out.println("Shift must be between 1 and 25.");
            sc.close();
            return;
        }

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("\nEncrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);

        System.out.print("\nBrute-force ciphertext? (y/N): ");
        String choice = sc.nextLine().trim().toLowerCase();
        if (choice.equals("y")) bruteForce(encrypted);

        sc.close();
    }
}
