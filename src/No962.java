public class No962 {
    public static void main(String[] args) {
        No962 obj = new No962();
        System.out.println(obj.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }

    public int maxWidthRamp(int[] nums) {
        int[] c = new int[nums.length];
        c[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            c[i] = Math.max(c[i + 1], nums[i]);
        }

        int left = 0, right = 0;
        int maxWidth = 0;

        // Traverse the array using left and right pointers
        while (right < nums.length) {
            // Move left pointer forward if current left exceeds rightMax
            while (left < right && nums[left] > c[right]) {
                left++;
            }
            maxWidth = Math.max(maxWidth, right - left);
            right++;
        }

        return maxWidth;
    }
}
