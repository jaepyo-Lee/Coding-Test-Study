import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int index_A = 0;
        for (int index_B = 0; index_B < B.length; index_B++) {
            if (B[index_B] > A[index_A]) {
                answer++;
                index_A++;
            }
        }

        return answer;
    }
}