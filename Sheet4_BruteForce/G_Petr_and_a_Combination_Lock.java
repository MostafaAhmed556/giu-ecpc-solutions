import java.util.*;

public class G_Petr_and_a_Combination_Lock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
        int total = 1 << n; 
        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    sum += a.get(j);
                } else {
                    sum -= a.get(j);
                }
            }
            if (sum % 360 == 0) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
