public class No1598 {
    public static void main(String[] args) {

    }

    public int minOperations(String[] logs) {
        int result = 0;
        String back = "../";
        String stay = "./";

        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals(back)) {
                result = Math.max(result - 1, 0);
            } else if (!logs[i].equals(stay)) {
                result++;
            }
        }

        return result;
    }
}
