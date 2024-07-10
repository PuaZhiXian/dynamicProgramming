public class No1208_GetEqualSubstringsWithinBudget {
    public static void main(String[] args) {
        
        System.out.println(equalSubstring("abcd", "bcdf", 3));//3
        System.out.println(equalSubstring("abcd", "cdef", 3));//1
        System.out.println(equalSubstring("abcd", "acde", 0));//1
        System.out.println(equalSubstring("anryddgaqpjdw", "zjhotgdlmadcf", 5));//1
        System.out.println(equalSubstring("krpgjbjjznpzdfy", "nxargkbydxmsgby", 14));//1
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int[] select = new int[s.length()];
        int[] diff = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int startIndex = 0;
        int endIndex = 0;
        int balance = maxCost;
        int max = 0;
        while (startIndex <= endIndex) {
            if (endIndex >= s.length()) {
                max = Math.max(max, endIndex - startIndex );
                break;
            }
            if (balance - diff[endIndex] >= 0) {
                select[endIndex] = diff[endIndex];
                balance = balance - diff[endIndex];
                max = Math.max(max, endIndex - startIndex);
                endIndex++;
            } else {
                balance += select[startIndex];
                max = Math.max(max, endIndex - startIndex);
                startIndex++;
                if (startIndex > endIndex) {
                    endIndex++;
                }
            }
        }
        return max;
    }
}
