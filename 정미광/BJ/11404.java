import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if (graph[a][b] > c) {
                graph[a][b] = c;
            }
        }

        floydWarshall(graph, n);

        sc.close();
    }

    static void floydWarshall(int[][] graph, int n) {
        long[][] dist = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    dist[i][j] = 0;
                }
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}