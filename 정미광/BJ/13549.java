
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.print(bfs(n, k));

        sc.close();
    }

    static int bfs(int n, int k) {
        boolean[] visited = new boolean[200001];
        Queue<int[]> next = new LinkedList<>();
        next.add(new int[]{n, 0});
        visited[n] = true;
        while (!next.isEmpty()) {
            int current[] = next.poll();
            int x = current[0];
            int moved = current[1];

            if (x == k) {
                return moved;
            }

            int dx = x * 2;
            if (dx >= 0 && dx < visited.length && !visited[dx]) {
                visited[dx] = true;
                next.add(new int[]{dx, moved});
            }

            dx = x - 1;
            if (dx >= 0 && dx < visited.length && !visited[dx]) {
                visited[dx] = true;
                next.add(new int[]{dx, moved + 1});
            }
            dx = x + 1;
            if (dx >= 0 && dx < visited.length && !visited[dx]) {
                visited[dx] = true;
                next.add(new int[]{dx, moved + 1});
            }
        }
        return 0;
    }
}