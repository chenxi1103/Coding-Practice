public class Solution {
    /**
     * @param n: The guest paid
     * @param m: the price
     * @return: the sum of the number of banknotes
     * 听说可以用贪心法和动态规划？以后研究一下！
     * oct-28-10；39
     */
    public int coinProblem(int n, int m) {
        // Write your code here
        int remain = n-m;
        int count = 0;
        int[] list = new int[]{100, 50, 20, 10, 5, 2, 1};
        for(int i = 0; i<list.length; i++){
            count += remain / list[i];
            remain = remain % list[i];
        }
        return count;
    }
}
