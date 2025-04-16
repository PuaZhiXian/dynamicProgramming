public class No2140 {
    public static void main(String[] args) {
        No2140 obj = new No2140();
    }

    public long mostPoints(int[][] questions) {
        long[] arr = new long[questions.length];
        for (int i = questions.length - 1; i >= 0; i--) {
            int next = questions[i][1] + i + 1;
            if (next < questions.length) {
                if (i < questions.length - 1) {
                    arr[i] = Math.max(arr[next] + questions[i][0], arr[i + 1]);
                } else {
                    arr[i] = arr[next] + questions[i][0];
                }
            } else {
                if (i < questions.length - 1) {
                    arr[i] = Math.max(questions[i][0], arr[i + 1]);
                } else {
                    arr[i] = questions[i][0];
                }
            }
        }

        long max = 0;
        for (long num : arr) {
            max = Math.max(max, num);
        }

        return max;
    }
}
