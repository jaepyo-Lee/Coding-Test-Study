import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int AIdx=0;
        int BIdx=0;
        int score=0;
        while(AIdx<A.length && BIdx<A.length ){
            if(A[AIdx]>=B[BIdx]){
                BIdx++;
            }
            else if(A[AIdx]<B[BIdx]){
                AIdx++;
                BIdx++;
                score++;
            }
        }
        return score;
    }
}
