import java.util.*;
public class Main {

    public int solution(int n, int m, int[][] maze) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[0][0] = true;

        int row, col, count;
        while (!queue.isEmpty()) {
            int[] nodeIndex = queue.poll();
            row = nodeIndex[0];
            col = nodeIndex[1];
            count = nodeIndex[2];

            if (row < n - 1) {
                if (!visited[row + 1][col] && maze[row + 1][col] == 1) {
                    visited[row + 1][col] = true;
                    queue.offer(new int[]{row + 1, col, count + 1});
                }
            }
            if (row > 0) {
                if (!visited[row - 1][col] && maze[row - 1][col] == 1) {
                    visited[row - 1][col] = true;
                    queue.offer(new int[]{row - 1, col, count + 1});
                }
            }
            if (col < m - 1) {
                if (!visited[row][col + 1] && maze[row][col + 1] == 1) {
                    visited[row][col + 1] = true;
                    queue.offer(new int[]{row, col + 1, count + 1});
                }
            }
            if (col > 0) {
                if (!visited[row][col - 1] && maze[row][col - 1] == 1) {
                    visited[row][col - 1] = true;
                    queue.offer(new int[]{row, col - 1, count + 1});
                }
            }
            if (visited[n - 1][m - 1]) {
                answer = count;
                break;
            }
        }
        return ++answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.next();
        }

        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(arr[i].charAt(j)));
            }
        }
        int solution = T.solution(n, m, maze);
        System.out.println(solution);
    }
}
