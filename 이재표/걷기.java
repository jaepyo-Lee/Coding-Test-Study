import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long x = in[0];
        long y = in[1];
        long w = in[2]; // 직선 한블록
        long s = in[3]; // 대각선

        long time; //전부 직선

        if (2 * w < s) { //직선으로만
            time = (x + y) * w;
        } else if ( w > s) { //최대한 대각선으로
            if ((x + y) % 2 == 0) {
                time = Math.max(x, y) * s;
            } else {
                time = (Math.max(x, y) - 1) * s;
                time += w;
            }
        } else {
            if (x == y) {
                time = s * x;
            } else {
                time = Math.min(x * s, y * s);
                time += Math.abs(x - y) * w;
            }
        }

        System.out.println(time);

    }
}