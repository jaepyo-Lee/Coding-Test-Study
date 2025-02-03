import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(2, 10, new int[]{7,4,5,6}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        final int[] MOVED_X = {-1, 1, 0, 0};
        final int[] MOVED_Y = {0, 0, -1, 1};
        int turn = 0;
        int n;
        int[][] map;
        boolean[][] visited;
        PriorityQueue<int[]> next; //PriorityQueue 생각해보기

        //bfs
        while (true) {
            turn++;
            n = sc.nextInt();
            if (n == 0) { break; }
            map = new int[n][n];
            visited = new boolean[n][n];
            next = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            next.add(new int[]{0, 0, map[0][0]});
            visited[0][0] = true;
            while (!next.isEmpty()) {
                int[] current = next.poll();
                int x = current[0];
                int y = current[1];
                int weight = current[2];

                if (x == n - 1 && y == n - 1) {
                    sb.append("Problem " + turn + ": " + weight + "\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int dx = x + MOVED_X[i];
                    int dy = y + MOVED_Y[i];
                    if (isInRange(dx, dy, n) && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        next.add(new int[]{dx, dy, weight + map[dx][dy]});
                    }
                }
            }
            next.clear();
        }
        System.out.print(sb);

        sc.close();
    }

    static boolean isInRange(int x, int y, int n) {
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}