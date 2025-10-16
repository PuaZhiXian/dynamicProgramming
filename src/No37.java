import java.util.*;

public class No37 {
    public static void main(String[] args) {
        No37 o = new No37();
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        char[][] board = new char[][]{
//                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
//                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
//                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
//                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        o.solveSudoku(board);
        o.print();
    }

    int[][] point = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};

    List<Set<Character>> row = new ArrayList<>();
    List<Set<Character>> col = new ArrayList<>();
    List<Set<Character>> box = new ArrayList<>();
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        int unfillCnt = init();

        rec(0, 0);
    }

    private boolean rec(int i, int j) {
        if (j == 9) {
            j = 0;
            i++;
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] != '.') {
            return rec(i, j + 1);
        }

        boolean haveOption = false;
        for (int k = 1; k <= 9; k++) {
            char c = getChar(k);
            if (!row.get(i).contains(c) && !col.get(j).contains(c) && !box.get(getBoxIndex(i, j)).contains(c)) {
                row.get(i).add(c);
                col.get(j).add(c);
                box.get(getBoxIndex(i, j)).add(c);

                board[i][j] = c;
                haveOption = rec(i, j + 1);
                if (!haveOption) {
                    board[i][j] = '.';
                    row.get(i).remove(c);
                    col.get(j).remove(c);
                    box.get(getBoxIndex(i, j)).remove(c);
                }
            }
        }

        return haveOption;
    }

    private int init() {
        int unfillCnt = 0;

        for (int[] ints : point) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    char val = board[ints[0] + j][ints[1] + k];
                    if (val == '.')
                        continue;
                    set.add(val);
                }
            }
            box.add(set);
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.')
                    continue;
                set.add(val);
            }
            row.add(set);
        }
        for (int i = 0; i < 9; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char val = board[j][i];
                if (val == '.') {
                    unfillCnt++;
                    continue;
                }
                set.add(val);
            }
            col.add(set);
        }

        return unfillCnt;
    }

    private char getChar(int k) {
        return (char) (k + '0');
    }

    private int getBoxIndex(int i, int j) {
        if (i >= 0 && i < 3) {
            if (j >= 0 && j < 3) {
                return 0;
            } else if (j >= 3 && j < 6) {
                return 1;
            } else {
                return 2;
            }
        } else if (i >= 3 && i < 6) {
            if (j >= 0 && j < 3) {
                return 3;
            } else if (j >= 3 && j < 6) {
                return 4;
            } else {
                return 5;
            }
        } else {
            if (j >= 0 && j < 3) {
                return 6;
            } else if (j >= 3 && j < 6) {
                return 7;
            } else {
                return 8;
            }
        }
    }

    private void print(){
        for (char[] row : board) {
            for (char c : row) {
                System.out.printf(c + " | ");
            }
            System.out.println();
        }
    }
}
