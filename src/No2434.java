import java.util.Stack;

public class No2434 {
    public static void main(String[] args) {
        No2434 o = new No2434();

        System.out.println(o.robotWithString("vzhofnpo"));
    }

    public String robotWithString(String s) {
        int[] cnt = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            cnt[c - 'a']++;
        }

        char cur = 'a';
        StringBuffer sb = new StringBuffer();
        Stack<String> stack = new Stack<>();


        for (char c : chars) {
            stack.add(String.valueOf(c));
            cnt[c - 'a']--;
            while (cur != 'z' && cnt[cur - 'a'] == 0) {
                cur = (char) (cur + 1);
            }

            while (!stack.isEmpty() && stack.peek().compareTo(String.valueOf(cur)) <= 0) {
                sb.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }
}
