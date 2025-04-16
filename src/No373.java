import java.util.*;

public class No373 {
    public static void main(String[] args) {
        No373 obj = new No373();
        System.out.println(obj.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(obj.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 4}, 2));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Model> pq = new PriorityQueue<>(new Comparator<Model>() {
            @Override
            public int compare(Model m1, Model m2) {
                return Integer.compare(m2.val, m1.val); // For descending order
            }
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (pq.size() < k) {
                    pq.add(new Model(Arrays.asList(nums1[i], nums2[j])));
                } else {
                    if (pq.peek().val > nums1[i] + nums2[j]) {
                        pq.add(new Model(Arrays.asList(nums1[i], nums2[j])));
                        pq.poll();
                    }else{
                        break;
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            Model model = pq.poll();
            ans.add(0, model.arr);
        }

        return ans;
    }

    class Model {
        List<Integer> arr;
        int val;

        public Model(List<Integer> arr) {
            this.arr = arr;
            this.val = arr.get(0) + arr.get(1);
        }
    }
}
