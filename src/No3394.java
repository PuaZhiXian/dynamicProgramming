import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class No3394 {
    public static void main(String[] args) {
        No3394 obj = new No3394();
        System.out.println(obj.checkValidCuts(33, new int[][]{{0, 0, 9, 1}, {9, 0, 21, 1}, {21, 0, 24, 1}, {24, 0, 27, 1}, {27, 0, 29, 1}, {29, 0, 30, 1}, {30, 0, 31, 1}, {31, 0, 33, 1}, {0, 1, 10, 17}, {0, 17, 2, 30}, {2, 17, 3, 19}, {3, 17, 6, 18}, {3, 18, 4, 19}, {4, 18, 6, 19}, {6, 17, 8, 19}, {8, 17, 9, 19}, {9, 17, 10, 19}, {2, 19, 4, 23}, {2, 23, 3, 30}, {3, 23, 4, 27}, {3, 27, 4, 30}, {4, 19, 5, 24}, {4, 24, 5, 30}, {5, 19, 7, 26}, {5, 26, 6, 30}, {6, 26, 7, 30}, {7, 19, 8, 22}, {7, 22, 8, 25}, {7, 25, 8, 29}, {7, 29, 8, 30}, {8, 19, 9, 22}, {8, 22, 9, 28}, {8, 28, 9, 30}, {9, 19, 10, 23}, {9, 23, 10, 27}, {9, 27, 10, 29}, {9, 29, 10, 30}, {10, 1, 17, 14}, {10, 14, 13, 27}, {10, 27, 11, 30}, {11, 27, 12, 30}, {12, 27, 13, 30}, {13, 14, 15, 28}, {13, 28, 14, 30}, {14, 28, 15, 30}, {15, 14, 16, 22}, {16, 14, 17, 16}, {16, 16, 17, 22}, {15, 22, 16, 25}, {15, 25, 16, 30}, {16, 22, 17, 30}, {17, 1, 24, 2}, {24, 1, 25, 2}, {25, 1, 27, 2}, {27, 1, 29, 2}, {29, 1, 31, 2}, {31, 1, 33, 2}, {17, 2, 23, 22}, {23, 2, 26, 3}, {26, 2, 29, 3}, {29, 2, 30, 3}, {30, 2, 31, 3}, {31, 2, 33, 3}, {23, 3, 28, 19}, {28, 3, 29, 17}, {28, 17, 29, 19}, {29, 3, 31, 6}, {31, 3, 32, 6}, {32, 3, 33, 5}, {32, 5, 33, 6}, {29, 6, 31, 15}, {29, 15, 30, 18}, {29, 18, 30, 19}, {30, 15, 31, 17}, {30, 17, 31, 19}, {31, 6, 32, 18}, {31, 18, 32, 19}, {32, 6, 33, 18}, {32, 18, 33, 19}, {23, 19, 24, 21}, {24, 19, 25, 21}, {25, 19, 29, 21}, {29, 19, 30, 21}, {30, 19, 31, 21}, {31, 19, 32, 21}, {32, 19, 33, 21}, {23, 21, 24, 22}, {24, 21, 28, 22}, {28, 21, 30, 22}, {30, 21, 31, 22}, {31, 21, 33, 22}, {17, 22, 18, 29}, {18, 22, 22, 29}, {22, 22, 25, 26}, {25, 22, 28, 25}, {28, 22, 30, 25}, {30, 22, 31, 24}, {30, 24, 31, 25}, {31, 22, 32, 25}, {32, 22, 33, 25}, {25, 25, 29, 26}, {29, 25, 30, 26}, {30, 25, 31, 26}, {31, 25, 33, 26}, {22, 26, 25, 29}, {25, 26, 28, 29}, {28, 26, 29, 28}, {29, 26, 30, 28}, {30, 26, 31, 28}, {31, 26, 32, 28}, {32, 26, 33, 28}, {28, 28, 30, 29}, {30, 28, 31, 29}, {31, 28, 33, 29}, {17, 29, 24, 30}, {24, 29, 27, 30}, {27, 29, 29, 30}, {29, 29, 30, 30}, {30, 29, 31, 30}, {31, 29, 33, 30}, {0, 30, 16, 32}, {16, 30, 21, 32}, {21, 30, 25, 31}, {21, 31, 23, 32}, {23, 31, 25, 32}, {25, 30, 29, 32}, {29, 30, 30, 32}, {30, 30, 31, 32}, {31, 30, 32, 32}, {32, 30, 33, 32}, {0, 32, 10, 33}, {10, 32, 13, 33}, {13, 32, 21, 33}, {21, 32, 24, 33}, {24, 32, 25, 33}, {25, 32, 28, 33}, {28, 32, 30, 33}, {30, 32, 31, 33}, {31, 32, 33, 33}}));
//        System.out.println(obj.checkValidCuts(5, new int[][]{{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}}));
//        System.out.println(obj.checkValidCuts(4, new int[][]{{0, 0, 1, 1}, {2, 0, 3, 4}, {0, 2, 2, 3}, {3, 0, 4, 3}}));
//        System.out.println(obj.checkValidCuts(4, new int[][]{{0, 2, 2, 4}, {1, 0, 3, 2}, {2, 2, 3, 4}, {3, 0, 4, 2}, {3, 2, 4, 4}}));
//        System.out.println(obj.checkValidCuts(4, new int[][]{{0, 2, 2, 4}, {1, 0, 3, 2}, {2, 2, 3, 4}, {3, 0, 4, 2}, {3, 2, 4, 4}}));
//        System.out.println(obj.checkValidCuts(3, new int[][]{{0, 0, 1, 3}, {1, 0, 2, 2}, {2, 0, 3, 2}, {1, 2, 3, 3}}));
//        System.out.println(obj.checkValidCuts(5, new int[][]{{0, 0, 1, 5}, {1, 0, 3, 3}, {3, 0, 5, 3}, {1, 3, 2, 5}, {2, 3, 5, 5}}));
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < rectangles.length; i++) {
            if (!map.containsKey(rectangles[i][0])) {
                map.put(rectangles[i][0], rectangles[i][2]);
            } else {
                if (map.get(rectangles[i][0]) < rectangles[i][2]) {
                    map.put(rectangles[i][0], rectangles[i][2]);
                }
            }

            if (!mapY.containsKey(rectangles[i][1])) {
                mapY.put(rectangles[i][1], rectangles[i][3]);
            } else {
                if (mapY.get(rectangles[i][1]) < rectangles[i][3]) {
                    mapY.put(rectangles[i][1], rectangles[i][3]);
                }
            }
        }
        return temp(map) || temp(mapY);
    }

    private boolean temp(Map<Integer, Integer> map) {
        map = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        int cnt = 0;
        int e = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int start = entry.getKey();
            int end = entry.getValue();
            if (end >= e) {
                if (start >= e) {
                    cnt++;
                    if (cnt == 3) {
                        return true;
                    }
                }
                e = end;
            }
        }

        return false;
    }
}
