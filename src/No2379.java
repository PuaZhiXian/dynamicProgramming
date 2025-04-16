public class No2379 {
    public static void main(String[] args) {
        No2379 obj = new No2379();
        System.out.println(obj.minimumRecolors("WBBWWBBWBW", 7));
        System.out.println(obj.minimumRecolors("BWWWBB", 6));

    }

    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        char[] chars = blocks.toCharArray();
        int left = 0;
        int right = 0;

        int cur = 0;
        while (right < chars.length) {
            if (chars[right] == 'W') {
                cur++;
            }

            if (right - left == k - 1) {
                min = Math.min(cur, min);
                if (chars[left] == 'W') {
                    cur--;
                }
                left++;
            }
            right++;
        }
        return min;
    }
}
