import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String name;
        Integer value;

        public Node(String name, Integer value) {
            this.name = name;
            this.value = value;
        }
    }

    static Map<Integer, List<Node>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = arr[0];
        int M = arr[1];
        String S = br.readLine();
        map = new HashMap<>();

        for (int i = 0; i < N-1; i++) {
            String[] in = br.readLine().split(" ");
            map.putIfAbsent(Integer.parseInt(in[0]), new ArrayList<>());
            map.putIfAbsent(Integer.parseInt(in[1]), new ArrayList<>());
            map.get(Integer.parseInt(in[0])).add(new Node(in[2], Integer.parseInt(in[1])));
            map.get(Integer.parseInt(in[1])).add(new Node(in[2], Integer.parseInt(in[0])));
        }

        boolean[] visited = new boolean[N + 1];
        Queue<Road> q = new LinkedList<>();
        q.add(new Road(1, new StringBuilder()));
        int answer = 0;

        while (!q.isEmpty()) {
            Road r = q.poll();
            if (visited[r.lastIdx]) {
                continue; 
            }
            visited[r.lastIdx] = true;

            boolean isDeadEnd = true;
            for (Node n : map.getOrDefault(r.lastIdx, new ArrayList<>())) {
                if (!visited[n.value]) {
                    isDeadEnd = false;
                    q.offer(new Road(n.value, new StringBuilder(r.name).append(n.name)));
                }
            }

            if (isDeadEnd) {
                answer = Math.max(answer, calculateLCS(r.name.toString(), S));
            }
        }

        System.out.println(answer);
    }

    private static int calculateLCS(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    static class Road {
        int lastIdx;
        StringBuilder name;

        public Road(int lastIdx, StringBuilder name) {
            this.lastIdx = lastIdx;
            this.name = name;
        }
    }
}
