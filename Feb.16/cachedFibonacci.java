class Solution {
    public int fib(int N) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return f(N, map);
    }
    private int f(int N, HashMap<Integer, Integer> map) {
        if(N == 0) {
            map.put(N, 0);
            return 0;
        }
        if(N == 1 || N == 2) {
            map.put(N, 1);
            return 1;
        }
        if(map.containsKey(N)) {
            return map.get(N);
        }
        int result = f(N-1, map) + f(N-2, map);
        map.put(N, result);
        return result;
    }
}
