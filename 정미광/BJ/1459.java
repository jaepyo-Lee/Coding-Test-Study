
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();
        long w = sc.nextLong();
        long s = sc.nextLong();

        //case 1: 일자로만
        long time = (x + y) * w;

        //case 2: 대각선으로만
        if (Math.abs(x - y) % 2 == 1) {
            time = Math.min(time, ((Math.max(x, y) - 1) * s) + w) ;
        } else {
            time = Math.min(time, Math.max(x, y) * s);
        }

        //case 3: 섞어서

        time = Math.min(time, (Math.min(x, y) * s) + Math.abs(x - y) * w);

        System.out.print(time);

        sc.close();
    }
}