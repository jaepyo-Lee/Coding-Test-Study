import java.util.Scanner;

public class Main {

    public int solution(StringBuilder s, StringBuilder t) {
        for (int i = t.length() - 1; i >= 0; i--) {
            if (t.compareTo(s) == 0) return 1;
            if (t.charAt(i) == 'A') {
                t = new StringBuilder(t.substring(0, i));
            } else if (i > 0) {
                t = t.reverse();
                t.deleteCharAt(0);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        int solution = T.solution(new StringBuilder(s), new StringBuilder(t));
        System.out.println(solution);
    }
}
