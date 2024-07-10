public class No2181 {
    public static void main(String[] args) {
        /*ListNode node8 = new ListNode(0);
        ListNode node7 = new ListNode(2, node8);
        ListNode node6 = new ListNode(5, node7);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(0, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(0, node2);*/

        ListNode node4 = new ListNode(0);
        ListNode node3 = new ListNode(14, node4);
        ListNode node2 = new ListNode(24, node3);
        ListNode node1 = new ListNode(0, node2);

        print(mergeNodes(node1));
//        print(mergeNodes(new ListNode(1)));

    }

    public static ListNode mergeNodes(ListNode head) {
        ListNode cur = head;
        ListNode mover = head.next;
        while (mover != null) {
            if (mover.val != 0) {
                cur.val = cur.val + mover.val;
                mover = mover.next;
            } else {
                mover = mover.next;
                if (mover != null) {
                    cur.next = new ListNode(0);
                    cur = cur.next;
                } else {
                    cur.next = null;
                }

            }
        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
