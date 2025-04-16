import java.util.HashMap;
import java.util.Map;

public class No273 {
    public static void main(String[] args) {
        No273 obj = new No273();
//        System.out.println(obj.numberToWords(123));
//        System.out.println(obj.numberToWords(12345));
        System.out.println(obj.numberToWords(1000));
    }

    Map<Integer, String> map = new HashMap<>();

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        map.put(10, "Ten");
        map.put(11, "Eleven");
        map.put(12, "Twelve");
        map.put(13, "Thirteen");
        map.put(14, "Fourteen");
        map.put(15, "Fifteen");
        map.put(16, "Sixteen");
        map.put(17, "Seventeen");
        map.put(18, "Eighteen");
        map.put(19, "Nineteen");

        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");
        map.put(5, "Five");
        map.put(6, "Six");
        map.put(7, "Seven");
        map.put(8, "Eight");
        map.put(9, "Nine");

        map.put(20, "Twenty");
        map.put(30, "Thirty");
        map.put(40, "Forty");
        map.put(50, "Fifty");
        map.put(60, "Sixty");
        map.put(70, "Seventy");
        map.put(80, "Eighty");
        map.put(90, "Ninety");

        int index = 0;
        String[] cnt = new String[4];
        cnt[0] = "";
        cnt[1] = "Thousand";
        cnt[2] = "Million";
        cnt[3] = "Billion";

        StringBuilder stringBuilder = new StringBuilder();

        while (num > 0) {
            int reminder = num % 1000;
            num = num / 1000;
            String result = helper(reminder);

            if (!result.isEmpty()) {
                if (index != 0) {
                    result = result + cnt[index] + " ";
                }
                stringBuilder.insert(0, result);
            }
            index++;
        }

        return stringBuilder.toString().trim();
    }

    public String helper(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 2;
        int[] nums = new int[3];

        while (num > 0) {
            int reminder = num % 10;
            nums[index] = reminder;
            num = num / 10;
            index--;
        }


        if (nums[0] != 0) {
            stringBuilder.append(map.get(nums[0])).append(" Hundred ");
        }

        if (nums[1] == 1) {
            stringBuilder.append(map.get(nums[1] * 10 + nums[2])).append(" ");
        } else {
            if (nums[1] != 0) {
                stringBuilder.append(map.get(nums[1] * 10)).append(" ");
            }

            if (nums[2] != 0) {
                stringBuilder.append(map.get(nums[2])).append(" ");
            }
        }


        return stringBuilder.toString();
    }
}
