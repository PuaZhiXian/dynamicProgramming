import java.util.*;

public class No2901 {
    public static void main(String[] args) {
        No2901 obj = new No2901();
//        System.out.println(obj.getWordsInLongestSubsequence(
//                new String[]{"bab", "dab", "cab"},
//                new int[]{1, 2, 2}
//        ));
        System.out.println(obj.getWordsInLongestSubsequence(
                new String[]{"bad", "dc", "bc", "ccd", "dd", "da", "cad", "dba", "aba"},
                new int[]{9, 7, 1, 2, 6, 8, 3, 7, 2}
        ));

    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] len = new int[n];
        int[] comeFrom = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            comeFrom[i] = i;
            len[i] = 1;
        }


        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if ((len[j] + 1) > len[i] && isValid(words, groups, i, j)) {
                    comeFrom[i] = j;
                    len[i] = len[j] + 1;
                    max = Math.max(max, len[i]);
                }
            }
        }

        System.out.println(Arrays.toString(len));
        System.out.println(Arrays.toString(comeFrom));
        System.out.println("Max : " + max);

        for (int i = n - 1; i >= 0; i--) {
            if (len[i] == max) {
                return genAns(words, comeFrom, i);
            }
        }

        return Collections.singletonList(words[0]);
    }

    private boolean isValid(String[] words, int[] group, int index1, int index2) {
        char[] word1 = words[index1].toCharArray();
        char[] word2 = words[index2].toCharArray();

        if (group[index1] != group[index2] && word2.length == word1.length) {
            int temp = 0;
            for (int i = 0; i < word1.length; i++) {
                if (word1[i] != word2[i]) {
                    temp++;
                    if (temp > 1) {
                        return false;
                    }
                }
            }
            return temp == 1;
        }

        return false;
    }

    private List<String> genAns(String[] words, int[] comeFrom, int i) {
        List<String> lt = new ArrayList<>();

        while (true) {
            lt.add(0, words[i]);
            if (comeFrom[i] == i) {
                break;
            }
            i = comeFrom[i];
        }

        return lt;
    }

}
