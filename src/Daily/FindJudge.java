package Daily;

public class FindJudge {

    public static void main(String[] args) {
        int n1 = 2;
        int[][] trust1 = {{1, 2}};

        int n2 = 3;
        int[][] trust2 = {{1, 3}, {2, 3}};

        int n3 = 3;
        int[][] trust3 = {{1, 3}, {2, 3}, {3, 1}};

        int n4 = 4;
        int[][] trust4 = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        FindJudge obj = new FindJudge();
        System.out.println(obj.findJudge(n1, trust1));
        System.out.println(obj.findJudge(n2, trust2));
        System.out.println(obj.findJudge(n3, trust3));
        System.out.println(obj.findJudge(n4, trust4));
    }

    public int findJudge(int n, int[][] trust) {
        int[] cnt = new int[n];
        int[] pure = new int[n];

        for (int i = 0; i < trust.length; i++) {
            int ppl = trust[i][0] - 1;
            int trustTo = trust[i][1] - 1;
            cnt[trustTo]++;
            pure[ppl] = 1;
        }

        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == n - 1 && pure[i] == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}
