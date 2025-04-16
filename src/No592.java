public class No592 {


    public static void main(String[] args) {
        No592 obj = new No592();
//        System.out.println(obj.fractionAddition("-1/2+1/2")); // 0/1
//        System.out.println(obj.fractionAddition("-1/2+1/2+1/3")); // 1/3
//        System.out.println(obj.fractionAddition("1/3-1/2")); // -1/6
//        System.out.println(obj.fractionAddition("-1/4-4/5-1/4")); // "-13/10"
        System.out.println(obj.fractionAddition("1/1-7/5-5/2")); // "-29/10"
    }

    int t = 0;
    int b = 1;

    public String fractionAddition(String expression) {
        expression = expression.replace("-+", "-").replace("++", "+").replace("+-", "-").replace("--", "+");
        String[] nums = expression.split("/|(?=[-+])");

        for (int i = 0; i < nums.length; i = i + 2) {
            operation(nums[i], nums[i + 1]);
//            System.out.println(t + "/" + b);
        }
        helper();
        return t + "/" + b;
    }


    public void operation(String tt, String bb) {
        int numT = 0;
        int numB = Integer.parseInt(bb);
        if (tt.charAt(0) == '-') {
            numT = -Integer.parseInt(tt.substring(1));
        } else if (tt.charAt(0) == '+') {
            numT = Integer.parseInt(tt.substring(1));
        } else {
            numT = Integer.parseInt(tt);
        }

        if (numB == b) {
            t += numT;
        } else {
            if (numB > b) {
                if (numB % b == 0) {
                    int mulitple = numB / b;
                    t = (t * mulitple) + numT;
                    b = b * mulitple;
                } else {
                    t = (t * numB) + (numT * b);
                    b = b * numB;
                }
            } else {
                if (b % numB == 0) {
                    t = t + (numT * (b / numB));
                } else {
                    t = (t * numB) + (numT * b);
                    b = b * numB;
                }
            }
        }
    }

    public void helper() {
        if (t == 0) {
            b = 1;
        } else {
            int min = Math.min(Math.abs(t), Math.abs(b));
            for (int i = min; i > 0; i--) {
                if (b % i == 0 && t % i == 0) {
                    t /= i;
                    b /= i;
                    return;
                }
            }
        }
    }
}
