public class No1367 {
    public static void main(String[] args) {
        No1367 obj = new No1367();
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        return helper(head,head,root);
    }

    public boolean helper(ListNode head, ListNode cur, TreeNode root) {
        if (cur == null) {
            return true;

        }
        if (root == null) {
            return false;
        }

        if (cur.val == root.val) {
            cur = cur.next;
        } else if (head.val == root.val) {
            head = head.next;
        } else {
            cur = head;
        }
        return helper(head, cur, root.left) || helper(head, cur, root.right);
    }
}
