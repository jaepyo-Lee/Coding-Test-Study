import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr;

        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] max = Arrays.copyOf(arr, 3);

        int[] min = Arrays.copyOf(arr, 3);

        for (int j = 1; j < n; j++) {
            int prevMax0 = max[0];
            int prevMax1 = max[1];
            int prevMax2 = max[2];

            int prevMin0 = min[0];
            int prevMin1 = min[1];
            int prevMin2 = min[2];

            arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            max[0] = arr[0] + Math.max(prevMax0, prevMax1);
            max[1] = arr[1] + Math.max(Math.max(prevMax0, prevMax1), prevMax2);
            max[2] = arr[2] + Math.max(prevMax1, prevMax2);

            min[0] = arr[0] + Math.min(prevMin0, prevMin1);
            min[1] = arr[1] + Math.min(Math.min(prevMin0, prevMin1), prevMin2);
            min[2] = arr[2] + Math.min(prevMin1, prevMin2);
        }

        System.out.println(Math.max(Math.max(max[0], max[1]), max[2]) + " " + Math.min(Math.min(min[0], min[1]), min[2]));
    }
}
