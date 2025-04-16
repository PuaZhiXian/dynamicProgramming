public class No1653 {
    public static void main(String[] args) {
        No1653 obj = new No1653();
//        System.out.println(obj.minimumDeletions("aababbab"));
//        System.out.println(obj.minimumDeletions("ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa"));
        System.out.println(obj.minimumDeletions("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba"));
//        System.out.println(obj.minimumDeletions("aa"));
    }

    public int minimumDeletions(String s) {
        int l = s.length();
        if (l == 1) {
            return 0;
        }

        int aCnt = 0;
        int bCnt = 0;
        //a suffix
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a') {
                aCnt++;
            }
        }

        if (aCnt == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        //b prefix
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a') {
                aCnt--;
            }
            min = Math.min(aCnt + bCnt, min);
            if (s.charAt(i) == 'b') {
                bCnt++;
            }
        }

        return min;
    }
}
