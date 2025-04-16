public class No725 {
    public static void main(String[] args) {
        No725 obj = new No725();

        ListNode l10 = new ListNode(10);
        ListNode l9 = new ListNode(9, l10);
        ListNode l8 = new ListNode(8, l9);
        ListNode l7 = new ListNode(7, l8);
        ListNode l6 = new ListNode(6, l7);
        ListNode l5 = new ListNode(5, l6);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, null);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        ListNode[] ans = obj.splitListToParts(l1, 5);
        for (ListNode a : ans) {
            while (a != null) {
                System.out.print(a.val + " ");
                a = a.next;
            }
            System.out.println();
        }
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        int minSize = size / k;
        int reminder = size % k;
        if (k > size) {
            reminder = 0;
        }

        ListNode pointer = head;
        for (int i = 0; i < ans.length; i++) {
            ListNode tempHead = pointer;
            for (int j = 0; j < minSize - 1; j++) {
                pointer = pointer.next;
            }

            if (reminder > 0) {
                pointer = pointer.next;
                reminder--;
            }

            if (pointer == null) {
                break;
            }
            ListNode newNode = pointer.next;
            pointer.next = null;
            pointer = newNode;

            ans[i] = tempHead;
        }

        return ans;
    }
}
