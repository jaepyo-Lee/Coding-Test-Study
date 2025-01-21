package bj;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<int[]>> graph = new ArrayList<>();
        int n = input[0];
        int m = input[1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = in[0];
            int b = in[1];
            int c = in[2];
            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }
        int[] answer = new int[n + 1];
        boolean[] visit = new boolean[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[0] = 0;
        answer[1] = 0;
        visit[0] = true;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });
        pq.add(new int[]{1, 0});
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currNode = current[0];
            int currDist = current[1];

            if (currDist > answer[currNode]) {
                continue;
            }

            for (int[] neighbor : graph.get(currNode)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int nextDist = currDist + weight;

                if (nextDist < answer[nextNode]) {
                    answer[nextNode] = nextDist;
                    pq.add(new int[]{nextNode, nextDist});
                }
            }
        }
        System.out.println(answer[n]);
    }

}
