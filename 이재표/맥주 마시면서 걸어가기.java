import java.io.*;
import java.util.*;

public class Main {
    static int festivalR;
    static int festivalC;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            List<int[]> map = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            int[] house = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map.add(house);

            for (int j = 0; j < n; j++) {
                int[] convenience = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                map.add(convenience);
            }

            int[] festival = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            festivalR = festival[0];
            festivalC = festival[1];
            map.add(festival);

            if (bfs(map)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs(List<int[]> map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(map.get(0));
        boolean[] visit = new boolean[map.size()];
        visit[0] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();

            if (Math.abs(festivalR - current[0]) + Math.abs(festivalC - current[1]) <= 1000) {
                return true;
            }

            for (int i = 1; i < map.size(); i++) {
                if (!visit[i]) {
                    int[] next = map.get(i);
                    if (Math.abs(current[0] - next[0]) + Math.abs(current[1] - next[1]) <= 1000) {
                        visit[i] = true;
                        q.add(next);
                    }
                }
            }
        }

        return false;
    }
}
