import java.util.HashSet;
import java.util.Set;

public class No1935 {
    public static void main(String[] args) {
        No1935 o = new No1935();
    }

    Set<Character> set = new HashSet<>();

    public int canBeTypedWords(String text, String brokenLetters) {

        String[] split = text.split(" ");
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        int cnt = 0;

        for (String s : split) {
            cnt += count(s);
        }


        return cnt;

    }

    private int count(String s) {
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return 0;
            }
        }
        return 1;
    }
} 
