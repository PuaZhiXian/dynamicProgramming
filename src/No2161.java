import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2161 {
    public static void main(String[] args) {
        No2161 obj = new No2161();
        System.out.println(Arrays.toString(obj.pivotArray(new int[]{9, 10, 5, 3, 12, 14, 10}, 10)));
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int[] greater = new int[nums.length];
        int greaterIndex = 0;
        int sameCnt = 0;

        int insertIndex = 0;
        int checkingIndex = 0;

        while (checkingIndex < nums.length) {
            if (nums[checkingIndex] < pivot) {
                nums[insertIndex] = nums[checkingIndex];
                insertIndex++;
            } else if (nums[checkingIndex] == pivot) {
                sameCnt++;
            } else {
                greater[greaterIndex] = nums[checkingIndex];
                greaterIndex++;
            }
            checkingIndex++;
        }

        for (int i = 0; i < sameCnt; i++) {
            nums[insertIndex] = pivot;
            insertIndex++;
        }

        for (int i = 0; i < greaterIndex; i++) {
            nums[insertIndex] = greater[i];
            insertIndex++;
        }


        return nums;
    }
}
