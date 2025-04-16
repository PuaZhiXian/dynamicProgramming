public class No1325_DeleteLeavesWithAGivenValue {
    public static void main(String[] args) {
        TreeNode n = new TreeNode(2, new TreeNode(2), null);
        TreeNode n2 = new TreeNode(3, new TreeNode(2), new TreeNode(4));
        TreeNode n3 = new TreeNode(1, n, n2);
        System.out.println(removeLeafNodes(n3, 2));

    }

    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                return null;
            } else {
                return root;
            }
        } else {
            return root;
        }
    }
}
