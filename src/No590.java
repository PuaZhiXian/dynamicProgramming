import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No590 {
    public static void main(String[] args) {
        No590 obj = new No590();


        Node node3 = new Node(3, Arrays.asList(new Node(5), new Node(6)));
        Node node1 = new Node(1, Arrays.asList(node3, new Node(2), new Node(4)));

        System.out.println(obj.postorder(node1));
    }

    public List<Integer> postorder(Node root) {
        List<Integer> n = new ArrayList<>();
        if (root == null) {
            return n;
        }
        helper(root, n);
        return n;
    }


    public void helper(Node node, List<Integer> ans) {
        List<Node> children = node.children;
        if (children != null) {
            for (Node child : children) {
                helper(child, ans);
            }
        }
        ans.add(node.val);
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}