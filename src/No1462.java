import java.util.*;

public class No1462 {
    public static void main(String[] args) {
        No1462 obj = new No1462();
        System.out.println(obj.checkIfPrerequisite(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{0, 4}, {4, 0}, {1, 3}, {3, 0}}));
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[][] matrix = new int[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            helper(matrix, prerequisites[i][0], prerequisites[i][1]);
        }

        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            if (matrix[queries[i][0]][queries[i][1]] == 1) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public void helper(int[][] matrix, int from, int to) {
        matrix[from][to] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(to);
        while (!queue.isEmpty()) {
            int target = queue.poll();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[target][i] == 1 && matrix[from][i] == 0) {
                    matrix[from][i] = 1;
                    queue.add(i);
                }
            }
        }

    }

}
