package bj;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        long[][] dp = new long[N][N];
        dp[0][0] = board[0][0];
        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + board[i][j];
            }
        }
        for (int i = 0; i < M; i++) {
            int[] query = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = query[1] - 1;
            int y1 = query[0] - 1;
            int x2 = query[3] - 1;
            int y2 = query[2] - 1;

            long totalSum = dp[y2][x2];
            long leftSum = (x1 > 0) ? dp[y2][x1 - 1] : 0;
            long upSum = (y1 > 0) ? dp[y1 - 1][x2] : 0;
            long overlapSum = (x1 > 0 && y1 > 0) ? dp[y1 - 1][x1 - 1] : 0;
            System.out.println(totalSum - leftSum - upSum + overlapSum);
            // y큰것과 x작은것-1 + y작은것-1 x큰것 - x작은것-1 y작은것-1
        }
    }
}
