// 和三角形是一样的问题
public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        int negative = -1 * Integer.MAX_VALUE;
        int positive = Integer.MAX_VALUE;
        Arrays.sort(numbers);
        for(int i = 0; i<numbers.length; i++){
            int left = 0;
            int right = i - 1;
            while(left < right){
                int diff = numbers[left] + numbers[right] + numbers[i] - target;
                if(diff == 0) return target;
                else if(diff < 0){
                    negative = Math.max(negative, diff);
                    left++;
                }else{
                    positive = Math.min(positive, diff);
                    right--;
                }
            }
        }
        if(Math.abs(negative) < positive){
            return target + negative;
        }
        return target + positive;
    }
}
