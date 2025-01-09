import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[]dr={0,0,1,-1};
        int[]dc={1,-1,0,0};
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[]current=q.poll();
            int r=current[0];
            int c=current[1];
            if(r==maps.length-1 && c==maps[0].length-1){
                return current[2]+1;
            }
            for(int i=0;i<4;i++){
                if(r+dr[i]<0 || r+dr[i]>=maps.length || c+dc[i]<0 || c+dc[i]>=maps[0].length || maps[r+dr[i]][c+dc[i]]==0){
                    continue;
                }
                maps[r+dr[i]][c+dc[i]]=0;
                q.offer(new int[]{r+dr[i],c+dc[i],current[2]+1});
            }    
        }
        
        return -1;
    }
}
