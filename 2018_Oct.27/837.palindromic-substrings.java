public class Solution {
    /**
     * @param str: s string
     * @return: return an integer, denote the number of the palindromic substrings
     * 这个做的不好，以后要再复习以下，而且这个方法的时间复杂度是o(N)，就很不好
     * 要学一下Manacher‘s Algorithm！
     * oct-27-11:02pm
     */
    public int count = 0;
    public int countPalindromicSubstrings(String str) {
        // write your code here
        if(str == null || str.length() == 0) return 0;
        if(str.length() == 1) return 1;
        for(int i = 0; i<str.length(); i++){
            helper(str,i,i);
            helper(str,i,i+1);
        }
        return count;
    }
    private void helper(String str, int i, int j){
        while(i>=0 && j<str.length() && str.charAt(i) == str.charAt(j)){
            i--;
            j++;
            count++;
        }
    }
}
