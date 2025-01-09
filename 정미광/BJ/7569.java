import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int answer = -1;
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();
        int notRiped = 0;
        int[][][] tomatoes = new int[h][n][m];


        for (int l = 0; l < h; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    tomatoes[l][i][j] = sc.nextInt();
                    if (tomatoes[l][i][j] == 0) {
                        notRiped++;
                    }
                }
            }
        }


        answer = bfs(n, m, h, tomatoes, notRiped);

        System.out.print(answer);

        sc.close();
    }

    static private int bfs(int n, int m, int h, int[][][] tomatoes, int notRiped) {
        final int[] moved_l = {-1, 1, 0, 0, 0, 0};
        final int[] moved_x = {0, 0, -1, 1, 0, 0};
        final int[] moved_y = {0, 0, 0, 0, -1, 1};
        Queue<int[]> next = new LinkedList<>();
        boolean[][][] visited = new boolean[h][n][m];
        int days = 0;

        if (notRiped == 0) {
            return days;
        }

        for (int l = 0; l < h; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (tomatoes[l][i][j] == -1 || tomatoes[l][i][j] == 0 || visited[l][i][j]) {
                        continue;
                    }
                    next.add(new int[]{l, i, j, days});
                    visited[l][i][j] = true;
                }
            }
        }
        while (!next.isEmpty()) {
            int[] current = next.poll();
            int z = current[0];
            int x = current[1];
            int y = current[2];
            days = current[3];

            for (int k = 0; k < 6; k++) {
                int dz = z + moved_l[k];
                int dx = x + moved_x[k];
                int dy = y + moved_y[k];
                if (isInRange(dz, dx, dy, h, n, m) && tomatoes[dz][dx][dy] == 0) {
                    notRiped--;
                    tomatoes[dz][dx][dy] = 1;
                    next.add(new int[]{dz, dx, dy, days + 1});
                    visited[dz][dx][dy] = true;
                }
            }
        }
        if (notRiped == 0) {
            return days;
        }
        return -1;
    }

    static private boolean isInRange(int z, int x, int y, int h, int n, int m) {
        if (z < 0 || z >= h) {
            return false;
        }
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}