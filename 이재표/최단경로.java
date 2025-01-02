import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int[] dist;
    static int N;
    static int M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        //행이 시작, 열이 끝
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);
            int price = Integer.parseInt(split[2]);
            if (arr[start][end] > price) {
                arr[start][end] = price;
            }
        }
        String[] split = br.readLine().split(" ");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        dijkstra(start);
        System.out.println(dist[end]);
    }
    static void dijkstra(int start) {
        boolean[] visited = new boolean[N + 1];
        dist[start] = 0;
        visited[0] = true;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->dist[o1]-dist[o2]);
        pq.add(start);
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if(!visited[curr]) {
                visited[curr] = true;
            }else{
                continue;
            }
            for(int i=1;i<=N;i++) {
                if(arr[curr][i]==Integer.MAX_VALUE || i==curr) {
                    continue;
                }
                if(!visited[i] && dist[i] > dist[curr] + arr[curr][i]) {
                    dist[i] = dist[curr] + arr[curr][i];
                    pq.add(i);
                }
            }
        }
    }
}
