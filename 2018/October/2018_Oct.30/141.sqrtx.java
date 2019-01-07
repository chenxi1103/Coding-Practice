public class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     * 这依旧是一个有关int越界的故事…(╯°Д°）╯︵ /(.□ . \)
     * 其实从4开始，所有数的平方根都是小于它的一半的…等数字变大，随便一平方
     * 整数就越界惹…必须用long！因为long能表达的最大数字2^64，正好是int能表达的最大数
     * 2^32的平方，也就是说整数不管咋平方，都不会越long这个界，所以还是很安全的！
     * 最后返回的时候转成int就成
     * 这里使用了二分法来让时间复杂度变为n(log(n))
     * date；oct-30 1；59am
     */
    public int sqrt(int x) {
        // write your code here
        if(x <= 1) return x;
        return (int)helper((long)1, (long)x/2, (long)x);
    }
    public long helper(long start, long end, long x){
        long mid = start+(end-start)/2;
        if(mid*mid<=x && (mid+1)*(mid+1)>x){
            return mid;
        }
        if(mid*mid < x){
            return helper(mid, end, x);
        }
        return helper(start, mid, x);
    }
}
