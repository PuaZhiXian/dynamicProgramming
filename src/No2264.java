public class No2264 {

    public String largestGoodInteger(String num) {
        int max = -1;
        char prev = '-';
        int cnt = 0;

        for (char c : num.toCharArray()) {
            if (prev == c) {
                cnt++;
                if (cnt == 3) {
                    max = Math.max(max, prev);
                }
            } else {
                prev = c;
                cnt = 1;
            }
        }

        return gen((char) max);
    }

    private String gen(char max) {
        switch (max) {
            case '1':
                return "111";
            case '2':
                return "222";
            case '3':
                return "333";
            case '4':
                return "444";
            case '5':
                return "555";
            case '6':
                return "666";
            case '7':
                return "777";
            case '8':
                return "888";
            case '9':
                return "999";
            case '0':
                return "000";
            default:
                return "";
        }
    }
}
