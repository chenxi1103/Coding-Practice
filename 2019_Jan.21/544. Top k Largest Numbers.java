public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            pq.offer(nums[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] result = new int[k];
        for(int i = k-1; i >= 0; i--){
            result[i] = pq.poll();
        }
        return result;
    }
}
