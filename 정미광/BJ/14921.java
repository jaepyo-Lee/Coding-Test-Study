
import java.util.*;


public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(6, new int[]{7, 10}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long min = Long.MAX_VALUE;
        List<Integer> liquids = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            liquids.add(sc.nextInt());
        }

        Collections.sort(liquids, (e1, e2) -> {
            return Math.abs(e1) - Math.abs(e2);
        });

        for (int i = 0; i < n - 1; i++) {
            long sum = liquids.get(i) + liquids.get(i + 1);
            if (Math.abs(min) > Math.abs(sum)) {
                min = sum;
            }
        }

        System.out.print(min);

        sc.close();
    }
}