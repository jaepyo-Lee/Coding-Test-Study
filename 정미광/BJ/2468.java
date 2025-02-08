
import java.util.*;

public class Main {
    static int n;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int maxCount = 1; //아무 지역도 물에 잠기지 않았을 경우
        n = sc.nextInt();
        board = new int[n][n];
        PriorityQueue<Integer> elements = new PriorityQueue<>();


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (!elements.contains(board[i][j])) {
                    elements.add(board[i][j]);
                }
            }
        }

        while (!elements.isEmpty()) {
            int elem = elements.poll();
            int count = bfs(elem, n, board);
            if (maxCount <= count) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);

        sc.close();
    }

    static int bfs(int elem, int n, int[][] board) {
        int count = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] <= elem || visited[i][j]) {
                    continue;
                }
                count += getCount(i, j, elem, n, board);
            }
        }
        return count;
    }

    static int getCount(int i, int j, int elem, int n, int[][] board) {
        int[] moved_x = {-1, 1, 0, 0};
        int[] moved_y = {0, 0, -1, 1};
        int count = 0;

        Queue<int[]> next = new LinkedList<>();

        next.add(new int[]{i, j});
        visited[i][j] = true;
        count++;
        while (!next.isEmpty()) {
            int[] current = next.poll();
            int x = current[0];
            int y = current[1];

            for (int k = 0; k < 4; k++) {
                int dx = x + moved_x[k];
                int dy = y + moved_y[k];

                if (isInRange(dx, dy, n) && !visited[dx][dy] && board[dx][dy] > elem) {
                    visited[dx][dy] = true;
                    next.add(new int[]{dx, dy});
                }
            }
        }
        return count;
    }

    static boolean isInRange(int x, int y, int n) {
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}