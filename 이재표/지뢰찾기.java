import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int q = 0; q < t; q++) {
            int n = Integer.parseInt(br.readLine());
            String expectedCounts = br.readLine();
            String currentField = br.readLine();
            int[] nums = new int[n];
            for (int i = 0; i < expectedCounts.length(); i++) {
                nums[i] = Character.getNumericValue(expectedCounts.charAt(i));
            }
            int answer = 0;
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    if (nums[j] != 0 && nums[j + 1] != 0) {
                        nums[j]--;
                        nums[j + 1]--;
                        answer++;
                    }
                } else if (j == n - 1) {
                    if (nums[j] != 0 && nums[j - 1] != 0) {
                        nums[j]--;
                        nums[j - 1]--;
                        answer++;
                    }
                } else {
                    if (nums[j] != 0 && nums[j + 1] != 0 && nums[j - 1] != 0) {
                        nums[j]--;
                        nums[j + 1]--;
                        nums[j - 1]--;
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
