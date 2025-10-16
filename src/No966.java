import java.util.*;

public class No966 {
    public static void main(String[] args) {
        No966 o = new No966();
        String[] w = new String[]{"KiTe", "kite", "hare", "Hare"};
        String[] q = new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};
        System.out.println(Arrays.toString(o.spellchecker(w, q)));
    }

    Set<String> total = new HashSet<>();
    Map<String, String> cap = new HashMap<>();
    Map<String, String> vowel = new HashMap<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];

        for (String word : wordlist) {
            total.add(word);
            String temp = word.toLowerCase();

            if (!cap.containsKey(temp)) {
                cap.put(temp, word);
            }

            temp = temp.replace("a", "$");
            temp = temp.replace("e", "$");
            temp = temp.replace("i", "$");
            temp = temp.replace("o", "$");
            temp = temp.replace("u", "$");

            if (!vowel.containsKey(temp)) {
                vowel.put(temp, word);
            }
        }


        for (int i = 0; i < queries.length; i++) {
            if (total.contains(queries[i])) {
                ans[i] = queries[i];
            } else if (cap.containsKey(queries[i].toLowerCase())) {
                ans[i] = cap.get(queries[i].toLowerCase());
            } else {
                String temp = queries[i].toLowerCase();
                temp = temp.replace("a", "$");
                temp = temp.replace("e", "$");
                temp = temp.replace("i", "$");
                temp = temp.replace("o", "$");
                temp = temp.replace("u", "$");
                if (vowel.containsKey(temp)) {
                    ans[i] = vowel.get(temp);
                } else {
                    ans[i] = "";
                }
            }

        }

        return ans;
    }

    private int getFirst(int t, int c, int v) {
        if (t != -1) {
            return t;
        }
        if (c != -1) {
            return c;
        }
        if (v != -1) {
            return v;
        }
        return -1;
    }


    private boolean matchTotally(String target, String source) {
        return target.equals(source);
    }

    private boolean matchWitCap(String target, String source) {
        return target.equalsIgnoreCase(source);
    }

    private boolean matchWithVowel(String target, String source) {
        if (target.length() != source.length()) {
            return false;
        }

        target = target.toLowerCase();
        target = target.replace("a", "$");
        target = target.replace("e", "$");
        target = target.replace("i", "$");
        target = target.replace("o", "$");
        target = target.replace("u", "$");

        source = source.toLowerCase();
        source = source.replace("a", "$");
        source = source.replace("e", "$");
        source = source.replace("i", "$");
        source = source.replace("o", "$");
        source = source.replace("u", "$");


        return source.equals(target);
    }


} 
