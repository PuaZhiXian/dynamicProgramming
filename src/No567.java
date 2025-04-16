import java.util.Arrays;

public class No567 {
    public static void main(String[] args) {
        No567 obj = new No567();
//        Input: s1 = "ab", s2 = "eidbaooo"
//        Output: true
//        Input: s1 = "ab", s2 = "eidboaoo"
//        Output: false
        System.out.println(obj.checkInclusion("ab", "eidbaooo"));//true
        System.out.println(obj.checkInclusion("ab", "eidboaoo"));//false
        System.out.println(obj.checkInclusion("adc", "dcda"));//true
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] cnt = new int[26];
        for (char c : s1.toCharArray()) {
            cnt[c - 'a']++;
        }
//        System.out.println(Arrays.toString(cnt));

        int left = 0;
        int right = 0;
        char[] char2 = s2.toCharArray();
        while (right < char2.length) {
            if (cnt[char2[right] - 'a'] > 0) {
                cnt[char2[right] - 'a']--;
                right++;
                if (Arrays.stream(cnt).sum() == 0) {
                    return true;
                }
            } else if (cnt[char2[right] - 'a'] == 0 && left == right) {
                left++;
                right++;
            } else {
                while (cnt[char2[right] - 'a'] <= 0 && left < right) {
                    cnt[char2[left] - 'a']++;
                    left++;
//                    System.out.println("adding " + char2[left]);
//                    System.out.printf("adding :%s , target: %s\n", cnt[char2[left] - 'a'], cnt[char2[right] - 'a']);
                }
            }
        }
//        System.out.println(Arrays.toString(cnt));
//        System.out.printf("sum : %s\n", Arrays.stream(cnt).sum());
        return Arrays.stream(cnt).sum() == 0;
    }
}
