import java.util.Scanner;

public class Main {
    static long c;

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution("AAAAE"));
    }

    //모듈러 공식
    //(A * B) % C = ((A % C) * (B % C)) % C
    public static void solution() {
        Scanner sc = new Scanner(System.in);

        final long A = sc.nextLong();
        final long B = sc.nextLong();
        c = sc.nextLong();

        System.out.println(modular(A, B));

        sc.close();
    }

    private static long modular(long A, long exponent) {
        if (exponent == 1) {
            return A % c;
        }

        long number = modular(A, exponent / 2);

        if (exponent % 2 == 1) {
            return (number * number % c) * A % c;
        }
        return number * number % c;
    }
}
