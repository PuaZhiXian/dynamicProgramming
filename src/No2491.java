import java.util.Arrays;

public class No2491 {
    public static void main(String[] args) {
        No2491 obj = new No2491();
        System.out.println(obj.dividePlayers(new int[]{3, 2, 5, 1, 3, 4}));
    }

    public long dividePlayers(int[] skill) {
        long ans = 0;
        Arrays.sort(skill);

        int val = skill[0] + skill[skill.length - 1];
        for (int i = 0; i < skill.length / 2; i++) {
            if (val != (skill[i] + skill[skill.length - i - 1])) {
                return -1;
            }

            ans += ((long) skill[i] * skill[skill.length - i - 1]);
        }
        return ans;
    }
}
