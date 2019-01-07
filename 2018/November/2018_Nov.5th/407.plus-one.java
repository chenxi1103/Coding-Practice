public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
       digits[digits.length-1]++;
       int temp = digits[digits.length-1];
       if(temp < 10) return digits;
       int i = digits.length-1;
       while(temp == 10 && i>0){
           digits[i] = 0;
           digits[--i]++;
           temp = digits[i];
       }
       if(i == 0 && (digits[i] == 0 || digits[i] == 10)){
           int[] result = new int[digits.length+1];
           result[0] = 1;
           return result;
       }
       return digits;
    }
}
