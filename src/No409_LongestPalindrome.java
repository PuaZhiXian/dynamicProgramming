import java.util.*;

public class No409_LongestPalindrome {
    public static void main(String[] args) {
//        System.out.println(isNStraightHand(new int[]{8, 1, 2, 3, 6, 2, 3, 4, 7}, 3));//true
//        System.out.println(isNStraightHand(new int[]{1, 2, 3, 4}, 5));//false
        System.out.println(isNStraightHand(new int[]{53, 78, 62, 108, 83, 56, 66, 110, 49, 104, 117, 123, 86, 131, 94, 107, 84, 103, 42, 127, 100, 50, 55, 97, 81, 93, 71, 45, 63, 39, 91, 87, 129, 126, 84, 125, 73, 95, 116, 47, 106, 52, 121, 54, 38, 68, 69, 76, 89, 90, 57, 67, 86, 114, 64, 87, 79, 92, 115, 60, 51, 105, 132, 101, 59, 130, 44, 85, 80, 82, 48, 65, 128, 102, 74, 61, 40, 46, 98, 111, 109, 119, 72, 43, 112, 120, 58, 113, 77, 88, 41, 118, 75, 85, 124, 122, 96, 83, 99, 70},
                50));//true
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : hand) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Collections.sort(keyList);
        for (Integer keys : keyList) {
            int t = keys;
            if (map.get(keys) == 0) {
                continue;
            }
            int min = map.get(t);

//            System.out.printf("key : %d ,min : %d \n", keys, min);
            for (int i = 0; i < groupSize; i++) {
                int newNum = map.getOrDefault(t + i, 0) - min;
                if (newNum < 0) {
                    return false;
                }
                map.put(t + i, newNum);
            }
//            System.out.println(map);
//            System.out.println();
        }
        return true;
    }
}