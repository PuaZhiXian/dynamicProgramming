public class No1323 {
    public static void main(String[] args) {
        No1323 o = new No1323();
        System.out.println(o.maximum69Number(9669));
    }

    public int maximum69Number(int num) {
        int ans = 0;
        String s = num + "";
        int multiple = (int) Math.pow(10, s.length()-1);
        boolean found = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6' && !found) {
                ans += multiple * 9;
                found = true;
            } else {
                ans += multiple * Integer.parseInt(s.charAt(i) + "");
            }
            multiple /= 10;
        }


        return ans;
    }
}
