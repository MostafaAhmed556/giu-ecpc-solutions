import java.util.*;

public class I_Gold_Rush {

    public static boolean valid(int n, int m) {
        if (n == m) return true;
        if (n < m || n % 3 != 0) return false;
        return valid(n / 3, m) || valid(2 * n / 3, m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if (valid(n, m)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

     }
}