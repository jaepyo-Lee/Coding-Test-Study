import java.util.*;
class Solution {
   Map<String, Integer> map = new HashMap<>();

    public int[] solution(String msg) {
        List<Integer> arr = new ArrayList<>();

        int num = 26;
        int tmp = 0;
        for (int i = 0; i < msg.length(); i++) {
            int a = a(msg, i, i);
            if (a - i == 0) {
                tmp = i;
                arr.add(msg.charAt(i) - 'A' + 1);
            } else {
                arr.add(map.get(msg.substring(i, a + 1)));
                tmp = i;
                i = a;
            }
            if (msg.length() - 1 != i) {
                map.put(msg.substring(tmp, a + 2), ++num);
                System.out.println(msg.substring(tmp, a + 2));
            }
        }

        int[] answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
            System.out.println(answer[i]);
        }
        return answer;
    }

    private int a(String msg, int original, int i) {
        if (i < msg.length() - 1 && map.containsKey(msg.substring(original, i + 2))) {
            return a(msg, original, i + 1);
        } else {
            return i;
        }
    }
}

