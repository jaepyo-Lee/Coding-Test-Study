import java.util.*;

public class Main {
    static class Node {
        int to;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int e = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(a).add(new Node(b, weight));
            graph.get(b).add(new Node(a, weight));
        }

        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        long[] dist = dijkstra(n, graph, 1, 0);
        long[] distV1First;
        long[] distV2First;

        distV1First = dijkstra(n, graph, v1, dist[v1]);
        distV1First = dijkstra(n, graph, v2, distV1First[v2]);

        distV2First = dijkstra(n, graph, v2, dist[v2]);
        distV2First = dijkstra(n, graph, v1, distV2First[v1]);

        long answer = Math.min(distV1First[n], distV2First[n]);

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        }
        System.out.print(answer);

        sc.close();
    }

    static long[] dijkstra(int n, List<List<Node>> graph, int start, long value) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(elem -> elem.weight));

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = value;
        pq.add(new Node(start, value));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.to] < current.weight) {
                continue;
            }

            for (Node node : graph.get(current.to)) {
                long newDist = dist[current.to] + node.weight;
                if (dist[node.to] > newDist) {
                    dist[node.to] = newDist;
                    pq.add(new Node(node.to, newDist));
                }
            }
        }

        return dist;
    }
}
