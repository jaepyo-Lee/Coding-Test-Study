import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
     public int solution(String word) {
        String[] vowels = {"A", "E", "I", "O", "U"};
        List<String> words = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            generateWords(vowels, "", i, words);
        }

        Collections.sort(words);

        return words.indexOf(word) + 1;
    }

    private void generateWords(String[] vowels, String current, int maxLength, List<String> words) {
        if (current.length() == maxLength) {
            words.add(current);
            return;
        }

        for (String vowel : vowels) {
            generateWords(vowels, current + vowel, maxLength, words);
        }
    }
}
