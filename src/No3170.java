import javafx.util.Pair;

import java.lang.reflect.Parameter;
import java.util.PriorityQueue;

public class No3170 {
    public static void main(String[] args) {
        No3170 o = new No3170();
        System.out.println(o.clearStars("aaba*"));
    }

    public String clearStars(String s) {
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    int charCompare = Character.compare(a.getKey(), b.getKey());
                    if (charCompare != 0) {
                        return charCompare;
                    } else {
                        return Integer.compare(b.getValue(), a.getValue());
                    }
                }
        );
        int rank = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '*') {
                if (!pq.isEmpty()) {
                    pq.poll();
                }
            } else {
                pq.add(new Pair<>(chars[i], rank));
                rank++;
            }
        }

        PriorityQueue<Pair<Character, Integer>> integerPq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.getValue(), b.getValue())
        );


        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            integerPq.add(pq.poll());

        }
        while (!integerPq.isEmpty()) {
            sb.append(integerPq.poll().getKey());
        }


        return sb.toString();
    }
}
