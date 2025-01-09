import java.util.*;
class Solution {
    boolean[]visit;
    int[][] network;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit=new boolean[n];
        network=computers;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer++;
                dfs(n,i);
            }
        }
        return answer;
    }
    public void dfs(int n,int start){
        visit[start]=true;
        for(int i=0;i<n;i++){
            if(network[start][i]==1 && visit[i]==false){
                dfs(n,i);
            }
        }
    }
}
