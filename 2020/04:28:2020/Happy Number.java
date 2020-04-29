/**
 * Write an algorithm to determine if a number n is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Return True if n is a happy number, and False if not.
 * https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3284/
 */
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            n = getDigitSquareSum(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }
    private int getDigitSquareSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}