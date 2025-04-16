import java.util.Map;

public class Spreadsheet {

    int[][] map;

    public Spreadsheet(int rows) {
        map = new int[26][rows];
    }

    public void setCell(String cell, int value) {
        char c = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        map[c - 'A'][row] = value;
    }

    public void resetCell(String cell) {
        char c = cell.charAt(0);
        int row = Integer.parseInt(cell.substring(1));
        map[c - 'A'][row] = 0;
    }

    public int getValue(String formula) {
        String[] val = formula.substring(1).split("\\+");
        char c1 = val[0].charAt(0);
        char c2 = val[1].charAt(0);

        int v1 = 0;
        int v2 = 0;
        if (c1 >= 'A' && c1 <= 'Z') {
            v1 = map[c1-'A'][Integer.parseInt(val[1].substring(1))];
        } else {
            v1 = Integer.parseInt(val[0]);
        }

        if (c2 >= 'A' && c2 <= 'Z') {
            v2 = map[c2-'A'][Integer.parseInt(val[1].substring(1))];
        } else {
            v2 = Integer.parseInt(val[0]);
        }
        return v1 + v2;

    }
}
