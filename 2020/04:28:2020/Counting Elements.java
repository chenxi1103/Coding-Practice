/**
 *  Given an integer array arr, count element x such that x + 1 is also in arr. If there're duplicates in arr, count them seperately.
 *  https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289/
 */
class Solution {
    public int countElements(int[] arr) {
        int[] map = new int[1002];
        int result = 0;
        for (int val : arr) {
            map[val] += 1;
        }
        for (int val : arr) {
            if (map[val + 1] > 0) result++;
        }
        return result;
    }
}