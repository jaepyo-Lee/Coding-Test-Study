import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int MOD = 1000000;
        n = s.length();
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }
        for (int i = 2; i <= n; i++) {
            int single=Character.getNumericValue(s.charAt(i - 1));
            int two = Integer.parseInt(s.substring(i - 2, i));
            if(single>=1 && single<=9){
                dp[i] = (dp[i] + dp[i - 1]) % MOD;
            }
            if(two>=10 && two<=26){
                dp[i] = (dp[i] + dp[i - 2]) % MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
