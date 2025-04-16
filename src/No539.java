import java.util.Arrays;
import java.util.List;

public class No539 {
    public static void main(String[] args) {
        No539 obj = new No539();


        System.out.println(obj.findMinDifference(Arrays.asList(
                "23:59", "00:00"
        )));
    }

    public int findMinDifference(List<String> timePoints) {
        int[] minute = new int[timePoints.size()];

        int index = 0;
        for (String str : timePoints) {
            String[] split = str.split(":");
            int temp = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            minute[index] = temp;
            index++;
        }

        Arrays.sort(minute);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minute.length; i++) {
            if (i == minute.length - 1) {

                min = Math.min(min, Math.abs(minute[i] - (minute[0] + 1440)));
            } else {
                min = Math.min(min, Math.abs(minute[i] - minute[i + 1]));
            }
        }


        return min;
    }
}
