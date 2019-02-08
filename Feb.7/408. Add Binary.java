public class Solution {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        String result = "";
        int sum = 0, carry = 0;
        for(int i = a.length() -1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            sum = carry;
            sum += i < 0 ? 0 : a.charAt(i) - '0';
            sum += j < 0 ? 0 : b.charAt(j) - '0';
            int thisBit = sum % 2;
            result = thisBit + result;
            carry = sum / 2;
        }
        if(carry == 1) {
            result = carry + result;
        }
        return result;
    }
}
