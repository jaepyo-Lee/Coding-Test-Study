package bj;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] in = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long A = in[0];
        long B = in[1];
        long cnt = 0;

        while (B >= A) {
            cnt++;
            if (B == A) {
                System.out.println(cnt);
                return;
            }
            if (B % 2 == 0) {
                B = B / 2;
            } else if (B % 10 == 1) {
                B = B / 10; 
            } else {
                break; 
            }
        }

        System.out.println(-1);
    }
}
