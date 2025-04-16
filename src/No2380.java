public class No2380 {
    public static void main(String[] args) {
        No2380 obj = new No2380();
        System.out.println(obj.secondsToRemoveOccurrences("0110101"));
    }

    public int secondsToRemoveOccurrences(String s) {
        int ans = 0;

        while (s.contains("01")) {
            s = s.replace("01", "10");
            ans++;
        }
        return ans;
    }
}
