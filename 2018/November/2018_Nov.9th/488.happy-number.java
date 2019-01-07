public class Solution {
    /**
     * @param n: An integer
     * @return: true if this is a happy number or false
     * 唯一需要注意的是，用hashset记录每次的值，如果出现循环了，它肯定不会是快乐数了
     */
    public boolean isHappy(int n) {
        // write your code here
        HashSet<Integer> set = new HashSet<Integer>();
        int temp = helper(n);
        set.add(temp);
        while(temp!=1){
            temp = helper(temp);
            if(set.contains(temp)) return false;
            set.add(temp);
        }
        return true;
    }
    public int helper(int n){
        int result = 0;
        while(n!=0){
            result+= Math.pow(n%10,2);
            n /= 10;
        }
        return result;
    }
}
