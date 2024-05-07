import java.util.Stack;

public class No2816_DoubleaNumberRepresentedasaLinkedList {
    public static ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }

        ListNode fromBack = stack.pop();
        ListNode pre = fromBack;
        int carryOver = 0;
        while (true) {
            int val = fromBack.val;
            val = val * 2;
            int remainder = val % 10;

            fromBack.val = remainder + carryOver;
            carryOver = val / 10;
            if (!stack.empty()) {
                fromBack = stack.pop();
            } else {
                break;
            }
        }
        if (carryOver != 0) {
            fromBack = new ListNode(carryOver, fromBack);
        }
        return fromBack;
    }
}