import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = in[0];
        K = in[1];
        dp = new int[200001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{K, 0});
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int position = current[0];
            int time = current[1];

            if (dp[position] <= time) {
                continue;
            }
            dp[position] = time;

            if (position == N) {
                continue;
            }

            if (position % 2 == 0 && position / 2 >= 0 && dp[position / 2] > time) {
                q.add(new int[]{position / 2, time});
            }
            if (position + 1 <= 200000 && dp[position + 1] > time + 1) {
                q.add(new int[]{position + 1, time + 1});
            }
            if (position - 1 >= 0 && dp[position - 1] > time + 1) {
                q.add(new int[]{position - 1, time + 1});
            }
        }
        System.out.println(dp[N]);
    }
}
