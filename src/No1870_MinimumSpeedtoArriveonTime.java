public class No1870_MinimumSpeedtoArriveonTime {
    public static void main(String[] args) {
        System.out.println(minSpeedOnTime(new int[]{1, 2, 3}, 6));
        System.out.println(minSpeedOnTime(new int[]{1, 2, 3}, 2.7));//3
        System.out.println(6 / 2.7);
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < dist.length; i++) {
            sum += dist[i];
            max = Math.max(max, dist[i]);
        }
        int min = (int) Math.floor(sum / hour);
        max++;
        /*System.out.println(min);
        System.out.println(max);
        System.out.println((int) ((max + min) / 2));*/
        int mid = -1;
        while (min < max) {
            mid = (int) ((max + min) / 2);
            System.out.println(mid);
            if (able(dist, mid, hour)) {
                max = mid;
            } else {
                min = mid;
            }
        }

        return (int) 999;
    }

    public static boolean able(int[] dist, int speed, double hour) {
        int sum = 0;
        for (int i = 0; i < dist.length; i++) {
            sum += Math.ceil((double) dist[i] / speed);
        }
        return sum <= hour;
    }

}
