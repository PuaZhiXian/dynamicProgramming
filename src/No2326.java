import java.util.Arrays;

public class No2326 {
    public static void main(String[] args) {
        No2326 obj = new No2326();

        ListNode n0_2 = new ListNode(0);
        ListNode n5_2 = new ListNode(5, n0_2);
        ListNode n5_1 = new ListNode(5, n5_2);
        ListNode n2_2 = new ListNode(2, n5_1);
        ListNode n4 = new ListNode(4, n2_2);
        ListNode n9 = new ListNode(9, n4);
        ListNode n7 = new ListNode(7, n9);
        ListNode n1 = new ListNode(1, n7);
        ListNode n8 = new ListNode(8, n1);
        ListNode n6 = new ListNode(6, n8);
        ListNode n2_1 = new ListNode(2, n6);
        ListNode n0_1 = new ListNode(0, n2_1);
        ListNode n3 = new ListNode(3, n0_1);

        System.out.println(Arrays.deepToString(obj.spiralMatrix(3, 5, n3)));
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] temp : matrix) {
            Arrays.fill(temp, -1);
        }
        int height = m - 1;
        int width = n;

        int x = 0;
        int y = -1;
        int direction = 0;

        while (head != null) {
            if (direction == 0 || direction == 2) {
                for (int i = 0; i < width; i++) {
                    if (direction == 0) {
                        y++;
                    } else {
                        y--;
                    }
//                    System.out.printf("x:%s, y:%s ==>\n", x, y);
                    matrix[x][y] = head.val;
                    head = head.next;
                    if (head == null) {
                        return matrix;
                    }

                }
                direction++;
                width--;
            } else {
                for (int i = 0; i < height; i++) {
                    if (direction == 1) {
                        x++;
                    } else {
                        x--;
                    }
//                    System.out.printf("x:%s, y:%s\n", x, y);
                    matrix[x][y] = head.val;
                    head = head.next;
                    if (head == null) {
                        return matrix;
                    }

                }
                direction++;
                if (direction == 4) {
                    direction = 0;
                }
                height--;
            }
        }

        return matrix;
    }
}
