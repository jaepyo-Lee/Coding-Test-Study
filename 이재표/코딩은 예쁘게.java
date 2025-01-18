import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] original = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] correct = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int answer = 0;
        while (!isSame(original, correct)) {
            int start = 0;
            int end = 0;
            boolean bigger = true;
            for (int j = 0; j < n; j++) {
                if (original[j] != correct[j]) {
                    if (original[j] < correct[j]) {
                        bigger = false;
                    }
                    start = j;
                    end = j;
                    break;
                }
            }
            if (start != n - 1) {
                for (int j = start + 1; j < n; j++) {
                    if(bigger&&original[j]>correct[j]|| !bigger&&original[j]<correct[j]){
                        end = j;
                    }else{
                        break;
                    }
                }
            }

            int gap = Integer.MAX_VALUE;
            for(int j=start;j<=end;j++){
                gap = Math.min(gap, Math.abs(original[j] - correct[j]));
            }
            answer += gap;
            for(int j=start;j<=end;j++){
                if(bigger){
                    original[j] -= gap;
                }else{
                    original[j] += gap;
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean isSame(int[] original, int[] correct) {
        for (int i = 0; i < correct.length; i++) {
            if (original[i] != correct[i]) {
                return false;
            }
        }
        return true;
    }
}
