import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Picture {
    static int n;
    static int m;
    static int[][] graph;
    // 방문 여부 확인
    static boolean[][] visited;
    static int pictureCount = 0;
    static int maxArea = 0;
    static int area = 0;
    // 오른쪽 : 0 1 왼쪽 : 0 -1 위쪽 : 1 0 밑에쪽 : -1 0
    //상하 이동
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};


    //bfs 함수 그림 개수 반환 시작 방향부터...
    static int BFS(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, b});
        visited[a][b] = true;
        area++;
        //큐가 비지 않을 때까지 반복하기
        while(!queue.isEmpty()) {
            //현재 뽑기
            int[] current = queue.poll();
            // 인접칸 좌표 뽑기
            for (int i=0; i<4; i++) {
                int x = current[0] + dx[i];
                int y = current[1] + dy[i];

                // pass
                if (x < 0 || y < 0 || x >= n || y >= m) {
                    continue;
                }

                // 방문 or 0이면 pass
                if (visited[x][y] || graph[x][y] == 0) {
                    continue;
                }

                queue.add(new int[]{x, y});
                visited[x][y] = true;
                area++;
            }

        }

        return maxArea;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n][m];
        // 방문 여부 확인
        visited = new boolean[n][m];


        //값 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                //값 넣기
                graph[i][j] = sc.nextInt();
            }
        }

        //전체 그래프 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    pictureCount++;
                    BFS(i, j);
                    //최대 넓이 계산
                    maxArea = Math.max(maxArea, area);
                    area = 0;

                }
            }

        }

        System.out.println(pictureCount);
        System.out.println(maxArea);
    }
}
