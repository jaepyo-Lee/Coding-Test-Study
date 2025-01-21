
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);
        long answer = 0;

        //long으로 바꿔보기
        int m = sc.nextInt();
        int n = sc.nextInt();
        long left;
        long right;
        long mid;
        long[] snacks = new long[n];

        for (int i = 0; i < n; i++) {
            snacks[i] = sc.nextLong();
        }

        Arrays.sort(snacks);
        left = 1;
        right = snacks[n - 1];
        mid = (left + right) / 2; //나눠줄 수 있는 각 과자의 길이

        while (left <= right) {
            long sum = 0;
            for (long snack : snacks) {
                sum += snack / mid;
            }

            if (sum >= m) {
                left = mid + 1; //left와 right의 경계를 줄이기 위해 +1
            } else {
                right = mid - 1; //left와 right의 경계를 줄이기 위해 -1
            }

            mid = (left + right) / 2;
        }
        answer = mid;

        System.out.print(answer);

        sc.close();
    }
}