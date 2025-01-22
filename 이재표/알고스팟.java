package bj;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = in[0];
        int N = in[1];
        int[][] dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        dp[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                if (r + dr[i] < 0 || r + dr[i] >= N || c + dc[i] < 0 || c + dc[i] >= M) {
                    continue;
                }
                if (map[r + dr[i]][c + dc[i]] == 1) {
                    if (dp[r + dr[i]][c + dc[i]] > dp[r][c] + 1) {
                        dp[r + dr[i]][c + dc[i]] = dp[r][c] + 1;
                        q.offer(new int[]{r + dr[i], c + dc[i]});
                    }
                } else {
                    if (dp[r + dr[i]][c + dc[i]] > dp[r][c]) {
                        dp[r + dr[i]][c + dc[i]] = dp[r][c];
                        q.offer(new int[]{r + dr[i], c + dc[i]});
                    }
                }
            }
        }
        System.out.println(dp[N - 1][M - 1]);
    }
}
