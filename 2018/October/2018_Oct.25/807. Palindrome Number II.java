public class Solution {
    /**
     * @param n: non-negative integer n.
     * @return: return whether a binary representation of a non-negative integer n is a palindrome.
     * 非常简单的回文题，重点是你十进制转二进制还是不熟练，等上18600的时候好好学学，嗯！
     * 2018-10-25 1:54pm
     */
    public boolean isPalindrome(int n) {
        // Write your code here
        char[] c = Integer.toBinaryString(n).toCharArray();
        int head = 0;
        int tail = c.length-1;
        while(head<tail){
            if(c[head] == c[tail]){
                head++;
                tail--;
            }else{
                return false;
            }
        }
        return true;
    }
}
