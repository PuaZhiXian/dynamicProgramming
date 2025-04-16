import java.util.*;

public class No2191 {
    public static void main(String[] args) {
        No2191 obj = new No2191();
//        System.out.println(Arrays.toString(obj.sortJumbled(
//                new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6},
//                new int[]{991, 338, 38}
//        )));
        System.out.println(Arrays.toString(obj.sortJumbled(
                new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0},
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}
        )));
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int[] ans = new int[nums.length];

        List<Model> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int real = 0;
            int ori = nums[i];
            int temp = ori;

            int decimalPlace = 1;
            do {

                int remain = temp % 10;
                temp = temp / 10;
                real = real + mapping[remain] * decimalPlace;
                decimalPlace = 10 * decimalPlace;
            } while (temp != 0);

            list.add(new Model(ori, real, i));
        }

        System.out.println(list);
        Map<Integer, PriorityQueue<Model>> map = new TreeMap<>();

        for (Model model : list) {
            PriorityQueue<Model> pq = map.getOrDefault(model.real, new PriorityQueue<>(Comparator.comparingInt(Model::getIndex)));
            pq.add(model);
            map.put(model.real, pq);
        }

        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Model>> entry : map.entrySet()) {
            PriorityQueue<Model> pq = entry.getValue();
            while (!pq.isEmpty()) {
                Model model = pq.poll();
                ans[index] = model.ori;
                index++;
            }
        }
        return ans;
    }

    class Model {
        int ori;
        int real;
        int index;

        public Model(int ori, int real, int index) {
            this.ori = ori;
            this.real = real;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public String toString() {
            return String.format("Model [ori :%s real: %s index: %s ] \n", ori, real, index);
        }
    }
}
