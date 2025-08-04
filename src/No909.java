import java.util.ArrayDeque;
import java.util.Deque;

public class No909 {
    public static void main(String[] args) {
        No909 o = new No909();
//2;
        System.out.println(o.snakesAndLadders(new int[][]{{-1, -1, 19, 10, -1}, {2, -1, -1, 6, -1}, {-1, 17, -1, 19, -1}, {25, -1, 20, -1, -1}, {-1, -1, -1, -1, 15}}));
    }

    int[][] board;
    int n;

    public int snakesAndLadders(int[][] board) {
        this.board = board;
        this.n = board.length;
        int target = n * n;
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[target + 1];

        deque.offer(1);
        int move = 0;
        visited[1] = true;
        while (!deque.isEmpty()) {
            for (int i = deque.size(); i > 0; --i) {
                int cur = deque.poll();
                if (cur == target) {
                    return move;
                }
                for (int j = cur + 1; j <= Math.min(cur + 6, target); ++j) {
                    int next = getVal(j);
                    if (next == -1) {
                        next = j;
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        deque.offer(next);
                    }
                }
            }
            move++;
        }

        return -1;
    }

    private int getVal(int num) {
        int row = (num - 1) / n;
        int col = (num - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        return board[n - 1 - row][col];
    }


}
