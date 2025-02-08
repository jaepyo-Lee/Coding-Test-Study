import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

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
//        System.out.println(s.solution(new int[]{547, 54, 5}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt(); //start
        int max = 0;

        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverseGraph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.get(from).add(new Node(to, weight));
            reverseGraph.get(to).add(new Node(from, weight));
        }

        int[] fromX = dijkstra(graph, n, x);
        int[] toX = dijkstra(reverseGraph, n, x);

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, fromX[i] + toX[i]);
        }

        System.out.print(max);

        sc.close();
    }

    static int[] dijkstra(List<List<Node>> graph, int n, int start) {
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
        return dist;
    }
}