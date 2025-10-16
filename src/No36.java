import java.util.HashSet;
import java.util.Set;

public class No36 {
    public static void main(String[] args) {
        No36 o = new No36();
        System.out.println(o.isValidSudoku(new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        int[][] point = new int[][]{{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}};
        for (int i = 0; i < point.length; i++) {
            set = new HashSet<>();

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    char val = board[point[i][0] + j][point[i][1] + k];
                    if (val == '.')
                        continue;
                    if (set.contains(val))
                        return false;
                    set.add(val);
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char val = board[i][j];
                if (val == '.')
                    continue;
                if (set.contains(val))
                    return false;
                set.add(val);
            }
        }

        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char val = board[j][i];
                if (val == '.')
                    continue;
                if (set.contains(val))
                    return false;
                set.add(val);
            }
        }


        return true;
    }
} 
