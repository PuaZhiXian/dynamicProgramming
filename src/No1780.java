public class No1780 {
    public static void main(String[] args) {
        No1780 obj = new No1780();
        System.out.println(obj.checkPowersOfThree(12));
        System.out.println(obj.checkPowersOfThree(21));
    }

    public boolean checkPowersOfThree(int n) {
        String str = Integer.toString(n, 3);
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c != '0' && c != '1') {
                return false;
            }
        }


        return true;
    }


}
