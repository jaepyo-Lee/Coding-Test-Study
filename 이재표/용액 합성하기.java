import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] in;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(in);

        int left = 0;
        int right = n - 1;
        int minSum = Integer.MAX_VALUE; 
        int closest = 0; 

        while (left < right) {
            int sum = in[left] + in[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum;
                closest = sum;
            }

            if (sum < 0) {
                left++;
            }
            else if (sum > 0) {
                right--;
            }
            else {
                break;
            }
        }

        System.out.println(closest);
    }
}
