import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        boolean[][] relation = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int[] in1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            relation[in1[0]][in1[1]] = true;
            relation[in1[1]][in1[0]] = true;
        }
        boolean[] visited = new boolean[n + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{in[0],0});
        visited[in[0]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0]==in[1]){
                System.out.println(cur[1]);
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && relation[cur[0]][i]) {
                    visited[i] = true;
                    q.add(new int[]{i,cur[1]+1});
                }
            }
        }
        System.out.println(-1);
    }
}
