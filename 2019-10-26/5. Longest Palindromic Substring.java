class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String result = "";
        int start = 0;
        int longest = 0;
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            len = findPalindrome(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }
            len = findPalindrome(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
        }
        return s.substring(start, longest + start);

    }
    private int findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }
}
