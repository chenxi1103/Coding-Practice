class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        //老朋友priorityqueue，好久不见，我都忘了default是最小堆了。。。
        //这道题的解法是用最小堆记录结束时间，先根据开始时间对array排序，然后遍历所有开始时间
        //如果开始时间大于最小堆里最小的结束时间，就意味着这个room是available给这个meeting的，不需要room++
        //反之就得再开一间room啦！
        PriorityQueue<Integer> endtimeQueue = new PriorityQueue<>();
        endtimeQueue.add(intervals[0][1]);
        int room = 1;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < endtimeQueue.peek()) {
                endtimeQueue.add(intervals[i][1]);
                room++;
            } else {
                endtimeQueue.poll();
                endtimeQueue.add(intervals[i][1]);
            }
        }
        return room;
    }
}
