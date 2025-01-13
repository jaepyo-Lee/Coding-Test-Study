import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] wire = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 배열 정렬
        Arrays.sort(wire);

        // Deque 초기화
        Deque<Integer> dq = new LinkedList<>();
        for (int i : wire) {
            dq.offerLast(i);
        }

        int answer = 0;
        while (dq.size() > 1) {
            answer++;

            int last = dq.pollLast();
            int last2 = dq.pollLast();
            if (!dq.isEmpty()) {
                Integer min = dq.pollFirst();
                if (min - 1 > 0) {
                    dq.offerFirst(min - 1); // 최소값이 1 이상일 때만 감소 후 추가
                }
            }
            dq.offerLast(last + last2 + 1); // 마지막 두 값의 합을 추가
        }

        System.out.println(answer);
    }
}