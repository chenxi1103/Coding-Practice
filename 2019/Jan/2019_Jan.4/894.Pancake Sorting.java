//煎饼排序，很简单，找到最大值，翻转两次把最大值放到最后面，然后缩小array大小。
public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        // Write your code here
        if(array == null || array.length <= 1) return;
        int length = array.length - 1;
        while(length > 0){
            int max = array[0], max_index = 0;
            for(int i = 0; i<=length; i++){
                if(array[i] > max){
                    max = array[i];
                    max_index = i;
                }
            }
            FlipTool.flip(array, max_index);
            FlipTool.flip(array, length);
            length--;
        }
        return;
    }
}
