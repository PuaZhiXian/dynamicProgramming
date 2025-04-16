public class No2375 {
    public static void main(String[] args) {
        No2375 obj = new No2375();
//        System.out.println(obj.smallestNumber("IIIDIDDD"));
        System.out.println(obj.smallestNumber("DDD"));
    }

    public String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder();
        int[] temp = new int[pattern.length() + 1];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = i + 1;
        }

        char[] chars = pattern.toCharArray();


        int index = 0;
        while (index < chars.length) {
            if (chars[index] == 'D') {
                if (temp[index] < temp[index + 1]) {
                    int t = temp[index];
                    temp[index] = temp[index + 1];
                    temp[index + 1] = t;
                    if (index != 0) {
                        index--;
                    }
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }

        for (int j : temp) {
            ans.append(j);
        }
        return ans.toString();
    }
}




