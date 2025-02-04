import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(new int[]{547, 54, 5}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int INF = Integer.MAX_VALUE;
        int count = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        int[][] reverseGraph = new int[n + 1][n + 1];
        long[][] dist = new long[n + 1][n + 1];
        long[][] reverseDist = new long[n + 1][n + 1];
        boolean[][] linked = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            Arrays.fill(reverseGraph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
            reverseGraph[i][i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            reverseGraph[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = graph[i][j];
                reverseDist[i][j] = reverseGraph[i][j];
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    reverseDist[i][j] = Math.min(reverseDist[i][j], reverseDist[i][k] + reverseDist[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && dist[i][j] != INF || reverseDist[i][j] != INF) {
                    linked[i][j] = true;
                }
            }
        }

        boolean flag;
        for (int i = 1; i <= n; i++) {
            flag = true;
            for (int j = 1; j <= n; j++) {
                if (!linked[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        System.out.print(count);

        sc.close();
    }
}