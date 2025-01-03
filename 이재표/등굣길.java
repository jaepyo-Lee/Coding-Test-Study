import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        // 0-based
        boolean[][]visit=new boolean[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(visit[i],true);
        }
        for(int i=0;i<puddles.length;i++){
            visit[puddles[i][0]-1][puddles[i][1]-1]=false;
        }
        int[][]dp=new int[m][n];
        dp[0][0]=1;
        for(int i=1;i<m;i++){
            if(!visit[i][0]){
                continue;
            }
            dp[i][0]=dp[i-1][0];
        }
        for(int i=1;i<n;i++){
            if(!visit[0][i]){
                continue;
            }
            dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(!visit[i][j]){
                    dp[i][j]=0;
                    continue;
                }
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
            }
        }
        return dp[m-1][n-1];
    }
}
