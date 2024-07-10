public class No125_MaximumScoreWordsFormedbyLetters {
    public static void main(String[] args) {
        System.out.println(maxScoreWords(new String[]{"dog", "cat", "dad", "good"},
                new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'},
                new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] cnt = new int[26];
        for (char c : letters) {
            cnt[c - 'a']++;
        }
        return helper(words, 0, cnt, score);
    }

    public static int helper(String[] words, int start, int[] cnt, int[] score) {
        if (start == words.length - 1) {
            int sum = 0;
            for (int i = 0; i < words[start].length(); i++) {
                if (cnt[words[start].charAt(i) - 'a'] - 1 >= 0) {
                    cnt[words[start].charAt(i) - 'a']--;
                    sum += score[words[start].charAt(i) - 'a'];
                } else {
                    return 0;
                }
            }
            return sum;
        }
        int[] exclude = cnt.clone();
        int includeList = 0;
        int[] wordCnt = cnt.clone();
        int sum = 0;
        boolean include = true;
        for (int i = 0; i < words[start].length(); i++) {
            if (cnt[words[start].charAt(i) - 'a'] - 1 >= 0) {
                cnt[words[start].charAt(i) - 'a']--;
                sum += score[words[start].charAt(i) - 'a'];
            } else {
                include = false;
                cnt = wordCnt.clone();
                sum = 0;
                break;
            }
        }
        if (include) {
            includeList = sum + helper(words, start + 1, cnt, score);
        }
        int excludeList = helper(words, start + 1, exclude, score);

        return Math.max(includeList, excludeList);
    }
}
