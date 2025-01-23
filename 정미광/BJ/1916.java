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
//        System.out.println(s.solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
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
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        dijkstra(graph, start, end, n);

        sc.close();
    }

    static void dijkstra(List<List<Node>> graph, int start, int end, int n) {
        int[] dist = new int[n + 1];//가중치 저장
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.weight > dist[current.to]) { //시간 초과 오류 원인
                continue;
            }

            for (Node node : graph.get(current.to)) {
                int newDist = dist[current.to] + node.weight;
                if (dist[node.to] > newDist) {
                    dist[node.to] = newDist;
                    pq.add(new Node(node.to, newDist));
                }
            }
        }

        System.out.print(dist[end]);
    }
}