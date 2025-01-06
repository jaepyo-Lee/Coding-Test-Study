package bj;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visit;
    static List<List<Integer>> virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        virus = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            virus.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int[] pair = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            virus.get(pair[0]).add(pair[1]);
            virus.get(pair[1]).add(pair[0]);
        }
        dfs(1);
        System.out.println(count-1);
    }

    static int count = 0;

    private static void dfs(int start) {
        count++;
        visit[start] = true;
        List<Integer> to = virus.get(start);
        for (Integer v : to) {
            if(!visit[v]){
                dfs(v);
            }
        }

    }
}
