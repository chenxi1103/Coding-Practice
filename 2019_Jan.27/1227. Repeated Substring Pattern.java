public class Solution {
    /**
     * @param s: a string
     * @return: return a boolean
     */
    public boolean repeatedSubstringPattern(String s) {
        // write your code here
        if (s == null || s.length() <= 1) return false;
        for(int i = 1; i < s.length() / 2 + 1; i++) {
            if(s.charAt(i) != s.charAt(0)) continue;
            String sub = s.substring(0, i);
            if(isValid(s, sub)) return true;
        }
        return false;
    }
    private boolean isValid(String s, String pattern) {
        int size = pattern.length();
        for(int i = 0; i < s.length(); i = i + size) {
            if(i + size > s.length()) return false;
            String sub = s.substring(i, i + size);
            if(!sub.equals(pattern)) return false;
        }
        return true;
    }
}
