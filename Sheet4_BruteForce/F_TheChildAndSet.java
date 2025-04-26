import java.util.*;
public class Main {
    static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.x - a.x);
        int sum = sc.nextInt(), limit = sc.nextInt();

        for(int i =1; i <= limit; i++){
            pq.add(new Pair(i&-i, i));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(p.x <= sum){
                ans.add(p.y);
                sum -= p.x;
            }
            if(sum == 0) break;
        }
        if(sum != 0){
            System.out.println(-1);
            return;
        }
        System.out.println(ans.size());
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}