import java.util.*;

// Solution for the "Greg and Array" problem
public class C_GregAndArray {
    public static void main(String[] args) {
        // Initialize scanner for input
        Scanner sc = new Scanner(System.in);

        // Read input: n (array size), m (number of operations), k (number of queries)
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // Read initial array a
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Read operations: each operation has left index, right index, and value to add
        int[][] b = new int[m][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = sc.nextInt(); // l, r, d
            }
        }

        // Count how many times each operation is applied using difference array
        int[] ps = new int[m + 1];
        for (int i = 0; i < k; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            ps[l - 1]++; // Increment start of range
            ps[r]--;     // Decrement end+1 of range
        }

        // Compute prefix sums to get operation frequencies
        for (int i = 1; i < m; i++) {
            ps[i] += ps[i - 1];
        }

        // Apply operations to array using difference array to avoid overflow
        long[] add = new long[n + 1];
        for (int i = 0; i < m; i++) {
            int x = b[i][0]; // Left index
            int y = b[i][1]; // Right index
            int d = b[i][2]; // Value to add
            long total_d = (long) d * ps[i]; // Total addition for this operation
            add[x - 1] += total_d; // Add at start of range
            add[y] -= total_d;     // Subtract at end+1 of range
        }

        // Compute prefix sums to get total additions for each index
        for (int i = 1; i < n; i++) {
            add[i] += add[i - 1];
        }

        // Add initial array values to the computed additions
        for (int i = 0; i < n; i++) {
            add[i] += a[i];
        }

        // Output the final array
        for (int i = 0; i < n; i++) {
            System.out.print(add[i] + " ");
        }

        // Close scanner to prevent resource leaks
        sc.close();
    }
}