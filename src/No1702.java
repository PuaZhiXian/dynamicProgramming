public class No1702 {
    public static void main(String[] args) {
        No1702 o = new No1702();
        System.out.println(o.maximumBinaryString("000110"));
    }

    public String maximumBinaryString(String binary) {
        char[] chars = binary.toCharArray();
        int oneCnt = 0;
        int zeroCnt = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (chars[i] == '1') {
                oneCnt++;
            } else {
                zeroCnt++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeroCnt; i++) {
            if (i == zeroCnt - 1) {
                sb.append("0");
            } else {
                sb.append("1");
            }
        }
//        System.out.println(sb.toString());
        for (int i = 0; i < oneCnt; i++) {
            sb.append("1");
        }

        return sb.toString();
    }

}
