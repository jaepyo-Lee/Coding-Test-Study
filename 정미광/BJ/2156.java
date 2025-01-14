
import java.util.*;

public class Main {
    static int[] dp;
    static int[] wines;

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        wines = new int[N + 1];
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wines[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i] = wines[1];
                continue;
            }
            if (i == 2) {
                dp[i] = wines[1] + wines[2];
                continue;
            }
            if (i == 3) {
                dp[i] = Math.max(Math.max(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i])
                        , wines[i - 2] + wines[i - 1]);
                continue;
            }
            dp[i] = Math.max(Math.max(dp[i - 3] + wines[i - 1] + wines[i], dp[i - 2] + wines[i])
                    , dp[i - 4] + wines[i - 2] + wines[i - 1]);
        }

        System.out.print(dp[N]);
        sc.close();
    }

}