public class No3403 {

    public static void main(String[] args) {
        No3403 o = new No3403();
//        System.out.println(o.answerString("dbca", 2));
//        System.out.println(o.answerString("bif", 2));
        System.out.println(o.answerString("aann", 2));
//        System.out.println("if".compareTo("bi"));
    }

    public String answerString(String word, int numFriends) {
        String max = "";
        if (numFriends == 1) {
            return word;
        }

        int n = word.length();
        int targetLen = n - numFriends + 1;

        for (int i = 0; i < n; i++) {
            String cur = word.substring(i, Math.min(i + targetLen, n));
            if (cur.compareTo(max) > 0) {
                max = cur;
            }
        }

        return max;
    }


}
