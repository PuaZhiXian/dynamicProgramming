/**
*https://leetcode.com/problems/distribute-coins-in-binary-tree
*/
public class NO979_DistributeCoinsinBinaryTree {
    public static void main(String[] args) {
        TreeNode n = new TreeNode(5, new TreeNode(0), new TreeNode(0));
        TreeNode n1 = new TreeNode(0, new TreeNode(0), new TreeNode(0));
        TreeNode n2 = new TreeNode(0, n, n1);
        TreeNode n3 = new TreeNode(3, n2, null);
        System.out.println(distributeCoins(n3)); //11

        TreeNode nn = new TreeNode(3, new TreeNode(0), new TreeNode(0));
        System.out.println(distributeCoins(nn));//2

        TreeNode nnn = new TreeNode(0, new TreeNode(3), new TreeNode(0));

        System.out.println(distributeCoins(nnn));//3

    }

    public static int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int step = 0;
        int pocket = root.val;
        int left = distributeCoins(root.left);
        int right = distributeCoins(root.right);

        if (root.left != null) {
            step = step + left + Math.abs(root.left.val);
            pocket = pocket + root.left.val;
        }
        if (root.right != null) {
            step = step + right + Math.abs(root.right.val);
            pocket = pocket + root.right.val;
        }
        root.val = pocket - 1;
        return step;
    }
}
