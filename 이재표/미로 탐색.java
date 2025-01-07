import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = in[0];
        M = in[1];
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        dp[0][0] = 1;
        dfs(0, 0);
        System.out.println(dp[N - 1][M - 1]);
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    private static void dfs(int r, int c) {
        if (r == N - 1 && c == M - 1) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (r + dr[i] < 0 || r + dr[i] >= N || c + dc[i] < 0 || c + dc[i] >= M) {
                continue;
            }
            if (dp[r][c] + 1 < dp[r + dr[i]][c + dc[i]]) {
                if (map[r + dr[i]][c + dc[i]] == 1) {
                    dp[r + dr[i]][c + dc[i]] = dp[r][c] + 1;
                    dfs(r + dr[i], c + dc[i]);
                }
            }
        }
    }
}
