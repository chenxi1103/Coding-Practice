public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
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
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix == null || matrix.length == 0) return -1;
        PriorityQueue<element> pq = new PriorityQueue<>();
        int size = 0;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i] == null || matrix[i].length == 0) continue;
            size += matrix[i].length;
            element currE = new element(i, 0, matrix[i][0]);
            pq.offer(currE);
        }
        int count = 0;
        while(!pq.isEmpty()){
            element currE = pq.poll();
            count++;
            if(count == k) return currE.val;
            if(currE.col + 1 < matrix[currE.row].length){
                currE.col++;
                currE.val = matrix[currE.row][currE.col];
                pq.offer(currE);
            }
        }
        return -1;
    }
}
