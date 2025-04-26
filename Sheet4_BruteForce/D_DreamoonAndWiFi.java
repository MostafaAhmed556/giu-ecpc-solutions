import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        int dist = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+')
                dist++;
            else
                dist--;
        }
        int x = 0, y = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '?')
                x++;
            else if (t.charAt(i) == '+')
                y++;
            else
                y--;
        }

        int ans = 0;

        for (int mask = 0; mask < (1 << x); mask++) {
            //if bit is 1 then we assume this '?' is a '+' otherwise '-'
            int pos = 0;
            for (int i = 0; i < x; i++) {
                if (((1 << i) & mask) != 0)
                    pos++;
                else
                    pos--;
            }
            if (pos + y == dist)
                ans++;
        }
        int total = 1<<x;
        System.out.println(ans*1.0 / total);
    }
}