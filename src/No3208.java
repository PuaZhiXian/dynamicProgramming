public class No3208 {
    public static void main(String[] args) {
        No3208 obj = new No3208();
        System.out.println(obj.numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));
        System.out.println(obj.numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6));

    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int prev = 2;

        while (left < colors.length) {
            if (colors[right] == prev) {
                if (left < right) {
                    left = right;
                } else {
                    break;
                }
            }

//            System.out.println("r : " + right + " L : " + left);
            if (right - left == k - 1) {
                left++;
                cnt++;
            } else if (colors.length - left + right == k - 1) {
                left++;
                cnt++;
            }
            right++;
            prev = colors[right - 1];

            if (right == colors.length) {
                right = 0;
            }

        }

        return cnt;
    }
}
