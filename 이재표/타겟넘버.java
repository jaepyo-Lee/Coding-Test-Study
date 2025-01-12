import java.util.*;
class Solution {
    int[]nums;
    int t;
    int answer;
    public int solution(int[] numbers, int target) {
        t=target;
        nums=numbers;
        answer=0;
        dfs(0,0);
        return answer;
    }
    private void dfs(int start,int sum){
        if(start==nums.length){
            if(sum==t){
                answer++;
            }
            return;
        }
        dfs(start+1,sum+nums[start]);
        dfs(start+1,sum-nums[start]);
    }
}