class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length <= 1) return;
        helper(0, s.length - 1, s);
        return;
    }
    private void helper(int start, int end, char[] s) {
        if (start >= end) {
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        helper(start + 1, end - 1, s);
    }
}
