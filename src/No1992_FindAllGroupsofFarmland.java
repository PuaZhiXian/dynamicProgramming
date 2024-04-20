import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-all-groups-of-farmland/description/
 */
public class No1992_FindAllGroupsofFarmland {
    public static void main(String[] args) {
        int[][] land1 = {
                {1, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 1, 1}};

        int[][] land2 = {
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}};

        int[][] land3 = {
                {1, 1},
                {1, 1}};

        int[][] land4 = {
                {0}};

        int[][] land5 = {
                {0, 0, 0},
                {0, 0, 0},
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };

//        System.out.println(Arrays.deepToString(findFarmland(land1))); //[[0, 0, 0, 0], [1, 1, 2, 3]]
//        System.out.println(Arrays.deepToString(findFarmland(land2))); // [[0,0,0,0],[1,1,2,2]]
//        System.out.println(Arrays.deepToString(findFarmland(land3))); // [[0,0,1,1]]
//        System.out.println(Arrays.deepToString(findFarmland(land4))); // []
        System.out.println(Arrays.deepToString(findFarmland(land5))); // [[2,0,4,2]]
    }

    public static int[][] findFarmland(int[][] land) {
        ArrayList<int[]> result = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if ((land[i][j] == 1 && i - 1 < 0 && j - 1 < 0) ||
                        (land[i][j] == 1 && (i - 1 < 0 || land[i - 1][j] == 0) && (j - 1 < 0 || land[i][j - 1] == 0))) {
                    int horizontal = 0;
                    int vertical = 0;
//                    System.out.printf("found head {%d,%d}\n", i, j);
                    while (horizontal + j + 1 < land[i].length) {
                        if (land[i][horizontal + j + 1] == 1) {
                            horizontal++;
                        } else {
                            break;
                        }
                    }
                    while (vertical + i + 1 < land.length) {
                        if (land[vertical + i + 1][j] == 1) {
                            vertical++;
                        } else {
                            break;
                        }
                    }

                    int[] coordinates = new int[4];
                    coordinates[0] = i;
                    coordinates[1] = j;
                    coordinates[2] = i + vertical;
                    coordinates[3] = j + horizontal;
                    result.add(coordinates);
//                    System.out.printf("final result horizontal --> %d vertical --> %d \n", horizontal, vertical);
//                    System.out.printf("{%d,%d}{%d,%d}\n", i, j, i + vertical, j + horizontal);
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}
