import java.util.Arrays;

public class No2037_MinimumNumberofMovestoSeatEveryone {
    public static void main(String[] args) {
        System.out.println(minMovesToSeat(new int[]{3, 1, 5}, new int[]{2, 7, 4}));
    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int sum = 0;
        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }
        return sum;
    }
}
