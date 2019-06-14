//DFS的解法
class Solution {
    int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        dfs(nums, S, 0, 0);
        return result;
    }
    private void dfs(int[] nums, int S, int index, int sum) {
        if (index == nums.length) {
            if (sum == S) {
                result++;
            }
            return;
        }
        dfs(nums, S, index + 1, sum + nums[index]);
        dfs(nums, S, index + 1, sum - nums[index]);
    }
}
// BFS的解法
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(nums[0]);
        queue.add(nums[0] * -1);
        for (int i = 1; i < nums.length; i++) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                int currNum = queue.poll();
                queue.offer(currNum + nums[i]);
                queue.offer(currNum - nums[i]);
            }
        }
        int result = 0;
        while(!queue.isEmpty()) {
            if(queue.poll() == S) {
                result++;
            }
        }
        return result;
    }
}
