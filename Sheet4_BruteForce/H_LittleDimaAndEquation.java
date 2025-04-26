import java.util.*;

public class Main {

    public static int s(long x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();

        ArrayList<Long>ans = new ArrayList<>();
        for (int i = 1; i <= 81; i++) {
            long assumed = b * (long)Math.pow(i, a) +c;
            if(s(assumed)==i && assumed>0 && assumed<1000000000)
                ans.add(assumed);
        }
        System.out.println(ans.size());
        for(long x: ans){
            System.out.print(x + " ");
        }
    }
}