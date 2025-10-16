import java.util.HashMap;
import java.util.Map;

public class No904 {
    public static void main(String[] args) {
        No904 o = new No904();
        System.out.println(o.totalFruit(new int[]{6, 2, 1, 1, 3, 6, 6}));
    }

    public int totalFruit(int[] fruits) {
        int firstTypeCnt = 0;
        int secondTypeCnt = 0;
        int firstType = -1;
        int secondType = -1;

        int l = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < fruits.length; i++) {
            int cur = fruits[i];
            if (firstType == cur) {
                firstTypeCnt++;
            } else if (secondType == cur) {
                secondTypeCnt++;
            } else {
                if (firstType == -1) {
                    firstType = cur;
                    firstTypeCnt = 1;
                } else if (secondType == -1) {
                    secondType = cur;
                    secondTypeCnt = 1;
                } else {
                    max = Math.max(max, firstTypeCnt + secondTypeCnt);
                    while (firstTypeCnt > 0 && secondTypeCnt > 0) {
                        int remove = fruits[l];
                        if (firstType == remove) {
                            firstTypeCnt--;
                        } else {
                            secondTypeCnt--;
                        }
                        l++;
                    }
                    if (firstTypeCnt == 0) {
                        firstTypeCnt = 1;
                        firstType = cur;
                    } else {
                        secondTypeCnt = 1;
                        secondType = cur;
                    }
                }
            }
        }
        max = Math.max(max, firstTypeCnt + secondTypeCnt);


        return max;
    }
}
