
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int[] dn = {-1, 1};
        int n = sc.nextInt();
        int k = sc.nextInt();
        int min = 0;
        boolean[] visited = new boolean[n + k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {n, 0});
        visited[n] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int current_n = current[0];
            int time = current[1];
            if (current_n == k) {
                if (min == 0 || time < min) {
                    min = time;
                }
            }

            if (current_n * 2 >= 0 && current_n * 2 < visited.length && !visited[current_n * 2]) {
                visited[current_n * 2] = true;
                queue.add(new int[] {current_n * 2, time});
            }
            for (int i = 0; i < 2; i++) {
                if (current_n + dn[i] >= 0 && current_n + dn[i] < visited.length && !visited[current_n + dn[i]]) {
                    visited[current_n + dn[i]] = true;
                    queue.add(new int[] {current_n + dn[i], time + 1});
                }
            }
        }
        System.out.print(min);

        sc.close();
    }
}