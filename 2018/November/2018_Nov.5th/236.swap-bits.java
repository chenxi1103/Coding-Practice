public class Solution {
    /*
     * @param x: An integer
     * @return: An integer
     */
    public int swapOddEvenBits(int x) {
        // write your code here
        // x&0xAAAAAAAA是将偶数位提取出来，右移变成奇数位
        // x&0x55555555是将奇数位提出来，变成偶数为
        // x&0xAAAAAAAA要用无符号运算，防止到最大整数的溢出？
        // 说实话没太懂，需要复习！
        return ((x&0xAAAAAAAA)>>>1 | (x&0x55555555)<<1);
    }
}
