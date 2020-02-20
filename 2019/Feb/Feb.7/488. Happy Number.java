public class Solution {
    /**
     * @param n: An integer
     * @return: true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();
        int square = getSquareValue(n);
        set.add(square);
        while(square != 1) {
            square = getSquareValue(square);
            if(set.contains(square)) return false;
            set.add(square);
        }
        return true;
    }
    private int getSquareValue(int currNum) {
        int result = 0;
        while(currNum != 0) {
            int currDigit = currNum % 10;
            result += currDigit * currDigit;
            currNum = currNum / 10;
        }
        return result;
    }
}
