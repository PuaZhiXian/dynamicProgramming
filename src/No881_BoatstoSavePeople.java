import java.util.Arrays;

public class No881_BoatstoSavePeople {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{1, 2}, 3));//1
        System.out.println(numRescueBoats(new int[]{}, 3));//0
        System.out.println(numRescueBoats(new int[]{2}, 3));//1
        System.out.println(numRescueBoats(new int[]{3, 2, 2, 1}, 3));//3
        System.out.println(numRescueBoats(new int[]{3, 5, 3, 4}, 5));//4
    }

    public static int numRescueBoats(int[] people, int limit) {
        int result = 0;
        if (people.length == 1) {
            return 1;
        }
        if (people.length == 0) {
            return 0;
        }
        Arrays.sort(people);
        int ends = people.length - 1;
        int start = 0;
        while (ends > start) {
            if (people[ends] + people[start] > limit) {
                ends--;
            } else {
                ends--;
                start++;
            }
            result++;
        }
        if (ends == start) {
            result++;
        }

        return result;
    }
}
