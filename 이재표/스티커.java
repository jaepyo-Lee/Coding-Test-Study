
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            for (int j = 0; j < 2; j++) {
                sticker[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int[][]dp=new int[2][n];
            if (n == 1) {
                // 열이 1개인 경우, 최대 점수는 두 스티커 중 큰 값
                System.out.println(Math.max(sticker[0][0], sticker[1][0]));
                continue;
            }
            dp[0][1]=sticker[0][1]+sticker[1][0];
            dp[1][1]=sticker[1][1]+sticker[0][0];
            dp[0][0]=sticker[0][0];
            dp[1][0]=sticker[1][0];
            for(int j=2;j<n;j++){
                dp[0][j]=Math.max(dp[1][j-1],dp[1][j-2])+sticker[0][j];
                dp[1][j]=Math.max(dp[0][j-1],dp[0][j-2])+sticker[1][j];
            }

            System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));

        }
    }
}
