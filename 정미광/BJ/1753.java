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

        final int INF = 3000001;
        int v = sc.nextInt();
        int e = sc.nextInt();
        int start = sc.nextInt();
        List<List<Node>> graph = new ArrayList<>();
        int[] dist = new int[v + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(elem -> elem.weight));

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(from).add(new Node(to, weight));
        }

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.to] < current.weight) { continue; }

            for (Node node : graph.get(current.to)) {
                int newDist = dist[current.to] + node.weight;
                if (dist[node.to] > newDist) {
                    dist[node.to] = newDist;
                    pq.add(new Node(node.to, newDist));
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

        sc.close();
    }
}
