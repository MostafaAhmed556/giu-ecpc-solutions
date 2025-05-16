import java.util.*;

public class E_VanyaAndLabel {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int zeros = 0;
        for(int i=0;i<s.length();i++){
            char x = s.charAt(i);
            int onBits = 0;
            if(Character.isDigit(x)){
                onBits = Integer.bitCount(x-'0');
            }
            else if(Character.isUpperCase(x)){
                onBits = Integer.bitCount(x-'A'+10);
            }
            else if(Character.isLowerCase(x)){
                onBits = Integer.bitCount(x-'a'+36);
            }
            else if(x == '-'){
                onBits = Integer.bitCount(62);
            }
            else{
                onBits = Integer.bitCount(63);
            }
            zeros += 6 - onBits;
        }
        long mod = 1000000007;
        long ans = 1;
        for(int i=0;i<zeros;i++){
            ans = (ans * 3) % mod;
        }
        System.out.println(ans);
    }
}