
import java.util.*;

public class Main {
    static class Node {
        int from;
        int to;
        int weight;
        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Node[] nodes = new Node[m]; //그래프
        long[] dist = new long[n + 1]; //가중치 저장
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        //그래프 생성
        for (int i = 0; i < m; i++) {
            nodes[i] = new Node(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        for (int i = 0; i < n - 1; i++) {
            for (Node node : nodes) {
                //무제한인 것 확인
                if (dist[node.from] != Long.MAX_VALUE && dist[node.to] > dist[node.from] + node.weight) {
                    dist[node.to] = dist[node.from] + node.weight;
                }
            }
        }

        for (Node node : nodes) {
            if (dist[node.from] != Long.MAX_VALUE && dist[node.to] > dist[node.from] + node.weight) {
                System.out.println("-1");
                return;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (dist[i] == Long.MAX_VALUE) {
                dist[i] = -1;
            }
            System.out.println(dist[i]);
        }

    }
}