import java.util.Vector;

public class No1382 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3, null, new TreeNode(4));
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node1 = new TreeNode(1, null, node2);

        No1382 obj = new No1382();
        TreeNode temp = obj.balanceBST(node1);
        obj.printInorder(temp);
    }

    public TreeNode balanceBST(TreeNode root) {
        Vector<Integer> vector = new Vector<>();

        vector = helper(root, vector);
        return createHelper(vector, 0, vector.size() - 1);
    }

    public TreeNode createHelper(Vector<Integer> vector, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (int) Math.floor((start + end) / 2.0);
        TreeNode root = new TreeNode(vector.get(mid));
        root.left = createHelper(vector, start, mid - 1);
        root.right = createHelper(vector, mid + 1, end);
        return root;
    }

    public Vector<Integer> helper(TreeNode root, Vector<Integer> vector) {
        if (root == null) {
            return vector;
        }
        vector = helper(root.left, vector);
        vector.add(root.val);
        vector = helper(root.right, vector);
        return vector;
    }


    void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }
}
