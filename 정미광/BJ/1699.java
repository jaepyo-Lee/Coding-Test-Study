
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[100001];

        //1 = 1
        //2 = 1 + 1
        //3 = 1 + 1 + 1
        //4 = 2
        //5 = 2 + 1 = dp[4] + dp[1]
        //6 = 2 + 1 + 1 = dp[4] + dp[2]
        //7 = 2 + 1 + 1 + 1 = dp[4] + dp[3];
        //8 = 2 + 2 = dp[4] + dp[4]
        //9 = 3
        //10 = 3 + 1 = dp[9] + dp[1]
        //11 = 3 + 1 + 1 = dp[9] + dp[2]
        //12 = 3 + 1 + 1 + 1 = dp[9] + dp[3]
        //13 = 3 + 2 = dp[9] + dp[4]
        //14 = 3 + 2 + 1 = dp[9] + dp[5]
        //15 = 3 + 2 + 1 + 1 = dp[9] + dp[6]
        //16 = 4

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        if (n < 4) {
            System.out.print(dp[n]);
            return;
        }

        for (int i = 4, j = 0; i <= n; i++, j++) {
            int s = (int) Math.sqrt(i);
            if (i == s * s) {
                dp[i] = 1;
                j = 0;
                continue;
            }
            dp[i] = dp[j] + 1;
        }
        System.out.print(dp[n]);

        sc.close();
    }
}