import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args)  throws IOException{
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        final int[] moved_x = {-1, 1, 0, 0};
        final int[] moved_y = {0, 0, -1, 1};
        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);
        int answer = 0;
        char[][] board = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> next = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String text = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = text.charAt(j);
            }
        }

        next.add(new int[]{0, 0, 1});
        while(!next.isEmpty()) {
            int[] current = next.poll();
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (x == N - 1 && y == M - 1) {
                answer = count;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = x + moved_x[i];
                int dy = y + moved_y[i];
                if (isInRange(dx, dy, N, M) && !visited[dx][dy] && board[dx][dy] == '1') {
                    visited[dx][dy] = true;
                    next.add(new int[]{dx, dy, count + 1});
                }
            }
        }

        System.out.println(answer);
        br.close();
    }

    private static boolean isInRange(int x, int y, int n, int m) {
        if (x < 0 || x >= n) {
            return false;
        }
        if (y < 0 || y >= m) {
            return false;
        }
        return true;
    }
}