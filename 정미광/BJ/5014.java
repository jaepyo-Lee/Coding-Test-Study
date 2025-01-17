
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int F = sc.nextInt();
        final int S = sc.nextInt();
        final int G = sc.nextInt();
        final int U = sc.nextInt();
        final int D = sc.nextInt();

        if (S == G) {
            System.out.println(0);
            return;
        }

        int moved = bfs(F, S, G, U, D);
        if (moved > 0) {
            System.out.println(moved);
        } else {
            System.out.println("use the stairs");
        }

        sc.close();
    }

    static int bfs(int f, int s, int g, int u, int d) {
        boolean[] visited = new boolean[f + 1];
        Queue<int[]> next = new LinkedList<>();

        next.add(new int[]{s, 0});
        visited[s] = true;
        while (!next.isEmpty()) {
            int[] current = next.poll();
            int floor = current[0];
            int moved = current[1];

            if (floor == g) {
                return moved;
            }

            int dFloor = floor + u;
            if (dFloor > 0 && dFloor <= f && !visited[dFloor]) {
                visited[dFloor] = true;
                next.add(new int[]{dFloor, moved + 1});
            }

            dFloor = floor - d;
            if (dFloor > 0 && dFloor <= f && !visited[dFloor]) {
                visited[dFloor] = true;
                next.add(new int[]{dFloor, moved + 1});
            }
        }
        return 0;
    }
}