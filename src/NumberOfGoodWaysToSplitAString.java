import java.util.HashMap;

/*https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/*/
public class NumberOfGoodWaysToSplitAString {
    public static void main(String[] args) {
        NumberOfGoodWaysToSplitAString obj = new NumberOfGoodWaysToSplitAString();
        String str1 = "aacaba";
        System.out.println(obj.numSplits(str1));
    }

    public int numSplits(String s) {
        //HashMap to store identifical
        HashMap<Character, Integer> character = new HashMap<Character, Integer>();

        for (int i = 0; i < 26; i++) {
            char temp = (char) ('a' + i);
            character.put(temp, 2);
        }

        int stringLength = s.length();
        int[] fromLeft = new int[stringLength];
        int[] fromRight = new int[stringLength];

        //create left array
        fromLeft[0] = (character.get(s.charAt(0)) / 2);
        character.put(s.charAt(0), 1);
        for (int i = 1; i < stringLength; i++) {
            fromLeft[i] = fromLeft[i - 1] + (character.get(s.charAt(i)) / 2);
            character.put(s.charAt(i), 1);
        }

        //create right array
        fromRight[stringLength - 1] = character.get(s.charAt(stringLength - 1));
        character.put(s.charAt(stringLength - 1), 0);
        for (int i = stringLength - 2; i >= 0; i--) {
            fromRight[i] = fromRight[i + 1] + character.get(s.charAt(i));
            character.put(s.charAt(i), 0);
        }

        //loop split
        int cnt = 0;
        for (int i = 0; i < stringLength - 1; i++) {
            if (fromLeft[i] == fromRight[i + 1]) {
                cnt++;
            }
        }
        return cnt;
    }
}

