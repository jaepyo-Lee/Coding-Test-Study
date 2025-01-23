
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
//        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= d; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            if (to > d || (to - from) < weight) {
                continue;
            }
            graph.get(from).add(new Node(to, weight));
        }

        int[] dist = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            dist[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        for (int i = 0; i <= d; i++) {
            if (!graph.get(i).isEmpty()) {
                pq.add(new Node(i, i));

                while (!pq.isEmpty()) {
                    Node current = pq.poll();

                    for (Node node : graph.get(current.to)) {
                        int newDist = dist[current.to] + node.weight;
                        if (dist[node.to] > newDist) {
                            dist[node.to] = newDist;
                            for (int j = node.to + 1; j <= d; j++) { //뒷 부분도 함께 갱신
                                dist[j] = Math.min(dist[j], dist[j - 1] + 1);
                            }
                        }
                    }
                }
            }
        }

        System.out.print(dist[d]);

    }
}