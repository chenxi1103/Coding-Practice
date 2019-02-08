public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        int start = 0;
        int longest = 0;
        for(int i = 0; i < s.length(); i++) {
            int length1 = findLongestPalindrome(s, i, i);
            if(length1 > longest) {
                longest = length1;
                start = i - length1 / 2;
            }
            int length2 = findLongestPalindrome(s, i, i+1);
            if(length2 > longest) {
                longest = length2;
                start = i - length2/2 + 1;
            }
        }
        return s.substring(start, start + longest);

    }
    private int findLongestPalindrome(String s, int left, int right) {
        int start = left;
        int end = right;
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) != s.charAt(end)) break;
            start--;
            end++;
        }
        if(start == left || end == right) return 0;
        start++;
        end--;
        return end - start + 1;
    }
}
