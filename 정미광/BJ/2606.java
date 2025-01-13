
import java.util.Scanner;

public class Main {
    static int count = 0;
    static boolean[] visited;
    public static void main(String[] args) {
        solution();
    }
    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        visited = new boolean[n];
        int[][] computers = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            computers[x][y] = 1;
            computers[y][x] = 1;
        }

        visited[0] = true;
        bfs(0, computers);
        System.out.print(count);

        sc.close();
    }
    static void bfs(int computer, int[][] computers) {
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[computer][i] == 1) {
                visited[i] = true;
                count++;
                bfs(i, computers);
            }
        }
    }
}