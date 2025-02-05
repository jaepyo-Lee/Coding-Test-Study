import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = in[0];
        int K = in[1];
        arr = new int[N][2];
        dp = new int[N][K + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(ns(N - 1, K));
    }

    private static int ns(int n, int k) {
        if (n < 0) {
            return 0;
        }
        int w = arr[n][0];
        int v = arr[n][1];
        if (w > k) {
            dp[n][k] = ns(n - 1, k);
        } else {
            dp[n][k] = Math.max(ns(n - 1, k), ns(n - 1, k - w) + v);
        }
        return dp[n][k];
    }
}
