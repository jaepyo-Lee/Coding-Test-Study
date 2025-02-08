
import java.util.*;

public class Main {

    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        long answer = Long.MAX_VALUE;
        long x = sc.nextLong();
        long y = sc.nextLong();
        long w = sc.nextLong();
        long s = sc.nextLong();

        //1. 대각선으로만
        if ((x + y) % 2 == 1) {         //1-1 x + y = 홀
            answer = Math.min(answer, ((Math.max(x, y) - 1) * s) + w);
        } else { //1-2 x + y = 짝
            answer = Math.min(answer, Math.max(x, y) * s);
        }

        //2. 일직선으로만
        answer = Math.min(answer, (x + y) * w);

        //3. 섞어서
        answer = Math.min(answer, (Math.min(x, y) * s) + (Math.abs(x - y) * w));

        System.out.print(answer);

        sc.close();
    }
}