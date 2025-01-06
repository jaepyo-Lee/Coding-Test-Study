
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int x1;
        int y1;
        int x2;
        int y2;
        int[][] board = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        //dp 채우기
        for (int i = 1; i <= n; i++) {
            dp[i][1] = board[i][1];
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + board[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            int sum = 0;
            input = br.readLine().split(" ");
            x1 = Integer.parseInt(input[0]);//1
            y1 = Integer.parseInt(input[1]);//1
            x2 = Integer.parseInt(input[2]);//4
            y2 = Integer.parseInt(input[3]);//4
            for (int x = x1; x <= x2; x++) {
                sum += dp[x][y2];
                sum -= dp[x][y1 - 1];
            }
            answer.append(sum).append("\n");
        }

        System.out.print(answer);

        br.close();
    }


}