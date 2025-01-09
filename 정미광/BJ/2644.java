import java.util.Scanner;

public class Main {
    static int answer = -1;
    static boolean[] visited;

    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int a = sc.nextInt() - 1;
        int b = sc.nextInt() - 1;
        int m = sc.nextInt();
        int[][] board = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            board[x][y] = 1;
            board[y][x] = 1;
        }

        visited = new boolean[n];
        visited[b] = true;
        bfs(b, a, board, 0);
        System.out.print(answer);

        sc.close();
    }

    static void bfs(int b, int a, int[][] board, int count) {
        if (b == a) {
            answer = count;
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (!visited[i] && board[b][i] == 1) {
                visited[i] = true;
                bfs(i, a, board, count + 1);
            }
        }
    }
}