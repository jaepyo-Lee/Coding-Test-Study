
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int F = in[0];
        int S = in[1];
        int G = in[2];
        int U = in[3];
        int D = in[4];

        boolean[] visit = new boolean[F + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});
        visit[S] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int position = current[0];
            int steps = current[1];

            if (position == G) {
                System.out.println(steps);
                return;
            }

            if (position + U <= F && !visit[position + U]) {
                visit[position + U] = true;
                q.add(new int[]{position + U, steps + 1});
            }

            if (position - D >= 1 && !visit[position - D]) {
                visit[position - D] = true;
                q.add(new int[]{position - D, steps + 1});
            }
        }
        System.out.println("use the stairs");
    }
}
