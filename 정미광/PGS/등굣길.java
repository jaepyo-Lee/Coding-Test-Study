class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        final int PUDDLE = -1;
        int answer = 0;
        int[][] board = new int[n][m];

        //웅덩이 표시
        //웅덩이 정보가 [열, 행] 순으로 되어 있음
        for (int[] puddle : puddles) {
            board[puddle[1] - 1][puddle[0] - 1] = PUDDLE;
        }

        //가장자리 표시
        for (int i = 0; i < m; i++) {
            if (board[0][i] == PUDDLE) {
                break;
            }
            board[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (board[i][0] == PUDDLE) {
                break;
            }
            board[i][0] = 1;
        }

        //계산
        for(int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (board[i][j] == PUDDLE) {
                    continue;
                }
                if (board[i - 1][j] != PUDDLE) {
                    board[i][j] += board[i - 1][j];
                }
                if (board[i][j - 1] != PUDDLE) {
                    board[i][j] += board[i][j - 1];
                }
                board[i][j] %= MOD;
            }
        }

        answer = board[n - 1][m - 1];
        return answer;
    }
}