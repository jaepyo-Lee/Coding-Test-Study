
import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int[] moved_x = {-1, 1, 0, 0};
        int[] moved_y = {0, 0, -1, 1};
        int m = sc.nextInt();
        int n = sc.nextInt();
        char[][] board = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> next = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));//벽을 최소한으로 부셔야 함

        for (int i = 0; i < n; i++) {
            String input = sc.next();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        next.add(new int[]{0, 0, 0});
        while (!next.isEmpty()) {
            int[] current = next.poll();
            int x = current[0];
            int y = current[1];
            int breakedWalls = current[2];

            if (x == n - 1 && y == m - 1) {
                System.out.println(breakedWalls);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = x + moved_x[i];
                int dy = y + moved_y[i];

                if (isInRange(dx, dy, n, m) && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    if (board[dx][dy] == '1') {
                        next.add(new int[]{dx, dy, breakedWalls + 1});
                    } else {
                        next.add(new int[]{dx, dy, breakedWalls});
                    }
                }
            }
        }

        sc.close();
    }

    static boolean isInRange(int x, int y, int n, int m) {
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}