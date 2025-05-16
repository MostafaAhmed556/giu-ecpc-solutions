import java.util.*;

public class B_KarenAndCoffee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input: n (number of recipes), k (minimum recipes for admissible temperature), q (number of queries)
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        // Initialize difference array (size 200002 to handle temperatures up to 200000)
        long[] a = new long[200002];

        // Process each recipe: increment start (l) and decrement end+1 (r+1)
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            a[l]++;
            a[r + 1]--;
        }

        // Compute prefix sum to get count of recipes recommending each temperature
        for (int i = 1; i < 200002; i++) {
            a[i] += a[i - 1];
        }

        // Create array b where b[i] = 1 if temperature i is admissible (recommended by >= k recipes), else 0
        long[] b = new long[200002];
        for (int i = 0; i < 200002; i++) {
            b[i] = (a[i] >= k ? 1 : 0);
        }

        // Compute prefix sum of b to allow range sum queries
        for (int i = 1; i < 200002; i++) {
            b[i] += b[i - 1];
        }

        // Process queries
        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            // Output number of admissible temperatures in range [l, r]
            System.out.println(b[r] - b[l - 1]);
        }

        sc.close();
    }
}