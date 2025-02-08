
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
        int[] dp = new int[n + 1];
        if (n % 2 == 1) { //n이 홀수면 불가
            System.out.print(0);
            return;
        }

        //dp[0] = 1
        //dp[2] = 3
        //1 * 3 + 0
        //dp[4] = 11
        //3 * 3 + [2 = (1 * 2)]
        //dp[6] = 41
        //11 * 3 + [8 = (1 * 2) + (3 * 2)]
        //dp[8] = 153
        //41 * 3 + [30 = (1 * 2) + (3 * 2) + (11 * 2) ]
        //dp[10] = 571
        //153 * 3 + [112 = (1 * 2) + (3 * 2) + (11 * 2) + (41 * 2)]
        //dp[30] = 299303201

        dp[0] = 1;
        dp[2] = 3;
        for (int i = 4; i <= n; i += 2) {
            dp[i] = dp[i - 2] * dp[2];
            for (int j = 0; j <= i - 4; j += 2) {
                dp[i] += (dp[j] * 2);
            }
        }

        System.out.print(dp[n]);

        sc.close();
    }
}