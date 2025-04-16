import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No2196 {
    public static void main(String[] args) {
        No2196 obj = new No2196();
        TreeNode root = obj.createBinaryTree(
                new int[][]{
                        {20, 15, 1},
                        {20, 17, 0},
                        {50, 20, 1},
                        {50, 80, 0},
                        {80, 19, 1}
                }
        );TreeNode.printInorder(root);
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, List<No2196DescModel>> map = new HashMap<>();
        Map<Integer, Boolean> isRoot = new HashMap<>();
        for (int i = 0; i < descriptions.length; i++) {
            List<No2196DescModel> list = map.getOrDefault(descriptions[i][0], new ArrayList<>());
            list.add(new No2196DescModel(descriptions[i][1], descriptions[i][2]));
            map.put(descriptions[i][0], list);

            isRoot.put(descriptions[i][1], false);
            isRoot.put(descriptions[i][0], isRoot.getOrDefault(descriptions[i][0], true));
        }

        TreeNode root = null;
        TreeNode cur = null;

        for (Map.Entry<Integer, Boolean> entry : isRoot.entrySet()) {
            if (entry.getValue()) {
                System.out.println(entry.getKey());
                root = new TreeNode(entry.getKey());
                cur = root;
                break;
            }
        }
        generateNode(map, cur);
        return root;
    }

    public void generateNode(Map<Integer, List<No2196DescModel>> map, TreeNode root) {
        if (root == null) {
            return;
        }
        List<No2196DescModel> list = map.getOrDefault(root.val, new ArrayList<>());
        for (No2196DescModel model : list) {
            TreeNode node = new TreeNode(model.val);
            if (model.isLeft == 1) {
                root.left = node;
            } else {
                root.right = node;
            }
        }
        generateNode(map, root.left);
        generateNode(map, root.right);
    }

    class No2196DescModel {
        int val;
        int isLeft;

        public No2196DescModel(int val, int isLeft) {
            this.val = val;
            this.isLeft = isLeft;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getIsLeft() {
            return isLeft;
        }

        public void setIsLeft(int isLeft) {
            this.isLeft = isLeft;
        }

        @Override
        public String toString() {
            return String.format("model --> val : %s , left : %s", val, isLeft);
        }
    }
}

