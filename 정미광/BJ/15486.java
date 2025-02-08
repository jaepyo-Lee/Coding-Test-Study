import static java.lang.Math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] plans = new int[n + 1][2];
        int[] dp = new int[n + 2];
        int max = 0;

        for (int i = 1; i <= n; i++) {
            plans[i][0] = sc.nextInt(); //상담 일 수
            plans[i][1] = sc.nextInt(); //가격
        }

        for (int i = 1; i <= n; i++) {
            int days = i + plans[i][0];
            int price = plans[i][1];

            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (days < dp.length) {
                dp[days] = Math.max(dp[i] + price, dp[days]);
            }
        }

        System.out.print(Math.max(dp[n], dp[n + 1]));

        sc.close();
    }
}