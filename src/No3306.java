public class No3306 {
    public static void main(String[] args) {
        No3306 obj = new No3306();
        System.out.println(obj.countOfSubstrings("ieaouqqieaouqq", 1));
    }

    public long countOfSubstrings(String word, int k) {
        return getAtLeastK(word, k) - getAtLeastK(word, k + 1);
    }

    public long getAtLeastK(String word, int k) {
        long ans = 0;
        int l = 0, r = 0;
        int[] vowel = new int[5];
        int noVowel = 0;

        char[] chars = word.toCharArray();
        int len = chars.length;

        while (r < len) {
            int vowelIndex = getVowel(chars[r]);
            if (vowelIndex == -1) {
                noVowel++;
            } else {
                vowel[vowelIndex]++;
            }

            while (noVowel >= k && helper(vowel)) {
                ans += (len - r);
//                System.out.printf("r:%s , char:%s , adding :%s\n", r, chars[r], len - r);
                int temp = getVowel(chars[l]);
                if (temp == -1) {
                    noVowel--;
                } else {
                    vowel[temp]--;
                }
                l++;
            }

            r++;
        }

//        System.out.printf("k: %s , cnt : %s\n", k, ans);
        return ans;
    }

    public boolean helper(int[] vowel) {
        for (int i = 0; i < vowel.length; i++) {
            if (vowel[i] == 0) {
                return false;
            }
        }
        return true;
    }

    public int getVowel(char c) {
        switch (c) {
            case 'a':
                return 0;
            case 'e':
                return 1;
            case 'i':
                return 2;
            case 'o':
                return 3;
            case 'u':
                return 4;
            default:
                return -1;
        }
    }
}
