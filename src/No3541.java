import java.util.HashMap;
import java.util.Map;

public class No3541 {
    public static void main(String[] args) {
        No3541 o = new No3541();
        System.out.println(o.maxFreqSum("successes"));
    }

    public int maxFreqSum(String s) {
        Map<Character, Integer> vowel = new HashMap<>();
        Map<Character, Integer> consent = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowel.put(c, vowel.getOrDefault(c, 0) + 1);
            } else {
                consent.put(c, consent.getOrDefault(c, 0) + 1);
            }
        }

        int v = 0;
        int c = 0;
        for (Integer i : vowel.values()) {
            v = Math.max(v, i);
        }

        for (Integer i : consent.values()) {
            c = Math.max(c, i);
        }


        return v + c;

    }
} 
