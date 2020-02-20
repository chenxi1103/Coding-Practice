class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return new int[0][0];
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        stack.push(list);
        for (int i = 1; i < intervals.length; i++) {
            List<Integer> currList = stack.peek();
            if (intervals[i][1] > currList.get(1)) {
                if (currList.get(1) >= intervals[i][0]) {
                    currList.add(1, intervals[i][1]);
                } else {
                    List<Integer> newlist = new ArrayList<>();
                    newlist.add(intervals[i][0]);
                    newlist.add(intervals[i][1]);
                    stack.push(newlist);
                }
            }
        }
        int[][] result = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            List<Integer> currList = stack.pop();
            result[i][0] = currList.get(0);
            result[i][1] = currList.get(1);
        }
        return result;
    }
}
