
import java.util.*;

public class Main {
    static int m;
    static int n;
    public static void main(String[] args) {
        solution();

//        Solution s = new Solution();
//        System.out.println(s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
//        System.out.println(s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int[] moved_x = {-1, 1, 0, 0};
        final int[] moved_y = {0, 0, -1, 1};
        m = sc.nextInt();
        n = sc.nextInt();
        char[][] maps = new char[m][n];
        for (int i = 0; i < m; i++) {
             maps[i] = sc.next().toCharArray();
        }
        Queue<int[]> destination = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int answer = 0;

        for (int height = 0; height < m; height++) {
            for (int width = 0; width < n; width++) {
                if (maps[height][width] == 'W') {
                    continue;
                }
                destination.add(new int[]{height, width, 0});
                visited[height][width] = true;
                while (!destination.isEmpty()) {
                    int[] current = destination.poll();
                    int x = current[0];
                    int y = current[1];
                    int moved = current[2];
                    if (moved > answer) {
                        answer = moved;//moved의 최댓값을 answer에 저장
                    }

                    for (int i = 0; i < 4; i++) {
                        int dx = x + moved_x[i];
                        int dy = y + moved_y[i];
                        if (isInRange(dx, dy) && !visited[dx][dy] && maps[dx][dy] == 'L') {
                            visited[dx][dy] = true;
                            destination.add(new int[]{dx, dy, moved + 1});
                        }
                    }
                }
                visited = new boolean[m][n];
            }
        }

        System.out.print(answer);
        sc.close();
    }
    static boolean isInRange(int x, int y) {
        if (x < 0 || x >= m) {
            return false;
        }
        if (y < 0 || y >= n) {
            return false;
        }
        return true;
    }
}