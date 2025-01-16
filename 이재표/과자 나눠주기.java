import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] cookie = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = in[0];
        int N = in[1];
        Arrays.sort(cookie);
        int start = 1;
        int end = cookie[cookie.length - 1];
        while (start <= end) {
            int mid = (start + end) / 2;
            int answer = 0;
            for (int i = 0; i < N; i++) {
                answer += cookie[i] / mid;
            }
            if (answer < M) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(end);
    }
}
