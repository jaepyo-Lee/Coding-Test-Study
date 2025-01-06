
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int m;
    static int n;
    public static void main(String[] args) {
        solution();
    }
    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int[] moved_x = {-1, 1, 0, 0};
        final int[] moved_y = {0, 0, -1, 1};
        int count = 0;
        int max = 0;
        m = sc.nextInt();
        n = sc.nextInt();
        Queue<int[]> next = new LinkedList<>();
        int[][] board = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || board[i][j] == 0) {
                    continue;
                }
                visited[i][j] = true;
                int x = i;
                int y = j;
                int size = 1;
                next.add(new int[]{x, y});
                count++;
                while (!next.isEmpty()) {
                    int[] current = next.poll();
                    x = current[0];
                    y = current[1];
                    for (int k = 0; k < 4; k++) {
                        int dx = x + moved_x[k];
                        int dy = y + moved_y[k];
                        if (isInRange(dx, dy) && !visited[dx][dy] && board[dx][dy] == 1) {
                            size++; //
                            next.add(new int[]{dx, dy});
                            visited[dx][dy] = true;
                        }
                    }
                }
                if (max < size) {
                    max = size;
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
        sc.close();
    }
    static boolean isInRange(int x, int y) {
        if (x < 0 || x >= m) {
            return false;
        }
        if (y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}