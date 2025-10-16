public class No2566 {
    public static void main(String[] args) {
        No2566 o = new No2566();
        System.out.println(o.minMaxDifference(90));
    }

    public int minMaxDifference(int num) {
        String str = String.valueOf(num);
        int index = 0;
        while (index < str.length() && (char) str.charAt(index) == '9') {
            index++;
        }
        int max = num;
        if (index < str.length()) {
            max = Integer.parseInt(str.replaceAll(str.charAt(index) + "", "9"));
        }

        index = 0;
        while (index < str.length() && (char) str.charAt(index) == '0') {
            index++;
        }
        int min = num;
        if (index < str.length()) {
            min = Integer.parseInt(str.replaceAll(str.charAt(index) + "", "0"));

        }


        return max - min;
    }
}
