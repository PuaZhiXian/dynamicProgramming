import java.util.*;

public class No1298 {
    public static void main(String[] args) {
        No1298 o = new No1298();
        System.out.println(o.maxCandies(
                new int[]{1, 0, 1, 0},
                new int[]{7, 5, 4, 100},
                new int[][]{{}, {}, {1}, {}},
                new int[][]{{1, 2}, {3}, {}, {}},
                new int[]{0}
        ));
    }

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        Set<Integer> foundBox = new HashSet<>();
        Stack<Integer> pendingOpenBox = new Stack<>();
        Set<Integer> foundedKey = new HashSet<>();

        for (int box : initialBoxes) {
            if (status[box] == 1) {
                pendingOpenBox.add(box);
            } else {
                foundBox.add(box);
            }
        }

        while (!pendingOpenBox.isEmpty()) {
            int openingBox = pendingOpenBox.pop();
            ans += candies[openingBox];
            for (int key : keys[openingBox]) {
                foundedKey.add(key);
            }

            Set<Integer> pendingRemove = new HashSet<>();
            for (int box : foundBox) {
                if (foundedKey.contains(box)) {
                    pendingOpenBox.add(box);
                    pendingRemove.add(box);
                }
            }

            foundBox.removeAll(pendingRemove);

            for (int insideBox : containedBoxes[openingBox]) {
                if (status[insideBox] == 1 || foundedKey.contains(insideBox)) {
                    pendingOpenBox.add(insideBox);
                } else {
                    foundBox.add(insideBox);
                }
            }
        }


        return ans;
    }
}
