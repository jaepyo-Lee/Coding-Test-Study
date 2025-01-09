import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        final int[] moved_x = {-1, 1, 0, 0};
        final int[] moved_y = {0, 0, -1, 1};
        int answer = -1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> next = new LinkedList<>();

        next.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        while (!next.isEmpty()) {
            int[] current = next.poll();
            int x = current[0];
            int y = current[1];
            int moved = current[2];

            if (x == n - 1 && y == m - 1) {
                return moved;
            }

            for (int i = 0; i < 4; i++) {
                int dx = x + moved_x[i];
                int dy = y + moved_y[i];

                if (isInRange(dx, dy, n, m) && !visited[dx][dy] && maps[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    next.add(new int[]{dx, dy, moved + 1});
                }
            }
        }

        return answer;
    }

    boolean isInRange(int x, int y, int n, int m) {
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}