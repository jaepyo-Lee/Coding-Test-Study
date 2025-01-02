import java.util.*;
class Solution {
     public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        List<Integer> arr = new ArrayList<>();
        for (int i : B) {
            arr.add(i);
        }
        arr.sort(Comparator.comparingInt(o -> o));
        for (int i = 0; i < A.length; i++) {
            while (!arr.isEmpty()) {
                Integer removed = arr.remove(0);
                if (A[i] < removed) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}
