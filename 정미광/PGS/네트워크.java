class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i, n, computers);
            }
        }


        return answer;
    }

    private void bfs(int index, int n, int[][] computers) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && computers[index][i] == 1) {
                visited[i] = true;
                bfs(i, n, computers);
            }
        }
    }
}