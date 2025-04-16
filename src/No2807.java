public class No2807 {
    public static void main(String[] args) {
        No2807 obj = new No2807();


        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(10, n3);
        ListNode n1 = new ListNode(6, n2);
        ListNode head = new ListNode(18, n1);
        ListNode ans = obj.insertGreatestCommonDivisors(head);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;

        while (cur != null) {
            int gcd = GCD(prev.val, cur.val);
            prev.next = new ListNode(gcd, cur);

            prev = cur;
            cur = cur.next;
        }


        return head;
    }

    public int GCD(int num1, int num2) {
        int Temp, GCD = 0;
        while (num2 != 0) {
            Temp = num2;
            num2 = num1 % num2;
            num1 = Temp;
        }
        GCD = num1;
        return GCD;
    }
}
