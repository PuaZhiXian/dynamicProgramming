public class No796 {
    public static void main(String[] args) {
        No796 obj = new No796();
        System.out.println(obj.rotateString("abcde", "bcdea"));
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int target = 0;
            int cnt = 0;

            while (true) {
                if (s.charAt(start) != goal.charAt(target)) {
                    break;
                } else {
                    cnt++;
                    start++;
                    target++;
                    if (start == s.length()) {
                        start = 0;
                    }
                    if (cnt == goal.length()) {
                        return true;
                    }
                }
            }
        }


        return false;
    }
}
