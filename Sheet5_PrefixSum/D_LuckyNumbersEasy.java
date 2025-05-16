import java.util.*;

public class D_LuckyNumbersEasy {
    // Use TreeSet to store super lucky numbers (sorted and unique)
    static TreeSet<Long> answers = new TreeSet<>();

    // Recursive function to generate numbers with digits 4 and 7
    static void rec(long num, int sevens, int fours) {
        // Stop if number exceeds 10^10
        if (num > 1e10) return;

        // If number has equal counts of 4s and 7s, add to answers
        if (sevens == fours) {
            answers.add(num);
        }

        // Recursively append 4 or 7
        rec(num * 10 + 4, sevens, fours + 1);
        rec(num * 10 + 7, sevens + 1, fours);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Generate all super lucky numbers starting with 4 or 7
        rec(4, 0, 1);
        rec(7, 1, 0);

        // Read input number
        long n = sc.nextLong();

        // Find the smallest super lucky number >= n
        System.out.println(answers.ceiling(n));

        sc.close();
    }
}