import java.util.*;

class Solution {
    int count=0;
    List<String>alp=List.of("A","E","I","O","U");
    List<String>answer;
    public int solution(String word) {
        answer=new ArrayList<>();
        dfs("",0);
        Collections.sort(answer);
        for(int i=0;i<answer.size();i++){
            if(answer.get(i).equals(word)){
                return i+1;
            }
        }
        return answer.size();
    }
    public void dfs(String word,int depth){
        if(depth==5){
            return;
        }
        for(int i=0;i<5;i++){
            answer.add(word+alp.get(i));
            dfs(word+alp.get(i),depth+1);
        }
    }
}
