package bj;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        R = in[0];
        C = in[1];
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int maxDistance = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(r, c));
                }
            }
        }

        System.out.println(maxDistance);
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    private static int bfs(int startR, int startC) {
        int[][] distance = new int[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(distance[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startR, startC});
        distance[startR][startC] = 0;

        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 'L' && distance[nr][nc] == -1) {
                    distance[nr][nc] = distance[r][c] + 1;
                    maxDist = Math.max(maxDist, distance[nr][nc]);
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        return maxDist;
    }
}
