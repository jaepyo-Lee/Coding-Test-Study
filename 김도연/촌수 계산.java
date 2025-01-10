import java.util.*;

public class Main {

    public int solution(int n, int m, int[][] relations, int count) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] arr = new boolean[count][count];
        boolean[][] visited = new boolean[count][count];

        for (int i = 0; i < relations.length; i++) {
            int row = relations[i][0] - 1;
            int col = relations[i][1] - 1;
            arr[row][col] = true;
            arr[col][row] = true;
        }
        queue.offer(new int[]{n - 1, 0});
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int idx = tmp[0];
            int moveCount = tmp[1];
            for (int i = 0; i < arr[0].length; i++) {
                if (arr[idx][i] && !visited[idx][i]) {
                    if (i == m - 1) return ++moveCount;
                    visited[idx][i] = true;
                    visited[i][idx] = true;
                    queue.offer(new int[]{i, moveCount + 1});
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());
        int b = Integer.parseInt(scanner.next());
        int[][] relations = new int[b][2];
        for (int i = 0; i < b; i++) {
            relations[i][0] = Integer.parseInt(scanner.next());
            relations[i][1] = Integer.parseInt(scanner.next());
        }
        int solution = T.solution(n, m, relations, a);
        System.out.println(solution);
    }
}
