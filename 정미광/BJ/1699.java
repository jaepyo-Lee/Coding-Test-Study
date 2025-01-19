
import static java.lang.Math.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        //1 = 1
        //2 = 1 + 1
        //3 = 1 + 1 + 1
        //4 = 2
        //5 = 2 + 1
        //6 = 2 + 1 + 1
        //7 = 2 + 1 + 1 + 1
        //8 = 2 + 2
        //9 = 3
        //10 = 3 + 1
        //11 = 3 + 1 + 1
        //12 = 3 + 1 + 1 + 1
        //13 = 3 + 2
        //14 = 3 + 2 + 1
        //15 = 3 + 2 + 1 + 1
        //16 = 4
        //17 = 4 + 1
        //18 = 4 + 1 + 1
        //19 = 4 + 1 + 1 + 1
        //20 = 4 + 2
        //21 = 4 + 2 + 1
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        if (n < 4) {
            System.out.print(n);
            return;
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4, j = 1; i <= n; i++, j++) {
            int elem = (int)sqrt(i);
            if (i == elem * elem) {
                dp[i] = 1;
                j = 0;
                continue;
            }

            dp[i] = dp[j] + 1; //41: 6 + 2 + 1

            for (int k = 1; k <= (i / 2); k++) { //41: 5 + 4
                dp[i] = min(dp[i], dp[k] + dp[i - k]);
            }
        }

        System.out.print(dp[n]);

        sc.close();
    }
}