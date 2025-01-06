
import java.util.*;

//dp
public class Main {
    public static void main(String[] args) {
        solution();
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);
        StringBuilder answer = new StringBuilder();

        int n;
        int t = sc.nextInt();
        int total;
        int[][] stickerBoard;
        int[][] maxBoard;
        for (int testCase = 0; testCase < t; testCase++) {
            n = sc.nextInt();
            stickerBoard = new int[2][n];
            maxBoard = new int[2][n];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    stickerBoard[i][j] = sc.nextInt();
                }
            }

            if (n == 1) {
                if (stickerBoard[0][0] < stickerBoard[1][0]) {
                    total = stickerBoard[1][0];
                } else {
                    total = stickerBoard[0][0];
                }
                answer.append(total).append("\n");
                continue;
            }

            maxBoard[0][0] = stickerBoard[0][0];
            maxBoard[1][0] = stickerBoard[1][0];
            maxBoard[0][1] = stickerBoard[1][0] + stickerBoard[0][1];
            maxBoard[1][1] = stickerBoard[0][0] + stickerBoard[1][1];

            int sum = 0;
            for (int y = 2; y < n; y++) {
                for (int x = 0; x < 2; x++) {
                    int current = stickerBoard[x][y];
                    int max = current + maxBoard[x][y - 2];
                    if (isInRange(x + 1)) {
                        sum = current + maxBoard[x + 1][y - 1];
                        max = getMax(sum, max);
                        sum = current + maxBoard[x + 1][y - 2];
                    } else {
                        sum = current + maxBoard[x - 1][y - 1];
                        max = getMax(sum, max);
                        sum = current + maxBoard[x - 1][y - 2];
                    }
                    max = getMax(sum, max);
                    maxBoard[x][y] = max;
                }
            }
            if (maxBoard[0][n - 1] < maxBoard[1][n - 1]) {
                total = maxBoard[1][n - 1];
            } else {
                total = maxBoard[0][n - 1];
            }
            answer.append(total).append("\n");
        }
        System.out.print(answer);

        sc.close();
    }

    static boolean isInRange(int x) {
        if (x < 0 || x > 1) {
            return false;
        }
        return true;
    }

    static int getMax(int sum, int max) {
        if (sum > max) {
            return sum;
        }
        return max;
    }
}