import java.util.*;
class Solution {
    int index=1;
    Map<String,Integer>dic;
    public int[] solution(String msg) {
        dic=new HashMap<>();
        for(char start='A';start<='Z';start++){
            dic.putIfAbsent(String.valueOf(start),index++);
        }
        List<Integer>answer=new ArrayList<>();

        while(msg.length()!=0){
            int start=1;
            while(msg.length()>=start && dic.containsKey(msg.substring(0,start))){
                start++;
            }    
            answer.add(dic.get(msg.substring(0,start-1)));
            if(msg.length()>start){
                dic.putIfAbsent(msg.substring(0,start),index++);
            }
            msg=msg.substring(start-1);
        }
        
        int[]ans=new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            ans[i]=answer.get(i);
        }
        return ans;
    }
}
