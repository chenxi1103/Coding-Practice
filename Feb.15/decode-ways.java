class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i < memo.length; i++) {
            int single = s.charAt(i-1) - '0';
            int two = (s.charAt(i-2) - '0') * 10 + s.charAt(i-1) - '0';
            if(single > 0 && single <= 9) {
                memo[i] += memo[i-1];
            }
            if(two >= 10 && two <= 26) {
                memo[i] += memo[i-2];
            }
        }
        return memo[s.length()];
    }
}
