class Solution {
    public int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int step = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int currNum = queue.poll();
                for(int j = sqrt; j >= 1; j--) {
                    int num = currNum - j * j;
                    if(num == 0) return step;
                    else if(num > 0) {
                        queue.offer(num);
                    }
                }
            }
        }
        return step;
    }
}
