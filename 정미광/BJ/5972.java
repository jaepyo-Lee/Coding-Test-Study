
import java.util.*;

public class Main {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int N = sc.nextInt();
        final int M = sc.nextInt();
        int start = 1;
        int[] dist = new int[N + 1];//가중치 저장
        Arrays.fill(dist, Integer.MAX_VALUE);
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));//양방향으로 저장
            graph.get(b).add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Node(start, 0));//1부터 시작 (1 -> 1, 가중치 0)
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Node node : graph.get(current.to)) {
                int newDist = dist[current.to] + node.weight;
                if (newDist < dist[node.to]) {
                    dist[node.to] = newDist;
                    pq.add(new Node(node.to, newDist));
                }
            }
        }

        System.out.print(dist[N]);

        sc.close();
    }
}