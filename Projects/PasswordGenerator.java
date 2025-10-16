import java.util.Scanner;

/**
 * PasswordGenerator - skeleton
 *
 * TODOs:
 *   - implement generatePassword()
 *
 * Hints:
 *  - Use SecureRandom for random selection
 *  - Combine character sets based on user choices
 *  - Throw exception if no sets selected
 */
public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = UPPER.toLowerCase();
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>?/";

    /** Generate a password with given options. */
    public static String generatePassword(int length, boolean upper, boolean lower,
                                          boolean digits, boolean symbols) {
        // TODO:
        //  - If none selected, throw IllegalArgumentException
        //  - Build pool string based on choices
        //  - SecureRandom rand = new SecureRandom()
        //  - For i = 0..length-1: pick random char and append
        //  - Return result string
        throw new UnsupportedOperationException("generatePassword not implemented");
    }

    /** Simple helper for yes/no input. */
    private static boolean yes(String s) {
        if (s == null || s.isEmpty()) return true;
        s = s.trim().toLowerCase();
        return s.equals("y") || s.equals("yes");
    }

    // -------------------- MAIN --------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Password length (e.g., 12): ");
        int len = sc.nextInt(); sc.nextLine();

        System.out.print("Include uppercase? (Y/n): ");
        boolean up = yes(sc.nextLine());
        System.out.print("Include lowercase? (Y/n): ");
        boolean lo = yes(sc.nextLine());
        System.out.print("Include digits? (Y/n): ");
        boolean di = yes(sc.nextLine());
        System.out.print("Include symbols? (Y/n): ");
        boolean sy = yes(sc.nextLine());

        try {
            String pwd = generatePassword(len, up, lo, di, sy);
            System.out.println("\nGenerated password: " + pwd);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
