import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
//                new int[]{500, 600, 150, 800, 2500}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int INF = Integer.MAX_VALUE;
        int v = sc.nextInt();
        int e = sc.nextInt();

        long[][] dist = new long[v + 1][v + 1];
        int[][] graph = new int[v + 1][v + 1];
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                graph[i][j] = INF; //왕복이 가능하기 때문에 graph[i][i] = 0을 삭제
            }
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph[from][to] = weight;
        }

        for (int i = 0; i <= v; i++) {
            for (int j = 0; j <= v; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        for (int k = 1; k <= v; k++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        long minCycle = INF;
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                minCycle = Math.min(minCycle, dist[i][j] + dist[j][i]); //최소 왕복 거리 찾기
            }
        }

        if (minCycle == INF) {
            minCycle = -1;
        }
        System.out.print(minCycle);

        sc.close();
    }
}