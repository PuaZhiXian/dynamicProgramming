import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 */
public class No131_PalindromePartitioning {


    public static void main(String[] args) {
        No131_PalindromePartitioning obj = new No131_PalindromePartitioning();
        String text1 = "aab";
        String text2 = "a";
        System.out.println(obj.partition(text1));
        System.out.println(obj.partition(text2));
    }

    public List<List<String>> partition(String text) {
        List<List<String>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), text);
        return result;
    }

    public void helper(List<List<String>> result, List<String> subList, String subString) {
        if (subString.length() == 0) {
            result.add(new ArrayList<>(subList));
            return;
        }

        for (int i = 0; i < subString.length(); i++) {
            String currentText = subString.substring(0, i + 1);
            if (isPalindrome(currentText)) {
                subList.add(currentText);
                helper(result, subList, subString.substring(i + 1));
                subList.remove(subList.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
