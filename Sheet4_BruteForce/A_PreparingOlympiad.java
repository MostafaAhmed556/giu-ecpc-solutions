import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        int x = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //using bitmask
        int ways = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) != 0) {
                    max = Math.max(a[i], max);
                    min = Math.min(a[i], min);
                    sum += a[i];
                }
            }
            int diff = max - min;
            if (diff >= x && l <= sum && sum <= r)
                ways++;
        }
        System.out.println(ways);
    }
}