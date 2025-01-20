
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> distance = new ArrayList<>();
        if (in[0] != 0) {
            int[] map = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < in[0]; i++) {
                distance.add(map[i]);
            }
        }
        distance.add(0);
        distance.add(in[2]);
        Collections.sort(distance);
        int left = 1;
        int right = in[2];
        while (left <= right) {
            int mid = (right + left) / 2;
            int count = 0;
            for (int i = 1; i < distance.size(); i++) {
                int term = distance.get(i) - distance.get(i - 1) - 1;
                count += term / mid;
            }
            if (count > in[1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}
