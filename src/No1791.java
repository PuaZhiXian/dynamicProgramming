public class No1791 {
    public static void main(String[] args) {
        System.out.println(findCenter(new int[][]{
                {1, 2},
                {2, 3},
                {4, 2}
        }));
    }

    public static int findCenter(int[][] edges) {

        int first = edges[0][0];
        int second = edges[0][1];


        if (edges[1][0] == first || edges[1][1] == first) {
            return first;
        } else {
            return second;
        }
    }
}
