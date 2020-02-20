public class Solution {
    /**
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        // write your code here
        if(num <= 0) return false;
        while(num != 1) {
            if(num % 2 == 0) {
                num = num / 2;
                continue;
            }
            if(num % 3 == 0) {
                num = num / 3;
                continue;
            }
            if(num % 5 == 0) {
                num = num / 5;
                continue;
            }
            return false;
        }
        return true;
    }
}
