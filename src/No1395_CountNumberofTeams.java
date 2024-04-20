/**
 * https://leetcode.com/problems/count-number-of-teams/description/
 */
public class No1395_CountNumberofTeams {
    public static void main(String[] args) {
        No1395_CountNumberofTeams obj = new No1395_CountNumberofTeams();

        int[] arr1 = {2, 5, 3, 4, 1};
        int[] arr2 = {2, 1, 3};
        int[] arr3 = {1, 2, 3, 4};
        System.out.println(obj.numTeams(arr1));
        System.out.println(obj.numTeams(arr2));
        System.out.println(obj.numTeams(arr3));

    }

    public int numTeams(int[] rating) {
        int n = rating.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[i] < rating[j]) {
                    prefix[i]++;
                } else {
                    suffix[i]++;
                }

            }
        }

        int greaterCnt = 0;

        int smallerCnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (rating[j] > rating[i]) {
                    greaterCnt += prefix[j];
                } else {
                    smallerCnt += suffix[j];
                }
            }
        }
        return greaterCnt + smallerCnt;
    }
}
