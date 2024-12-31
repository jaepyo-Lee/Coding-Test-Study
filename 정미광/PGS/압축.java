import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String msg) {
        int head;
        int tail;
        String word;
        int[] answer;
        List<String> dictionary = new ArrayList<>();
        List<Integer> result  = new ArrayList<>();

        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            dictionary.add(Character.toString(alphabet));
        }

        head = 0;
        tail = 1;
        while (head < msg.length() && tail < msg.length()) {
            word = msg.substring(head, tail + 1);
            if (dictionary.contains(word)) {
                tail++;
            } else {
                result.add(dictionary.indexOf(msg.substring(head, tail)) + 1);
                dictionary.add(word);
                head = tail;
                tail++;
            }
        }
        result.add(dictionary.indexOf(msg.substring(head, tail)) + 1);

        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}