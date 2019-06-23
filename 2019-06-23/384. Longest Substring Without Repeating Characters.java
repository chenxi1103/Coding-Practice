//一道做过挺多次的题了？以至于第一眼看过去还是会想用一个array来存访问过的字符
public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int result = 0, leftIndex = 0;
        if (s == null || s.length() == 0) return result;
        // ASCII一共256个？256个应该够了。。。
        int[] alphabetCount = new int[256];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char currChar = charArray[i];
            if (alphabetCount[currChar] == 0) {
                alphabetCount[currChar]++;
            } else {
                result = result < (i - leftIndex) ? (i - leftIndex) : result;
                while (charArray[leftIndex] != currChar) {
                    alphabetCount[charArray[leftIndex]]--;
                    leftIndex++;
                }
                leftIndex++;
            }
        }
        // 最后还要再判断一下，老是忘记这里所以不能一次过。。。
        result = result < (s.length() - leftIndex) ? (s.length() - leftIndex) : result;
        return result;
    }
}

//一道滑动窗口的经典题
//视频里讲的解法：和不看视频自己写的思路一样，但是while loop写的更明智。也不需要跳出for循环后再判断一遍了
//我的方法是for循环rightIndex, 视频是for循环leftIndex, 显然后者更明智，注意如何合并while循环条件
public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        int result = 0;
        if (s == null || s.length() == 0) return result;
        char[] charArray = s.toCharArray();
        int[] alphabetCount = new int[256];
        int leftIndex = 0, rightIndex = 0;
        for (; leftIndex < charArray.length; leftIndex++) {
            while (rightIndex < charArray.length && alphabetCount[charArray[rightIndex]] == 0) {
                alphabetCount[charArray[rightIndex]]++;
                rightIndex++;
                result = result < (rightIndex - leftIndex) ? (rightIndex - leftIndex) : result;
            }
            alphabetCount[charArray[leftIndex]] = 0;
        }
        return result;
    }
}
