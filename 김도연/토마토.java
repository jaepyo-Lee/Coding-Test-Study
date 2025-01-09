import java.util.*;

public class Main {

    public int solution(int[][][] boxes) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[0].length; j++) {
                for (int k = 0; k < boxes[0][0].length; k++) {
                    if (boxes[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k, 0});
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int i = tmp[0];
            int j = tmp[1];
            int k = tmp[2];
            int count = tmp[3];
            answer = count;
            if (i > 0 && boxes[i - 1][j][k] == 0) {
                boxes[i - 1][j][k] = 1;
                queue.offer(new int[]{i - 1, j, k, count + 1});
            }
            if (i < boxes.length - 1 && boxes[i + 1][j][k] == 0) {
                boxes[i + 1][j][k] = 1;
                queue.offer(new int[]{i + 1, j, k, count + 1});
            }
            if (j > 0 && boxes[i][j - 1][k] == 0) {
                boxes[i][j - 1][k] = 1;
                queue.offer(new int[]{i, j - 1, k, count + 1});
            }
            if (j < boxes[0].length - 1 && boxes[i][j + 1][k] == 0) {
                boxes[i][j + 1][k] = 1;
                queue.offer(new int[]{i, j + 1, k, count + 1});
            }
            if (k > 0 && boxes[i][j][k - 1] == 0) {
                boxes[i][j][k - 1] = 1;
                queue.offer(new int[]{i, j, k - 1, count + 1});
            }
            if (k < boxes[0][0].length - 1 && boxes[i][j][k + 1] == 0) {
                boxes[i][j][k + 1] = 1;
                queue.offer(new int[]{i, j, k + 1, count + 1});
            }
            if (queue.size() == 1) {
                int a = 1;
            }
        }
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[0].length; j++) {
                for (int k = 0; k < boxes[0][0].length; k++) {
                    if (boxes[i][j][k] == 0) {
                        return -1;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.next());
        int b = Integer.parseInt(scanner.next());
        int c = Integer.parseInt(scanner.next());
        int[][][] boxes = new int[c][b][a];
        for (int k = 0; k < c; k++) {
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    boxes[k][i][j] = Integer.parseInt(scanner.next());
                }
            }
        }
        int solution = T.solution(boxes);
        System.out.println(solution);
    }
}
