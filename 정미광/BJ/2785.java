
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] wines;
    static int[] dp;

    public static void main(String[] args) {
        solution();
//        Solution s = new Solution();
//        System.out.println(s.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int n = sc.nextInt();
        PriorityQueue<Integer> chains = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            chains.add(sc.nextInt());
        }

        if (n <= 3) {
            System.out.println(1);
            return;
        }

        int k = chains.poll();
        while (k <= chains.size() - 1) {
            count = chains.size() - 1;
            k += chains.poll();
        }
        System.out.println(count);
        sc.close();
    }
}