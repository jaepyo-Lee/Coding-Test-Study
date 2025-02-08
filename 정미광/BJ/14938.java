import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(2, 10, new int[]{7,4,5,6}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int INF = Integer.MAX_VALUE;
        int total = 0;
        int sum;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int r = sc.nextInt();
        //최단 거리 <= m
        //각 노드에 해당하는 items 원소들의 합의 최대

        int[] items  = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        long[][] dist = new long[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph[a][b] = c;
            graph[b][a] = c;
        }

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
            sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] <= m) {
                    sum += items[j];
                }
            }
            total = Math.max(total, sum);
        }
        System.out.print(total);

        sc.close();
    }
}