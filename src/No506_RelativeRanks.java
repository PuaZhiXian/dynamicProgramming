import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/relative-ranks
 */
public class No506_RelativeRanks {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRelativeRanks(new int[]{10, 3, 8, 9, 4}))); //["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    }

    public static String[] findRelativeRanks(int[] score) {
        int max = getMax(score);
        int[] countArray = new int[max + 1];
        String[] result = new String[score.length];
        Map<String, String> map = new HashMap<String, String>() {{
            put("1", "Gold Medal");
            put("2", "Silver Medal");
            put("3", "Bronze Medal");
        }};

        for (int num : score) {
            countArray[num]++;
        }
        for (int i = countArray.length - 1; i > 0; i--) {
            countArray[i - 1] += countArray[i];
        }
        for (int i = score.length - 1; i >= 0; i--) {
            countArray[score[i]]--;
            int n = countArray[score[i]];
            result[i] = map.getOrDefault(n + 1 + "", n + 1 + "");
        }
        return result;
    }

    public static int getMax(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }
}
