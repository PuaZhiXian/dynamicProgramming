public class No237_DeleteNodeinaLinkedList {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node2);
        print(node1);
    }

    public static void print(ListNode node) {
        while (true) {
            System.out.println(node.val);
            node = node.next;
            if (node == null) {
                break;
            }
        }
    }

    public static void deleteNode(ListNode node) {
        ListNode pre = null;
        while (true) {
            if (node.next == null) {
                pre.next = null;
                break;
            }
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}