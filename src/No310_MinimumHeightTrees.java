import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-height-trees/description/
 */
public class No310_MinimumHeightTrees {
    public static void main(String[] args) {
        int n1 = 4;
        int[][] edges1 = {{1, 0}, {1, 2}, {1, 3}};

        int n2 = 6;
        int[][] edges2 = {{3, 0}, {3, 1}, {3, 2}, {3, 4}, {5, 4}};

        System.out.println(findMinHeightTrees(n1, edges1));
        System.out.println(findMinHeightTrees(n2, edges2));
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length ==0){
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        int[] queue = new int[n];
        int[] numCnt = new int[n];
        int[] removed = new int[n];
        Map<Integer, List<Integer>> graphMatric = new HashMap<>();
        int writeQueue = 0;
        int readQueue = 0;

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            numCnt[u]++;
            numCnt[v]++;
            graphMatric.putIfAbsent(u, new ArrayList<>());
            graphMatric.putIfAbsent(v, new ArrayList<>());
            graphMatric.get(u).add(v);
            graphMatric.get(v).add(u);
        }

        int groupSize = 0;
        for (int i = 0; i < numCnt.length; i++) {
            if (numCnt[i] == 1) {
                queue[writeQueue] = i;
                writeQueue++;
                groupSize++;
            }
        }

        while (writeQueue < queue.length) {
            int temp = 0;
            for (int i = 0; i < groupSize; i++) {
                int queueOut = queue[readQueue + i];
                removed[queueOut] = 1;
                List<Integer> parent = graphMatric.get(queueOut);
                for (Integer num : parent) {
                    if (removed[num] == 1) {
                        continue;
                    }
                    numCnt[num]--;
                    if (numCnt[num] == 1) {
                        queue[writeQueue] = num;
                        writeQueue++;
                        temp++;
                    }
                }
            }
            readQueue += groupSize;
            groupSize = temp;
        }
        List<Integer> result = new ArrayList<>();
        if (removed[queue[n - 1]] == 0) {
            result.add(queue[n - 1]);
        }
        if (removed[queue[n - 2]] == 0) {
            result.add(queue[n - 2]);
        }
        return result;
    }
}
