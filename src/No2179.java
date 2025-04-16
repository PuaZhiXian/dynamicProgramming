import java.util.Arrays;

public class No2179 {
    public static void main(String[] args) {
        No2179 obj = new No2179();
        int[] nums1 = new int[]{2, 0, 1, 3};
        int[] nums2 = new int[]{0, 1, 2, 3};

        System.out.println(obj.goodTriplets(new int[]{4, 0, 1, 3, 2}, new int[]{4, 1, 0, 2, 3}));


    }

    int[] tree;

    public long goodTriplets(int[] nums1, int[] nums2) {
        initTree(nums2);
        int[] map = new int[nums2.length];

        for (int i = 0; i < nums2.length; i++) {
            map[nums2[i]] = i;
        }


        long ans = 0;

        for (int i = 0; i < nums1.length - 1; i++) {
            if (i != 0) {
                int leftMatch = getRange(0, 0, nums2.length, 0, map[nums1[i]]);
                int notMatch = i - leftMatch;
                int rightMatch = nums2.length - 1 - map[nums1[i]] - notMatch;
                ans += ((long) leftMatch * rightMatch);
            }
            updateTree(0, 0, nums2.length - 1, map[nums1[i]]);
        }


        return ans;
    }


    private void initTree(int[] nums2) {
        int result = (int) Math.ceil(Math.log(nums2.length) / Math.log(2));
        tree = new int[(int) (2 * Math.pow(2, result) - 1)];
    }

    private int getRange(int treeIndex, int left, int right, int targetLeft, int targetRight) {
        if (treeIndex > tree.length - 1) {
            return 0;
        }
        if (right < targetLeft || left > targetRight) {
            return 0;
        }
        if (targetLeft <= left && targetRight >= right) {
            return tree[treeIndex];
        }
        int mid = (left + right) / 2;

        return getRange(2 * treeIndex + 1, left, mid, targetLeft, targetRight)
                + getRange(2 * treeIndex + 2, mid + 1, right, targetLeft, targetRight);
    }

    private int updateTree(int treeIndex, int left, int right, int target) {
        if (right < target || left > target) {
            return tree[treeIndex];
        }

        if (left == target && right == target) {
            tree[treeIndex]++;
            return tree[treeIndex];
        }

        int mid = (left + right) / 2;
        tree[treeIndex] =
                updateTree(treeIndex * 2 + 1, left, mid, target) +
                        updateTree(treeIndex * 2 + 2, mid + 1, right, target);
        return tree[treeIndex];
    }
}
