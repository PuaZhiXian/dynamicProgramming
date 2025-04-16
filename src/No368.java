import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No368 {
    public static void main(String[] args) {
        No368 obj = new No368();
        System.out.println(obj.largestDivisibleSubset(new int[]{5, 9, 18, 54, 108, 540, 90, 180, 360, 720}));
        //9,18,90,180,360,720
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums)); //5, 9, 18, 54, 90, 108, 180, 360, 540, 720

        for (int i = 0; i < nums.length; i++) {
            List<Integer> po = helper(nums, i);
            if (po.size() > ans.size()) {
                ans = po;
            }
        }


        return ans;
    }

    private List<Integer> helper(int[] nums, int start) {
        List<List<Integer>> db = new ArrayList<>();
        for (int i = 0; i < nums.length - start; i++) {
            db.add(new ArrayList<>());
        }

        List<Integer> lt = db.get(nums.length - 1 - start);
        lt.add(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= start; i--) {
            List<Integer> ori = db.get(i - start);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0) {
                    List<Integer> list = db.get(j - start);
                    if (list.size() + 1 > ori.size()) {
                        ori.clear();
                        ori.add(nums[i]);
                        ori.addAll(list);
                        if (ori.size() == nums.length - i - 1) {
                            break;
                        }
                    }
                }
            }
            if (ori.isEmpty()) {
                ori.add(nums[i]);
            }
        }
        System.out.println(db);

        return db.get(0);
    }


}
