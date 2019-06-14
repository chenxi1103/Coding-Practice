public class Solution {
    /**
     * @param nums: a list of integer
     * @param k: an integer
     * @return: return a boolean, denote whether the array can be divided into k non-empty subsets whose sums are all equal
     */
    public boolean partitiontoEqualSumSubsets(int[] nums, int k) {
        // write your code here
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) return false;
        int partition = sum / k;
        Arrays.sort(nums);
        if(nums[nums.length - 1] > partition) return false;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, 0, k, 0, partition, visited);
    }
    private boolean dfs(int[] nums, int index, int k, int sum, int partition, boolean[] visited) {
        if(k == 1) {
            return true;
        }
        if(sum == partition) {
            return dfs(nums, 0, k-1, 0, partition, visited);
        }
        for(int i = index; i < nums.length; i++) {
            if (visited[i] || nums[i] + sum > partition) continue;
            visited[i] = true;
            if (dfs(nums, i+1, k, sum + nums[i], partition, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
