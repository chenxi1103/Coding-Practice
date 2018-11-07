public class Solution {
    /**
     * @param n: the integer to be reversed
     * @return: the reversed integer
     */
    public int reverseInteger(int n) {
        int result = 0;
        while(n != 0){
            int temp = result*10 + n%10; //无非是这一步记住！！！
            n = n/10;
            if(temp /10 != result){
                return 0;
            }
            result = temp;
        }
        return result;
    }
}
