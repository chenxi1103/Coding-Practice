//这道题告诉我一个道理：
//implement comparable的object，比告诉priorityqueue怎么比较这种object，运行速度快很多
//相同的代码，如果去教priorityqueue怎么比较element，速度会慢到无法通过测试，原理不知道是为啥，反正就是这样就对了…
public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    class element implements Comparable<element>{
        int row, col, val;
        public element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
        @Override
        public int compareTo(element other){
            return this.val - other.val;
        }
    }
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0) return new int[0];
        PriorityQueue<element> pq = new PriorityQueue<element>();
        int size = 0;
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i] == null || arrays[i].length == 0) continue;
            size += arrays[i].length;
            element currE = new element(i, 0, arrays[i][0]);
            pq.offer(currE);
        }
        int index = 0;
        int[] result = new int[size];
        while(!pq.isEmpty()){
            element currE = pq.poll();
            result[index++] = currE.val;
            if(currE.col+1 < arrays[currE.row].length){
                currE.col = currE.col + 1;
                currE.val = arrays[currE.row][currE.col];
                pq.offer(currE);
            }
        }
        return result;
    }
}
