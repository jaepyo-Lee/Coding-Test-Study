package bj;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N;
    static int M;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = in[0];
        M = in[1];
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < s.length; j++) {
                map[i][j] = s[j];
            }
        }
        int year = 0;
        boolean chk = true;
        while (chk) {
            year++;
            chk = false;
            int[][] minus = new int[N][M];
            visited = new boolean[N][M];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] == 0) {
                        for (int k = 0; k < 4; k++) {
                            if (r + dr[k] < 0 || c + dc[k] < 0 || r + dr[k] >= N || c + dc[k] >= M) {
                                continue;
                            }
                            if (map[r + dr[k]][c + dc[k]] == 0) {
                                continue;
                            }
                            chk = true;
                            minus[r + dr[k]][c + dc[k]]++;
                        }
                    }
                }
            }
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (map[r][c] != 0) {
                        if (map[r][c] - minus[r][c] >= 0) {
                            map[r][c] -= minus[r][c];
                        } else {
                            map[r][c] = 0;
                        }
                    }
                }
            }
            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != 0 && !visited[i][j]) {
                        answer++;
                        bfs(i, j);
                    }
                }
            }
            if (answer > 1) {
                System.out.println(year);
                break;
            }
            if (!chk) {
                System.out.println(0);
                break;
            }
        }

    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            for (int k = 0; k < 4; k++) {
                if (map[r + dr[k]][c + dc[k]] == 0) {
                    continue;
                }
                if (visited[r + dr[k]][c + dc[k]]) {
                    continue;
                }
                if (r + dr[k] < 0 || r + dr[k] > N || c + dc[k] < 0 || c + dc[k] > M) {
                    continue;
                }
                visited[r + dr[k]][c + dc[k]] = true;
                q.add(new int[]{r + dr[k], c + dc[k]});
            }
        }

    }
}
