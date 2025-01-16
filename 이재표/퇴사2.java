
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] values = new int[n][2];

        for (int i = 0; i < n; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            values[i][0] = in[0]; 
            values[i][1] = in[1]; 
        }

        int[] dp = new int[n + 1]; 

        for (int i = n - 1; i >= 0; i--) {
            int t = values[i][0];
            int p = values[i][1];

            if (i + t > n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + 1], p + dp[i + t]);
            }
        }

        System.out.println(dp[0]); 
    }
}
