import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2058 {
    public static void main(String[] args) {
        ListNode node7 = new ListNode(2);
        ListNode node6 = new ListNode(1, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(5, node2);

        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(node1)));
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head.next == null) {
            return new int[]{-1, -1};
        }
        List<Integer> store = new ArrayList<>();
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode next = cur.next;
        int index = 1;

        int min = Integer.MAX_VALUE;
        while (next != null) {
            if ((cur.val > pre.val && cur.val > next.val) || (cur.val < pre.val && cur.val < next.val)) {
                store.add(index);
                if (store.size() >= 2) {
                    min = Math.min(min, store.get(store.size() - 1) - store.get(store.size() - 2));
                }
            }
            pre = cur;
            cur = next;
            next = next.next;
            index++;
        }

        if (store.size() < 2) {
            return new int[]{-1, -1};
        }
        int max = store.get(store.size() - 1) - store.get(0);

        return new int[]{min, max};
    }
}
