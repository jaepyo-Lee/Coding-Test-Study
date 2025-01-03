class Solution {
    public int M = 0;
    public int N = 0;
    public int answer = 0;

    public int solution(int m, int n, int[][] puddles) {
        M = m;
        N = n;
        a(1, 1, puddles);
        
        return answer % 1000000007;
    }

    private void a(int m, int n, int[][] puddles) {
        if (m == M && n == N) answer++;
        for (int i = 0; i < puddles.length; i++) {
            if (n + 1 > N) {
                break;
            }
            if (puddles[i][0] == m && puddles[i][1] == n + 1) {
                break;
            }
            a(m, n + 1, puddles);
        }
        for (int i = 0; i < puddles.length; i++) {
            if (m + 1 > M) {
                break;
            }
            if (puddles[i][0] == m + 1 && puddles[i][1] == n) {
                break;
            }
            a(m + 1, n, puddles);
        }
    }
}
