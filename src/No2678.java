public class No2678 {

    public static void main(String[] args) {
        No2678 obj = new No2678();
        System.out.println(obj.countSeniors(new String[]{
                "7868190130M7522", "5303914400F9211", "9273338290F4010"
        }));
    }

    public int countSeniors(String[] details) {
        int ans = 0;

        for (int i = 0; i < details.length; i++) {
            int age = Integer.parseInt(details[i].substring(11, 13));
            if (age > 60) {
                ans++;
            }
        }
        return ans;
    }
}
