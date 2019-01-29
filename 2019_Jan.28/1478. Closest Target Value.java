public class Solution {
    /**
     * @param target: the target
     * @param array: an array
     * @return: the closest value
     */
    public int closestTargetValue(int target, int[] array) {
        // Write your code here
        if(array == null || array.length == 0) return -1;
        Arrays.sort(array);
        int left = 0, right = array.length - 1;
        if (array[0] > target) return -1;
        int closest = Integer.MIN_VALUE;
        while (left < right) {
            int currSum = array[left] + array[right];
            if(currSum < target) {
                if(currSum > closest) {
                    closest = currSum;
                }
                left++;
            }else if (currSum == target) {
                return currSum;
            } else {
                right--;
            }
        }
        return closest;
    }
}
