class Solution {
    final char[] alphabets = {'A', 'E', 'I', 'O', 'U'};
    StringBuilder text = new StringBuilder();
    String word;
    int count;
    int answer;
    char[] sequence;
    boolean[] visited;

    public int solution(String word) {
        this.word = word;

        count = 0;
        answer = 0;
        visited = new boolean[5];
        sequence = new char[5];
        bfs(0);

        return answer;
    }
    private void bfs(int depth) {
        if (answer != 0) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            text.append(sequence[i]);
        }
        if (text.toString().equals(word)) {
            answer = count;
            return;
        }
        text.setLength(0);
        if (depth == 5) {
            return;
        }
        for (int i = 0; i < 5; i++) {
            count++;
            sequence[depth] = alphabets[i];
            bfs(depth + 1);
        }
    }
}