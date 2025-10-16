import java.io.IOException;

public class No3495 {
    public static void main(String[] args) throws IOException {
    }

    int[] power = new int[]{1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824};

    public long minOperations(int[][] queries) {
        long ans = 0;
        for (int[] query : queries) {
            ans += section(query[0], query[1]);
        }
        return ans;
    }

    private long section(int s, int e) {
        long sectionStep =0;
        for (int i = 0; i < power.length; i++) {
            if (power[i] <= s) {
                continue;
            }
            int sectionBorder = Math.min(power[i] - 1, e);
            sectionStep += (long) (sectionBorder - s + 1) * i;
            s = Math.min(power[i], e);

            if (power[i] > e) {
                break;
            }
        }

        return (long) Math.ceil((double) sectionStep / 2);
    }
}
