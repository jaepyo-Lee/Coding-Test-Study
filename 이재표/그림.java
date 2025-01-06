import java.io.*;
import java.util.*;

public class Main {
    static int[][] picture;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = in[0];
        m = in[1];
        picture = new int[n][m];

        for (int i = 0; i < n; i++) {
            picture[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int count = 0; 
        int max = 0;  
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (picture[i][j] == 1) {
                    int width = 0;
                    count++;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    picture[i][j] = 0;

                    while (!q.isEmpty()) {
                        width++;
                        int[] c = q.poll();
                        int cr = c[0];
                        int cc = c[1];

                        for (int d = 0; d < 4; d++) {
                            int nr = cr + dr[d];
                            int nc = cc + dc[d];

                            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                            if (picture[nr][nc] == 0) continue;

                            picture[nr][nc] = 0; 
                            q.add(new int[]{nr, nc});
                        }
                    }
                    max = Math.max(width, max);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }
}
