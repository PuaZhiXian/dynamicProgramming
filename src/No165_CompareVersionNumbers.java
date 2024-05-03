import java.util.Arrays;

public class No165_CompareVersionNumbers {
    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001"));//0
        System.out.println(compareVersion("1.0", "1.0.0"));//0
        System.out.println(compareVersion("0.1", "1.1"));//-1
        System.out.println(compareVersion("1", "1.1"));//-1
        System.out.println(compareVersion("1.1.1", "1.1"));//1
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n1 = v1.length;
        int n2 = v2.length;
        for (int i = 0; i < Math.max(n1, n2); i++) {
            int num1 = i >= n1 ? 0 : Integer.parseInt(v1[i]);
            int num2 = i >= n2 ? 0 : Integer.parseInt(v2[i]);
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
        }
        return 0;
    }
}
