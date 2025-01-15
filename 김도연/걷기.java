import java.util.Scanner;

public class Main {

    public long solution(int x, int y, int w, int s) {
        int W = Math.min(w, s);
        int S = w;
        if (2 * w >= s) S = s;
        long time = 0;
        while (x != 0 || y != 0) {
            if (x - 1 == 0 && y == 0 || x == 0 && y - 1 == 0) {
                return time + w;
            } else if (x == 0 && y > 1) {
                if (W == w) {
                    time += W;
                    y--;
                } else {
                    time += 2 * W;
                    y -= 2;
                }
            } else if (y == 0 && x > 1) {
                if (W == w) {
                    time += W;
                    x--;
                } else {
                    time += 2 * W;
                    x -= 2;
                }
            } else {
                time += S;
                if (S == s) x--;
                y--;
            }
        }
        return time;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.next());
        int y = Integer.parseInt(scanner.next());
        int w = Integer.parseInt(scanner.next());
        int s = Integer.parseInt(scanner.next());

        long solution = T.solution(x, y, w, s);
        System.out.println(solution);
    }
}
