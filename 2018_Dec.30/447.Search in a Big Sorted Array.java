public class Solution {
    /*
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return: An integer which is the first index of target.
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if(reader.get(0) == Integer.MAX_VALUE) return -1;
        if(reader.get(0) == target) return 0;
        int last_index = getLastIndex(reader, 1) - 1;
        int start = 0, end = last_index;
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(reader.get(mid) == target || reader.get(mid) > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(reader.get(start) == target) return start;
        if(reader.get(end) == target) return end;
        return -1;
    }
    //先用倍增法找到最大的index是多少，再用二分法找出target
    private int getLastIndex(ArrayReader reader, int k){
        if(reader.get(k) == Integer.MAX_VALUE) return k;
        return getLastIndex(reader, 2*k);
    }
}
