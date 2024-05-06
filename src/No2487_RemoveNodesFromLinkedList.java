import java.util.ArrayList;
import java.util.List;

public class No2487_RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        ListNode n4 = new ListNode(1, null);
        ListNode n3 = new ListNode(1, n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(1, n2);
        No237_DeleteNodeinaLinkedList.print(removeNodes(n1));
    }

    public static ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        List<ListNode> nodeList = new ArrayList<>();

        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        ListNode result = nodeList.get(nodeList.size() - 1);
        int max = result.val;
        for (int i = nodeList.size() - 2; i >= 0; i--) {
            if (nodeList.get(i).val >= max) {
                nodeList.get(i).next = result;
                result = nodeList.get(i);
            }
            max = Math.max(max, nodeList.get(i).val);
        }
        return result;
    }
}