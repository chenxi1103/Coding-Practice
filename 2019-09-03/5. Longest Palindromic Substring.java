class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        int maxLength = 0;
        String result = "";
        for (int i = 0; i < s.length() - 1; i++) {
            String max1 = getMax(s, i, i);
            if (max1.length() > maxLength) {
                result = max1;
                maxLength = result.length();
            }

            String max2 = getMax(s, i, i+1);
            if (max2.length() > maxLength) {
                result = max2;
                maxLength = result.length();
            }
        }
        return result;
    }
    private String getMax(String s, int middle1, int middle2) {
        while (middle1 >= 0 && middle2 < s.length()) {
            if (s.charAt(middle1) != s.charAt(middle2)) break;
            middle1--;
            middle2++;
        }
        return s.substring(++middle1, middle2);
    }
}
