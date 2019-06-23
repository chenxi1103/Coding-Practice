// 亚麻的题，滑动窗口again，这次比较明智的选择是循环rightIndex，要灵活一点，不是一定要循环
// rightIndex或者leftIndex，看情况。
public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null) return 0;
        if (s.length() < k) return s.length();
        int[] alphabetCount = new int[256];
        int leftIndex = 0, rightIndex = 0;
        int distinctCount = 0;
        int result = 0;
        char[] charArray = s.toCharArray();
        for (; rightIndex < charArray.length; rightIndex++) {
            alphabetCount[charArray[rightIndex]]++;
            if (alphabetCount[charArray[rightIndex]] == 1) distinctCount++;
            while (distinctCount > k) {
                alphabetCount[charArray[leftIndex]]--;
                if (alphabetCount[charArray[leftIndex]] == 0) {
                    distinctCount--;
                }
                leftIndex++;
            }
            result = Math.max(result, rightIndex - leftIndex + 1);
        }
        return result;
    }
}
