import java.util.Arrays;
import java.util.Map;

public class No3479 {
    public static void main(String[] args) {
        No3479 o = new No3479();
        System.out.println(o.numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));//1
        System.out.println(o.numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7}));//0
        System.out.println(o.numOfUnplacedFruits(new int[]{29, 29}, new int[]{29, 9}));//1
        System.out.println(o.numOfUnplacedFruits(new int[]{60, 17, 76}, new int[]{99, 48, 82}));//0

    }

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        int sectionSize = (int) Math.sqrt(baskets.length);
        int sectionCnt = (int) Math.ceil((double) baskets.length / sectionSize);
        int[] maxOfEachSection = new int[sectionCnt];

        for (int i = 0; i < baskets.length; i++) {
            maxOfEachSection[i / sectionSize] = Math.max(maxOfEachSection[i / sectionSize], baskets[i]);
        }

        for (int fruit : fruits) {
            boolean selected = false;

            for (int i = 0; i < sectionCnt; i++) {
                if (maxOfEachSection[i] < fruit) {
                    continue;
                }

                maxOfEachSection[i] = 0;
                for (int j = 0; j < sectionSize; j++) {
                    if (!selected && baskets[(i * sectionSize) + j] >= fruit) {
                        baskets[(i * sectionSize) + j] = 0;
                        selected = true;
                    }
                    maxOfEachSection[i] = Math.max(maxOfEachSection[i], baskets[Math.min((i * sectionSize) + j, baskets.length - 1)]);
                }
                if (selected) {
                    break;
                }
            }
            if (!selected) {
                ans++;
            }

        }


        return ans;
    }
}
