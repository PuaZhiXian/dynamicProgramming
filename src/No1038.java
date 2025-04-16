public class No1038 {
    private static int cum = 0;

    public static void main(String[] args) {
        /*TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node1 = new TreeNode(1, new TreeNode(0), node2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7, null, node8);
        TreeNode node6 = new TreeNode(6, new TreeNode(5), node7);
        TreeNode node4 = new TreeNode(4, node1, node6);

        No1038 obj = new No1038();
        obj.bstToGst(node4);
        obj.printInorder(node4);*/

        TreeNode node12 = new TreeNode(12, new TreeNode(11), new TreeNode(13));
        TreeNode node8 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode node10 = new TreeNode(10, node8, node12);
        TreeNode node4 = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode node0 = new TreeNode(0, null, new TreeNode(1));
        TreeNode node2 = new TreeNode(2, node0, node4);
        TreeNode node6 = new TreeNode(6, node2, node10);

        No1038 obj = new No1038();
        obj.bstToGst(node6);
        TreeNode.printInorder(node6);
    }

    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    public int helper(TreeNode node, int add) {
        if (node == null)
            return add;

        int right = helper(node.right, add);
        node.val = node.val + right;
        if (node.left != null) {
            return helper(node.left, node.val);
        }
        return node.val;
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
