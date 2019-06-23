//依然是滑动窗口，自己可以一次性写对。
public class Solution {
    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        String result = "";
        int resultLength = Integer.MAX_VALUE;
        if (target == null || source == null || target.length() > source.length()) return "";
        int[] targetMap = mapTarget(target);
        int[] alphabetCount = new int[256];
        int leftIndex = 0, rightIndex = 0;
        char[] charArray = source.toCharArray();
        for (; leftIndex < charArray.length; leftIndex++) {
            while (rightIndex < charArray.length && !containsTarget(alphabetCount, targetMap, target)) {
                alphabetCount[charArray[rightIndex]]++;
                rightIndex++;
            }
            if (containsTarget(alphabetCount, targetMap, target)) {
                result = resultLength > (rightIndex - leftIndex) ? source.substring(leftIndex, rightIndex) : result;
                resultLength = resultLength > (rightIndex - leftIndex) ? (rightIndex - leftIndex) : resultLength;
            }
            alphabetCount[charArray[leftIndex]]--;
        }
        return result;
    }

    private boolean containsTarget(int[] alphabetCount, int[] targetMap, String target) {
        for (char c : target.toCharArray()) {
            if (alphabetCount[c] < targetMap[c]) return false;
        }
        return true;
    }

    private int[] mapTarget(String target) {
        int[] targetMap = new int[256];
        for (char c : target.toCharArray()) {
            targetMap[c]++;
        }
        return targetMap;
    }
}
