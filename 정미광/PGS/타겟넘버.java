class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(0, 0, target, numbers);

        return answer;
    }

    void dfs(int index, int sum, int target, int[] numbers) {
        if (index == numbers.length) {
            if (sum == target) {
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + numbers[index], target, numbers);
        dfs(index + 1, sum - numbers[index], target, numbers);
    }
}