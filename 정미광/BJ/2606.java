
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] computers;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) {
        solution();
    }
    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        computers = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            computers[a - 1][b - 1] = 1;
            computers[b - 1][a - 1] = 1;
        }

        visited[0] = true;
        bfs(0);

        System.out.print(count);

        sc.close();
    }
    static void bfs(int index) {
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[index][i] == 1) {
                visited[i] = true;
                count++;
                bfs(i);
            }
        }
    }
}