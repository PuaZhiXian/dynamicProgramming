import java.util.ArrayList;
import java.util.List;

public class No1530 {
    public static void main(String[] args) {
        No1530 obj = new No1530();
        TreeNode node2 = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode node3 = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        TreeNode node1 = new TreeNode(1, node2, node3);


        System.out.println(obj.countPairs(node1, 3));

    }

    Integer n = 0;

    public int countPairs(TreeNode root, int distance) {
        helper(root, distance);
        return n;
    }

    public List<Integer> helper(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }


        List<Integer> fromLeft = helper(root.left, distance);
        List<Integer> fromRight = helper(root.right, distance);


        for (Integer left : fromLeft) {
            for (Integer right : fromRight) {
                if (left + right <= distance) {
                    n++;
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (Integer left : fromLeft) {
            if (left + 1 < distance) {
                result.add(left + 1);
            }
        }
        for (Integer right : fromRight) {
            if (right + 1 < distance) {
                result.add(right + 1);
            }
        }
        return result;
    }
}
