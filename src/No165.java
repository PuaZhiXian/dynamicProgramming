public class No165 {
    public static void main(String[] args) {
        No165 o = new No165();
        System.out.println(o.compareVersion("1.2", "1.10"));
    }

    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int v1Int = getVal(v1, i);
            int v2Int = getVal(v2, i);

            if (v1Int > v2Int) {
                return 1;
            } else if (v1Int < v2Int) {
                return -1;
            }
        }

        return 0;
    }

    private int getVal(String[] arr, int index) {
        if (index >= arr.length) {
            return 0;
        }
        return Integer.parseInt(arr[index]);
    }
} 
