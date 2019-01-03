public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    //经典题目，多练习！
    public boolean isPalindrome(String s) {
        // write your code here
        if(s == null) return false;
        if(s.length() <= 1) return true;
        s = s.trim().toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            if(!Character.isLetterOrDigit(s.charAt(left)) && left < s.length() -1){
                left++;
            }
            if(left == s.length() - 1) return true;
            if(!Character.isLetterOrDigit(s.charAt(right)) && right > 0){
                right--;
            }
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return left>=right;
    }
}
