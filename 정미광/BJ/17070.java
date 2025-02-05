import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(n, map, 0, 1, 0);

        System.out.print(count);

        sc.close();
    }
    //가로 = 0, 세로 = 1, 대각선 = 2
    static void dfs(int n, int[][] map, int x, int y, int status) {
        if (x == n - 1 && y == n - 1) {
            count++;
            return;
        }
        if (x >= n || y >= n) {
            return;
        }
        if (map[x][y] == 1) {
            return;
        }

        //대각선은 모든 방향으로부터 진행 가능 -> map[x][y + 1] & map[x + 1][y]를 확인해야 하는 이유
        if (x + 1 < n && y + 1 < n && map[x + 1][y + 1] == 0 && map[x][y + 1] == 0 && map[x + 1][y] == 0) {
            dfs(n, map, x + 1, y + 1, 2);
        }
        if (status != 0 && x + 1 < n && map[x + 1][y] == 0) {
            dfs(n, map, x + 1, y, 1);
        }
        if (status != 1 && y + 1 < n && map[x][y + 1] == 0) {
            dfs(n, map, x, y + 1, 0);
        }
    }
}
