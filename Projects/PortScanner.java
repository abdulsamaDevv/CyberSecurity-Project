import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

/**
 * PortScanner - skeleton
 *
 * TODOs:
 *   - implement scanPortRange()
 *   - optionally add multithreading
 *
 * Hints:
 *  - Use Socket with connect timeout
 *  - If connect succeeds => open
 *  - IOException => closed
 *  - Optional: use ExecutorService for faster parallel scanning
 */
public class PortScanner {

    /** Scan a single port to see if it's open. */
    private static boolean isPortOpen(String host, int port, int timeoutMs) {
        try (Socket s = new Socket()) {
            s.connect(new InetSocketAddress(host, port), timeoutMs);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /** Scan ports between start and end. */
    public static List<Integer> scanPortRange(String host, int start, int end, int timeoutMs, boolean threaded) {
        // TODO:
        //  if threaded == false:
        //    loop ports sequentially, check with isPortOpen()
        //  if threaded == true:
        //    use ExecutorService to submit tasks for each port
        //    gather results, then shutdown executor
        //  return list of open ports
        throw new UnsupportedOperationException("scanPortRange not implemented");
    }

    // -------------------- MAIN --------------------
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter host (e.g., localhost): ");
        String host = sc.nextLine().trim();

        System.out.print("Enter start port: ");
        int start = sc.nextInt();
        System.out.print("Enter end port: ");
        int end = sc.nextInt();
        sc.nextLine();

        if (start < 1 || end > 65535 || start > end) {
            System.out.println("Invalid range.");
            sc.close();
            return;
        }

        System.out.println("\nScanning " + host + " ports " + start + "-" + end + "...");
        List<Integer> open = scanPortRange(host, start, end, 200, false);
        System.out.println("Open ports: " + open);

        System.out.print("\nRun multi-threaded scan? (y/N): ");
        String choice = sc.nextLine().trim().toLowerCase();
        if (choice.equals("y")) {
            List<Integer> openFast = scanPortRange(host, start, end, 200, true);
            System.out.println("Open ports (fast): " + openFast);
        }

        sc.close();
    }
}
