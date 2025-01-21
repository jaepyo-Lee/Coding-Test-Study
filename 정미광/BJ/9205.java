
import java.util.*;

public class Main {
    static int limit;
    static boolean[] visited;
    static boolean happy;

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        final int T = sc.nextInt();
        for (int testCase = 0; testCase < T; testCase++) {
            int n = sc.nextInt();
            limit = 20 * 50;
            int[][] spots = new int[n + 2][2];
            int[][] distances = new int[n + 2][n + 2];
            visited = new boolean[n + 2];
            happy = false;

            for (int i = 0; i < n + 2; i++) {
                for (int j = 0; j < 2; j++) {
                    spots[i][j] = sc.nextInt();
                }
            }

            //바로 페스티벌로 갈 수 있는 경우
            int distance = Math.abs(spots[0][0] - spots[n + 1][0]) + Math.abs(spots[0][1] - spots[n + 1][1]);
            if (distance <= limit) {
                sb.append("happy").append("\n");
                continue;
            }

            for (int j = 0; j < n + 1; j++) {
                for (int i = 1; i < n + 2; i++) {
                    distances[j][i] = Math.abs(spots[j][0] - spots[i][0]) + Math.abs(spots[j][1] - spots[i][1]);
                }
            }

            visited[0] = true;
            for (int i = 1; i < n + 2; i++) {
                if (distances[0][i] > 0 && distances[0][i] <= limit) {
                    visited[i] = true;
                    bfs(i, distances);
                }
            }

            if (happy) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
        }

        System.out.print(sb);
        sc.close();
    }

    static void bfs(int index, int[][] distances) {
        if (index == (distances.length - 1)) {
            happy = true;
            return;
        }

        for (int i = 1; i < distances.length; i++) {
            if (!visited[i] && distances[index][i] <= limit) {
                visited[i] = true;
                bfs(i, distances);
            }
        }
    }
}