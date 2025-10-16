import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class No2561 {
    public static void main(String[] args) {
        No2561 o = new No2561();
//        int[] b1 = new int[]{8, 14, 43, 43, 80, 80, 84, 88, 88, 100};
//        int[] b2 = new int[]{8, 14, 32, 32, 42, 42, 68, 68, 84, 100};
        int[] b1 = new int[]{8, 8, 3, 100, 100, 100, 100};
        int[] b2 = new int[]{3, 3, 3, 3, 3, 300, 300};

        String filePath = "C:\\Users\\Pua Zhi Xian\\AppData\\Roaming\\JetBrains\\IdeaIC2025.1\\scratches\\temp.txt"; // change this to your file path

        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
        }

        b1 = numbers.stream().mapToInt(Integer::intValue).toArray();


        filePath = "C:\\Users\\Pua Zhi Xian\\AppData\\Roaming\\JetBrains\\IdeaIC2025.1\\scratches\\temp2.txt"; // change this to your file path

        numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line.trim()));
            }
        } catch (IOException e) {
        }

        b2 = numbers.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(o.minCost(b1, b2));
        //131340
        //109626
    }

    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> b1 = new HashMap<>();
        Map<Integer, Integer> b2 = new HashMap<>();

        long min = Long.MAX_VALUE;

        for (int n : basket1) {
            b1.put(n, b1.getOrDefault(n, 0) + 1);
            min = Math.min(min, n);
        }
        for (int n : basket2) {
            b2.put(n, b2.getOrDefault(n, 0) + 1);
            min = Math.min(min, n);
        }

        Set<Integer> key = new HashSet<>();
        key.addAll(b1.keySet());
        key.addAll(b2.keySet());

        PriorityQueue<Integer> needSwapB2 = new PriorityQueue<>();
        PriorityQueue<Integer> needSwapB1Max = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer n : key) {
            int cntInB1 = b1.getOrDefault(n, 0);
            int cntInB2 = b2.getOrDefault(n, 0);
            long total = cntInB1 + cntInB2;
            if (total % 2 != 0) {
                return -1;
            }
            long mid = total / 2L;
            if (cntInB1 > mid) {
                while (cntInB1 != mid) {
                    needSwapB1Max.add(n);
                    cntInB1--;
                }
            } else if (cntInB2 > mid) {
                while (cntInB2 != mid) {
                    needSwapB2.add(n);
                    cntInB2--;
                }
            }
        }
        long ans = 0;

        while (!needSwapB1Max.isEmpty()) {
            ans += Math.min(Math.min(needSwapB1Max.poll(), needSwapB2.poll()), min * 2L);
        }

        return ans;
    }
}
