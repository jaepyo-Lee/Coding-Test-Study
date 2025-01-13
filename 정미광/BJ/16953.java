
import java.util.*;

public class Main {
    static int answer = -1;
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        final int A = sc.nextInt();
        final int B = sc.nextInt();

        dfs(A, B, 1);

        System.out.print(answer);
        sc.close();
    }

    static void dfs(int a, int b, int count) {
        if (a == b) {
            answer = count;
            return;
        }
        if (a > b) {
            return;
        }
        dfs(a * 2, b, count + 1);
        dfs(a * 10 + 1, b, count + 1);
    }
}