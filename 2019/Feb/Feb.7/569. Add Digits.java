public class Solution {
    /**
     * @param num: a non-negative integer
     * @return: one digit
     */
    public int addDigits(int num) {
        // write your code here
        if(num <= 9) return num;
        int currDigit = sumDigits(num);
        while (currDigit > 9) {
            currDigit = sumDigits(currDigit);
        }
        return currDigit;
    }
    private int sumDigits(int num) {
        if(num <= 9) return num;
        int result = 0;
        while(num != 0) {
            int currDigit = num % 10;
            result += currDigit;
            num = num / 10;
        }
        return result;
    }
}
