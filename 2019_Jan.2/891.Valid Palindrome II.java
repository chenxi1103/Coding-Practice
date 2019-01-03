public class Solution {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        // Write your code here
        if(s == null || s.length() <= 1) return true;
        boolean flag = false;
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(s.charAt(left) != s.charAt(right) && !flag){
                if(left == s.length() -1 || right == 0) return true;
                if(s.charAt(left+1) == s.charAt(right)){
                    left++;
                    flag = true;
                }else if(s.charAt(left) == s.charAt(right-1)){
                    right--;
                    flag = true;
                }else{
                    return false;
                }
            }
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return left>=right;
    }
}
