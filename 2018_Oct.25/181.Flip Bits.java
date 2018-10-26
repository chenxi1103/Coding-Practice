public class Solution {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     * 又是非常经典的位运算题目，flip bit一看就要通过抑或来看有几位是不一样的
     * 记录有几位不一样，则是每记录一位就右移一位，现在可能不太习惯，以后会习惯的！
     * 今天把位运算搞定吧！就这么决定了！
     * 2018-oct25-2:30pm
     */
    public int bitSwapRequired(int a, int b) {
        // write your code here
        int counter = 0;
        for(int i = a^b; i!=0; i = i>>>1){
            counter += i&1;
        }
        return counter;
    }
}
