public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        for(int i = 0; i < A.length; i++){
            siftUp(A, i);
        }

    }
    public void siftUp(int[] A, int index){
        while(index != 0){
            int parent = (index - 1) / 2;
            if(A[parent] < A[index]) break;
            int temp = A[parent];
            A[parent] = A[index];
            A[index] = temp;
            index = parent;
        }
    }
}
