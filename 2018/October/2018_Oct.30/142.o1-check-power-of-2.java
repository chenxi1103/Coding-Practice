public class Solution {
    /**
     * @param n: An integer
     * @return: True or false
     * 这道题已经想到用2进制来做了，但是没有想到具体的办法，不过是在进步的过程中，加油
     * Oct-30-11:59am
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n<=0) return false;
        //这里利用了，如果是2的倍数的二进制数都是一个数为1，后面全是0。那么比它小1的数就是
        //第一位是0，后面全是1，两个数做与运算应该为0
        return (n&(n-1)) == 0;
    }
}
