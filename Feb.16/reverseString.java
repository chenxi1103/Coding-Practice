class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length <= 1) return;
        helper(0, s);
        return;
    }
    private void helper(int index, char[] s) {
        if (index == s.length / 2) {
            return;
        }
        char temp = s[index];
        s[index] = s[s.length - index - 1];
        s[s.length - index - 1] = temp;
        helper(index + 1, s);
    }
}
