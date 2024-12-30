import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static long A;
    static long B;
    static long C;
    static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] in = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        map = new HashMap<>();
        A = in[0];
        B = in[1];
        C = in[2];
        map.put(1L, A % C);
        System.out.println(divide(B, C));
    }

    private static long divide(long b, long c) {
        if (map.containsKey(b)) {
            return map.get(b);
        }
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            long tmp = divide(b / 2, c);
            map.put(b, (tmp * tmp) % c);
            return map.get(b);
        } else {
            long tmp = divide(b / 2, c);
            map.put(b, ((tmp * tmp) % c * (map.get(1L)))%c);
            return map.get(b);
        }
    }
}
