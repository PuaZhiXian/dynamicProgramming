public class No2696 {
    public static void main(String[] args) {
        No2696 obj = new No2696();
    }

    public int minLength(String s) {
        while (s.contains("AB") || s.contains("CD")) {
            s = s.replace("AB", "");
            s = s.replace("CD", "");
        }
        return s.length();
    }


}
