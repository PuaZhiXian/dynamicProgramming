import java.util.ArrayList;
import java.util.List;

public class No145 {
    public static void main(String[] args) {
        No145 obj = new No145();

        TreeNode n2 = new TreeNode(2, new TreeNode(3), null);
        TreeNode n1 = new TreeNode(1, null, n2);
        System.out.println(obj.postorderTraversal(n1));

    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        helper(ans, root);
        return ans;
    }

    public void helper(List<Integer> ans, TreeNode root) {
        if (root == null)
            return;
        helper(ans, root.left);
        helper(ans, root.right);
        ans.add(root.val);
    }


}
