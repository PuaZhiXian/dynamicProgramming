public class No1668 {
    public static void main(String[] args) {
        No1668 obj = new No1668();
//        System.out.println(obj.maxRepeating("ababc", "ab"));
//        System.out.println(obj.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
        System.out.println(obj.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

    public int maxRepeating(String sequence, String word) {
        int max = 0;

        for (int i = 0; i < sequence.length(); i++) {
            String sub = sequence.substring(i).replace(word, "A");
            char[] c = sub.toCharArray();
            int cnt = 0;
            for (int j = 0; j < sub.length(); j++) {
                if (c[j] == 'A') {
                    cnt++;
                } else {
                    cnt = 0;
                }
                max = Math.max(cnt, max);
            }
        }
        return max;
    }

}
