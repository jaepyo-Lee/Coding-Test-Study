import java.io.*;

public class Main {
    static int[] dp;
    static int[] wine;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        wine = new int[n];
        for (int i = 0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(wine[0]);
            return;
        }

        if (n == 2) {
            System.out.println(wine[0] + wine[1]);
            return;
        }

        dp = new int[n];
        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];
        dp[2] = Math.max(wine[0] + wine[2], wine[1] + wine[2]);
        dp[2] = Math.max(dp[2], dp[1]);

        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(
                    Math.max(dp[i - 1], dp[i - 2] + wine[i]),
                    dp[i - 3] + wine[i - 1] + wine[i]
            );
        }

        System.out.println(dp[n - 1]);
    }
}
