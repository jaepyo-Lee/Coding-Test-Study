import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static StringBuilder numberGroup = new StringBuilder();
    static int n;
    static int m;
    static int[] numbers;
    static int[] sequence;
    static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution("AAAAE"));
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        sequence = new int[m];

        bfs(0, 0);
        for (String number : history) {
            System.out.println(number);
        }

        sc.close();
    }

    private static void bfs(int depth, int prev) {
        if (depth == m) {
            for (int elem : sequence) {
                numberGroup.append(elem).append(" ");
            }
            if (!history.contains(numberGroup.toString())) {
                history.add(numberGroup.toString());
            }
            numberGroup.setLength(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i >= prev) {
                sequence[depth] = numbers[i];
                bfs(depth + 1, i);
            }
        }
    }
}
