import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No703 {
    public static void main(String[] args) {
        No703 obj = new No703();
        obj.run();
    }

    public void run() {

        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(k.add(3));
        System.out.println(k.add(5));
        System.out.println(k.add(10));
        System.out.println(k.add(9));
        System.out.println(k.add(4));
    }

    class KthLargest {

        List<Integer> arrayList = new ArrayList<>();
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int i = 0; i < nums.length; i++) {
                arrayList.add(nums[i]);
            }
        }

        public int add(int val) {
            arrayList.add(val);
            arrayList.sort(Comparator.reverseOrder());
            return arrayList.get(k - 1);
        }
    }

}
