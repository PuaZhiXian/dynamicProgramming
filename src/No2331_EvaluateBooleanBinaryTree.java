public class No2331_EvaluateBooleanBinaryTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3, new TreeNode(0), new TreeNode(1));
        TreeNode root = new TreeNode(2, new TreeNode(1), n1);
        TreeNode root1= new TreeNode(0);
        System.out.println(evaluateTree(root));
        System.out.println(evaluateTree(root1));
    }

    public static boolean evaluateTree(TreeNode root) {
        if (root.val < 2) { // is value
            return root.val != 0;
        } else if (root.val == 2) { //or
            return evaluateTree(root.left) || evaluateTree(root.right);
        } else {
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
