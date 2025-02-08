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
//        Solution s = new Solution();
//        System.out.println(s.solution(new String[]{"classic", "pop", "classic", "classic", "pop"},
//                new int[]{500, 600, 150, 800, 2500}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(from).add(new Node(to, weight));
            graph.get(to).add(new Node(from, weight));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (dist[current.to] < current.weight) {
                continue;
            }

            for (Node node : graph.get(current.to)) {
                int newDist = dist[current.to] + node.weight;
                if (newDist < dist[node.to]) {
                    dist[node.to] = newDist;
                    pq.add(new Node(node.to, newDist));
                }
            }
        }

        System.out.print(dist[end]);

        sc.close();
    }
}