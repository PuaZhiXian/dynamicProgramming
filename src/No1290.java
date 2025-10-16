public class No1290 {
    public static void main(String[] args) {
        No1290 o = new No1290();
    }

    public int getDecimalValue(ListNode head) {
        String s = String.valueOf(head.val);
        while (head.next != null) {
            head = head.next;
            s += head.val;
        }

        return Integer.parseInt(s, 2);
    }
}
