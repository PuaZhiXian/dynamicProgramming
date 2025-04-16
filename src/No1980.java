import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No1980 {


    public static void main(String[] args) {
        No1980 obj = new No1980();
        System.out.println(obj.findDifferentBinaryString(new String[]{"00", "01"}));
    }


    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(Integer.parseInt(nums[i], 2));
        }

        int n = 0;
        while (set.contains(n)) {
            n++;
        }

        return helper(nums.length, Integer.toBinaryString(n));
    }

    public String helper(int l, String ans) {

        while (ans.length() != l) {
            ans = "0" + ans;
        }
        return ans;
    }


}
