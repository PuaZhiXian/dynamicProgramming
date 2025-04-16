import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2096 {
    public static void main(String[] args) {
        No2096 obj = new No2096();
        TreeNode tree2 = new TreeNode(2, new TreeNode(6), new TreeNode(4));
        TreeNode tree1 = new TreeNode(1, new TreeNode(3), null);
        TreeNode tree5 = new TreeNode(5, tree1, tree2);
        System.out.println(obj.getDirections(tree5, 3, 6));//UURL

        int n =100_000;
        System.out.println(n);
    }


    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        helper2(root, startValue, list1);
        helper2(root, destValue, list2);


        int l = Math.min(list1.size(), list2.size());
        int startingIndex = 0;
        for (int i = 0; i < l; i++) {
            if (list1.get(i) == list2.get(i)) {
                startingIndex++;
            } else {
                break;
            }
        }


        // SOURCE generate
        StringBuilder result = new StringBuilder();
        char[] chars = new char[list1.size() - startingIndex];
        Arrays.fill(chars, 'U');
        result.append(chars);
        //DEST generate

        for (int i = startingIndex; i < list2.size(); i++) {
            result.append(list2.get(i));
        }

        return result.toString();
    }

    public StringBuilder helper(TreeNode root, int val) {
        if (root == null) {
            return new StringBuilder();
        }

        if (root.left != null && root.left.val == val) {
            return new StringBuilder("L");
        }

        if (root.right != null && root.right.val == val) {
            return new StringBuilder("R");
        }
        StringBuilder fromLeft = helper(root.left, val);
        if (fromLeft.length() == 0) {
            StringBuilder fromRight = helper(root.right, val);
            if (fromRight.length() == 0) {
                return fromRight;
            }
            return fromRight.insert(0, "R");
        }
        return fromLeft.insert(0, "L");
    }

    public boolean helper2(TreeNode root, int val, List<Character> list) {
        if (root == null) {
            return false;
        }

        if (root.left != null && root.left.val == val) {
            list.add('L');
            return true;
        }

        if (root.right != null && root.right.val == val) {
            list.add('R');
            return true;
        }

        if (!helper2(root.left, val, list)) {
            if (!helper2(root.right, val, list)) {
                return false;
            }
            list.add(0, 'R');
            return true;
        }
        list.add(0, 'L');
        return true;
    }
}
