public class No1123 {
    public static void main(String[] args) {
        No1123 obj = new No1123();
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Model m = isPotentialAns(root);
        return m.node;
    }

    public Model isPotentialAns(TreeNode root) {
        if (root == null) {
            return new Model(null, 0);
        }

        Model left = isPotentialAns(root.left);
        Model right = isPotentialAns(root.right);


        if (left.h == right.h) {
            return new Model(root, left.h + 1);
        } else if (left.h > right.h) {
            left.h = left.h + 1;
            return left;
        } else {
            right.h = right.h + 1;
            return right;
        }
    }


    class Model {
        TreeNode node;
        int h;

        public Model(TreeNode node, int h) {
            this.node = node;
            this.h = h;
        }
    }
}
