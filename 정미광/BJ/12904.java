import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int answer;
        String s = sc.next();
        String t = sc.next();

        StringBuilder sb_s = new StringBuilder();
        StringBuilder sb_t = new StringBuilder();

        sb_s.append(s);
        sb_t.append(t);

        while (sb_s.length() < sb_t.length()) {
            if (t.charAt(sb_t.length() - 1) == 'B') {
                sb_t.setLength(sb_t.length() - 1);
                sb_t.reverse();
                t = sb_t.toString();
            } else {
                sb_t.setLength(sb_t.length() - 1);
                t = sb_t.toString();
            }
        }

        if (s.equals(t)) {
            answer = 1;
        } else {
            answer = 0;
        }
        System.out.print(answer);

        sc.close();
    }
}