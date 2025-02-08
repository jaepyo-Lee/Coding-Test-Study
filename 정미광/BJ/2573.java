
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int[] MOVED_X = {-1, 1, 0, 0};
        final int[] MOVED_Y = {0, 0, -1, 1};
        final int N = sc.nextInt();
        final int M = sc.nextInt();
        int[][] board = new int[N][M];
        int count = 1;
        int years = -1;
        boolean[][] visited;
        Queue<int[]> next = new LinkedList<>();
        Queue<int[]> melting = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (count != 0 && count < 2) {
            years++;
            count = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0 || visited[i][j]) {
                        continue;
                    }
                    count++;
                    next.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!next.isEmpty()) {
                        int[] current = next.poll();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k < 4; k++) {
                            int dx = x + MOVED_X[k];
                            int dy = y + MOVED_Y[k];

                            if (isInRange(dx, dy, N, M) && board[dx][dy] == 0) {
                                melting.add(new int[]{x, y});
                            }

                            if (isInRange(dx, dy, N, M) && !visited[dx][dy] && board[dx][dy] != 0) {
                                visited[dx][dy] = true;
                                next.add(new int[]{dx, dy});
                            }
                        }
                    }
                    while (!melting.isEmpty()) {
                        int[] melt = melting.poll();
                        board[melt[0]][melt[1]]--;
                        if (board[melt[0]][melt[1]] < 0) {
                            board[melt[0]][melt[1]] = 0;
                        }
                    }
                }
            }
        }
        if (count < 2) {
            years = 0;
        }
        System.out.println(years);

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