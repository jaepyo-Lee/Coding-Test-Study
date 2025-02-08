
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        //그래프 생성
        final int N = sc.nextInt();
        int[][] graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        //탐색
        floydWarshall(graph, N);

        sc.close();
    }

    static void floydWarshall(int[][] graph, int n) {
        final int INF = 1000000000;//무한대로 할 경우 합을 구할 때 오류

        int[][] answer = new int[n][n];
        int[][] dist = new int[n][n];//가중치 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (dist[i][j] == 0) { //연결되지 않은 곳의 가중치는 무한대
                    dist[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);//거쳐서 갈 수 있는 것 검사
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int d = dist[i][j];
                if (d == INF) {
                    answer[i][j] = 0;
                } else {
                    answer[i][j] = 1;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}