import java.util.*;

public class No17 {
    public static void main(String[] args) {
        No17 obj = new No17();
        Arrays.asList("as", "s");
    }

    Map<Character, List<String>> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        return helper(digits.toCharArray(), 0);
    }


    public List<String> helper(char[] c, int index) {
        if (index == c.length) {
            return Arrays.asList("");
        }

        List<String> list = helper(c, index + 1);
        List<String> ori = map.get(c[index]);

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < ori.size(); i++) {
            for (String s : list) {
                ans.add(ori.get(i) + s);
            }
        }
        return ans;
    }
}
