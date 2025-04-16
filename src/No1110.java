import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No1110 {
    List<TreeNode> list = new ArrayList<>();

    public static void main(String[] args) {
        No1110 obj = new No1110();
//        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
//        TreeNode node3 = new TreeNode(3, new TreeNode(6), new TreeNode(7));
//        TreeNode node1 = new TreeNode(1, node2, node3);
//        List<TreeNode> result = obj.delNodes(node1, new int[]{3, 5});


        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3, null, new TreeNode(4));
        TreeNode node1 = new TreeNode(1, node2, node3);

        List<TreeNode> result = obj.delNodes(node1, new int[]{3, 4});

        for (TreeNode r : result) {
            TreeNode.printInorder(r);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        Set<Integer> set = new HashSet<>();
        for (int n : to_delete) {
            set.add(n);
        }

        needRemove(root, set);
        if (!set.contains(root.val)) {
            list.add(root);
        }
        return list;
    }

    public boolean needRemove(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return true;
        }
//        System.out.println(root.val);
        boolean rootNeedRemove = false;
        if (set.contains(root.val)) {
            rootNeedRemove = true;
        }

        boolean leftNeedRemove = needRemove(root.left, set);
        if (leftNeedRemove) {
            root.left = null;
        } else if (rootNeedRemove) {
            list.add(root.left);
        }

        boolean rightNeedRemove = needRemove(root.right, set);
        if (rightNeedRemove) {
            root.right = null;
        } else if (rootNeedRemove) {
            list.add(root.right);
        }

        return rootNeedRemove;
    }
}
