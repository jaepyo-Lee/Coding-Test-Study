import java.util.*;

public class Main {
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int[] mins = new int[3];
        int[] maxs = new int[3];

        for (int i = 0; i < 3; i++) {
            mins[i] = maxs[i] = sc.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int index0 = sc.nextInt();
            int index1 = sc.nextInt();
            int index2 = sc.nextInt();

            maxs[0] = Math.max(maxs[0], maxs[1]) + index0;
            maxs[2] = Math.max(maxs[1], maxs[2]) + index2;
            maxs[1] = Math.max(Math.max(maxs[0] - index0, maxs[1]), maxs[2] - index2) + index1;


            mins[0] = Math.min(mins[0], mins[1]) + index0;
            mins[2] = Math.min(mins[1], mins[2]) + index2;
            mins[1] = Math.min(Math.min(mins[0] - index0, mins[1]), mins[2] - index2) + index1;
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(maxs[i], max);
            min = Math.min(mins[i], min);
        }

        System.out.print(max + " " + min);
        sc.close();
    }
}
