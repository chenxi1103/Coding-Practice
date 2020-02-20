class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if(i == 0 || i == 1) {
                cache[i] = 1;
            } else {
                cache[i] = cache[i-1] + cache[i-2];
            }
        }
        return cache[n];
    }
}

class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return helper(n, map);
    }
    private int helper(int n, Map<Integer, Integer> map) {
        if(n == 0 || n == 1) {
            map.put(n, 1);
            return 1;
        }
        if(map.containsKey(n)) return map.get(n);
        int result = helper(n-1, map) + helper(n-2, map);
        map.put(n, result);
        return result;
    }
}
