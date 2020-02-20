public class Solution {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        if(chars == null || chars.length <= 1) return;
        int left = 0, right = chars.length - 1;
        while (left <= right){
            while(left <= right && chars[left] - 97 >= 0){
                left++;
            }
            while(left <= right && chars[right] - 97 < 0){
                right--;
            }
            if(left <= right){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return;
    }
}
