public class Solution {
    /*
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     * 这道题一直没读懂题意，其实题目让你返回最后一个数字，是指最后结果只取以这个数字为index，
     * 之前的所有数，都不等于elem就行了，也就是说，把所有不等于elem元素的值，移动到这个index
     * 之前！这样就很清楚了！
     * oct-30-10：08pm
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A == null || A.length == 0) return 0;
        int i = 0;
        int pointer = A.length-1;
        while(i<=pointer){
            if(A[i] == elem){
                A[i] = A[pointer];
                pointer--;
            }else{
                i++;
            }
        }
        return pointer+1;
    }
}
