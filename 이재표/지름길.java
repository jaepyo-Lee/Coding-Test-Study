import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = in[0];
        int D = in[1];
        int[] dp = new int[D + 1];
        for (int i = 0; i <= D; i++) {
            dp[i] = i;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (input[1] > D) {
                continue;
            }
            list.add(input);
        }
        list.sort((a, b) -> a[0] - b[0]);
        for (int i = 0; i <= D; i++) {
            if(i>0){
                dp[i]=Math.min(dp[i],dp[i-1]+1);
            }
            for (int[] input : list) {
                int s = input[0];
                int e = input[1];
                int c = input[2];
                if(s==i){
                    dp[e] = Math.min(dp[s] + c, dp[e]);
                }
            }
        }
        System.out.println(dp[D]);
    }
}
