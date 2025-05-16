import java.util.*;

public class C_Game_23 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n =sc.nextInt(), m = sc.nextInt();
        if(m%n!=0) {
            System.out.println(-1);
            return;
        }
        int x = m/n;
        int c = 0;
        while(x%2 == 0){
            x/=2;
            c++;
        }
        while(x%3 == 0){
            x/=3;
            c++;
        }
        if(x!=1){
            System.out.println(-1);
            return;
        }
        System.out.println(c);
    }
}