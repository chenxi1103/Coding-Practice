//Rainbow Sort,不会写，记得复习
public class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        rainbowSort(colors, 0, colors.length - 1, 1, k);
        return;
    }
    private void rainbowSort(int[] colors, int head, int tail, int colorFrom, int colorTo){
        if(colorFrom == colorTo || head >= tail) return;
        int left = head, right = tail;
        int midColor = (colorFrom + colorTo) / 2;
        while(left <= right){
            while(left <= right && colors[left] <= midColor){
                left++;
            }
            while(left <= right && colors[right] > midColor){
                right--;
            }
            if(left <= right){
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
                left++;
                right--;
            }
        }
        rainbowSort(colors, head, right, colorFrom, midColor);
        rainbowSort(colors, left, tail, midColor+1, colorTo);
    }
}
