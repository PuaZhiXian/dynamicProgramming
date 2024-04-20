/**
 * https://leetcode.com/problems/fair-distribution-of-cookies/
 */
public class No2305_FairDistributionOfCookies {


    public static void main(String[] args) {
        No2305_FairDistributionOfCookies obj = new No2305_FairDistributionOfCookies();
        int[] cookies1 = {8, 15, 10, 20, 8};
        System.out.println(obj.distributeCookies(cookies1, 2));
    }

    int min = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        int[] ppl = new int[k];
        backTracker(0, cookies, ppl);
        return min;
    }


    public void backTracker(int currentNodeIndex, int[] cookies, int[] ppl) {
        if (currentNodeIndex == cookies.length) {
            getUnfairness(ppl);
            return;
        }
        int currentNodeValue = cookies[currentNodeIndex];
        for (int i = 0; i < ppl.length; i++) {
            ppl[i] += currentNodeValue;
            backTracker(currentNodeIndex + 1, cookies, ppl);
            ppl[i] -= currentNodeValue;
        }
    }

    public void getUnfairness(int[] ppl) {
        int max = Integer.MIN_VALUE;
        for (int v : ppl) {
            max = Math.max(max, v);
        }
        min = Math.min(min, max);
    }
}
