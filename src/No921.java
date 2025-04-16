public class No921 {
    public static void main(String[] args) {
        No921 obj = new No921();

        System.out.println(obj.minAddToMakeValid("())"));//1
        System.out.println(obj.minAddToMakeValid("((("));//3
        System.out.println(obj.minAddToMakeValid("()))(("));//4
        System.out.println(obj.minAddToMakeValid("()()"));//0
        System.out.println(obj.minAddToMakeValid("(()("));//2
        System.out.println(obj.minAddToMakeValid("(()())(("));//2
    }

    public int minAddToMakeValid(String s) {
        char[] c = s.toCharArray();
        int cnt = 0;
        int cum = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                cum++;
            } else {
                if (cum == 0) {
                    cnt ++;
                }else{
                    cum--;
                }
            }
        }
        return cnt + cum;
    }
}
