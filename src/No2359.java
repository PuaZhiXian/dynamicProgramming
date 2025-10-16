import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No2359 {
    public static void main(String[] args) {
        No2359 o = new No2359();
        System.out.println(o.closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
//        System.out.println(o.closestMeetingNode(new int[]{4, 4, 4, 5, 1, 2, 2}, 1, 1));
//        System.out.println(o.closestMeetingNode(new int[]{4, 3, 0, 5, 3, -1}, 4, 0));//4
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) {
            return node1;
        }
        int l = edges.length;
        int[] dis1 = new int[l];
        int[] dis2 = new int[l];

        Arrays.fill(dis1, -1);
        Arrays.fill(dis2, -1);

        int next = edges[node1];
        int d = 0;
        while (next != -1 && dis1[next] == -1) {
            dis1[next] = d++;
            next = edges[next];
        }

        next = edges[node2];
        d = 0;
        while (next != -1 && dis2[next] == -1) {
            dis2[next] = d++;
            next = edges[next];
        }
        dis1[node1] = 0;
        dis2[node2] = 0;


//        System.out.println(Arrays.toString(dis1));
//        System.out.println(Arrays.toString(dis2));

        int ans = -1;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l; i++) {
            if (dis2[i] == -1 || dis1[i] == -1) {
                continue;
            }
            max = Math.max(dis1[i], dis2[i]);
            if (max < min) {
                min = max;
                ans = i;
            }
        }
        return ans;
    }
}
