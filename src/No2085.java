import java.util.HashSet;
import java.util.Set;

public class No2085 {
    public static void main(String[] args) {
        No2085 obj = new No2085();


    }

    public int countWords(String[] words1, String[] words2) {
        Set<String> distinct = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for (String s : words1) {
            if (duplicate.contains(s)) {
                continue;
            }
            if (distinct.contains(s)) {
                distinct.remove(s);
                duplicate.add(s);
                continue;
            }
            distinct.add(s);
        }
        Set<String> ans = new HashSet<>();
        for (String s : words2) {
            if (duplicate.contains(s)) {
                continue;
            }
            if (distinct.contains(s)) {
                if (ans.contains(s)) {
                    duplicate.add(s);
                    ans.remove(s);
                } else {
                    ans.add(s);
                }
            }
        }


        return ans.size();
    }
}
