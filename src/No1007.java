public class No1007 {
    public static void main(String[] args) {
        No1007 obj = new No1007();

    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int cnt = Integer.MAX_VALUE;

        int[] possible = new int[]{tops[0], bottoms[0]};

        for (int i = 0; i < possible.length; i++) {
            int temp = 0;
            boolean valid = true;
            for (int j = 0; j < tops.length; j++) {
                if (tops[j] != possible[i] && bottoms[j] != possible[i]) {
                    temp = -1;
                    valid = false;
                    break;
                } else if (tops[j] != possible[i] && bottoms[j] == possible[i]) {
                    temp++;
                }
            }
            if (valid) {
                cnt = Math.min(cnt, temp);
            }
        }

        for (int i = 0; i < possible.length; i++) {
            int temp = 0;
            boolean valid = true;
            for (int j = 0; j < tops.length; j++) {
                if (bottoms[j] != possible[i] && tops[j] != possible[i]) {
                    temp = -1;
                    valid = false;
                    break;
                } else if (bottoms[j] != possible[i] && tops[j] == possible[i]) {
                    temp++;
                }
            }
            if (valid) {
                cnt = Math.min(cnt, temp);
            }
        }


        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }
}
