import java.util.*;

public class Main {

    public static int get(int i) {
        int max = 0, min = 9;
        while (i != 0) {
            int digit = i % 10;
            min = Math.min(digit, min);
            max = Math.max(digit, max);
            i /= 10;
        }
        return max - min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int l = sc.nextInt(), r = sc.nextInt();
            int lucky = 0;
            int ans = l;
            for (int i = l; i <= r && lucky != 9; i++) {
                int x = get(i);
                if (x > lucky) {
                    lucky = x;
                    ans = i;
                }
            }
            System.out.println(ans);
        }
    }
}