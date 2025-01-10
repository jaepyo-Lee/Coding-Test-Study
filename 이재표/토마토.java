import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = in[0]; // 가로
        int N = in[1]; // 세로
        int H = in[2]; // 높이

        int[][][] boxes = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                boxes[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (boxes[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k, 0});
                    }
                }
            }
        }

        int[] dz = {0, 0, 0, 0, 1, -1}; // 높이 변화
        int[] dr = {0, 0, 1, -1, 0, 0}; // 행 변화
        int[] dc = {1, -1, 0, 0, 0, 0}; // 열 변화

        int answer = 0;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int z = current[0];
            int r = current[1];
            int c = current[2];
            int day = current[3];

            answer = Math.max(answer, day);

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nz >= 0 && nz < H && nr >= 0 && nr < N && nc >= 0 && nc < M && boxes[nz][nr][nc] == 0) {
                    boxes[nz][nr][nc] = 1; // 익힌다
                    q.offer(new int[]{nz, nr, nc, day + 1});
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (boxes[i][j][k] == 0) {
                        System.out.println(-1); // 익지 않은 토마토가 있다
                        return;
                    }
                }
            }
        }

        System.out.println(answer); // 최대 날짜 출력
    }
}
