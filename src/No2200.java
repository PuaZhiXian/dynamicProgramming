import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No2200 {
    public static void main(String[] args) {
        No2200 o = new No2200();
//        System.out.println(o.findKDistantIndices(new int[]{3, 4, 9, 1, 3, 9, 5}, 9, 1));
//        System.out.println(o.findKDistantIndices(new int[]{2, 2, 2, 2, 2}, 2, 2));
        System.out.println(o.findKDistantIndices(new int[]{734, 228, 636, 204, 552, 732, 686, 461, 973, 874, 90, 537, 939, 986, 855, 387, 344, 939,
                552, 389, 116, 93, 545, 805, 572, 306, 157, 899, 276,
                479, 337, 219, 936, 416, 457, 612, 795, 221, 51, 363,
                667, 112, 686, 21, 416, 264, 942, 2, 127, 47, 151, 277, 603, 842, 586, 630, 508, 147, 866, 434, 973, 216, 656, 413, 504, 360, 990, 228, 22, 368, 660, 945, 99, 685, 28, 725, 673, 545, 918, 733, 158, 254, 207, 742, 705, 432, 771, 578, 549, 228, 766, 998, 782, 757, 561, 444, 426, 625, 706, 946}, 939, 34));
    }

    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> lt = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                for (int j = 0; j <= k; j++) {
                    if (i - j < 0) {
                        break;
                    }
                    if (visited[i - j]) {
                        continue;
                    }
                    lt.add(i - j);
                    visited[i - j] = true;
                }
                for (int j = 1; j <= k; j++) {
                    if (i + j > nums.length - 1) {
                        break;
                    }
                    if (visited[i + j]) {
                        continue;
                    }
                    lt.add(i + j);
                    visited[i + j] = true;
                }
            }
        }

        Collections.sort(lt);  // Sorts in natural (ascending) order
        return lt;
    }
}
