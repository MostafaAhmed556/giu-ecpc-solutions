import java.util.*;
import java.io.*;

public class A_Kuriyama_Mirais_Stones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of stones
        int n = sc.nextInt();
        long[] a = new long[n];

        // Read stone costs
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        // Create and sort a copy of the array
        long[] sorted = a.clone();
        Arrays.sort(sorted);

        // Compute prefix sums for original and sorted arrays
        long[] pref1 = new long[n + 1];
        long[] pref2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pref1[i] = pref1[i - 1] + a[i - 1];
            pref2[i] = pref2[i - 1] + sorted[i - 1];
        }

        // Process queries
        int q = sc.nextInt();
        while (q-- > 0) {
            int type = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Output sum based on query type
            if (type == 1) {
                System.out.println(pref1[r] - pref1[l - 1]);
            } else {
                System.out.println(pref2[r] - pref2[l - 1]);
            }
        }

        sc.close();
    }
}