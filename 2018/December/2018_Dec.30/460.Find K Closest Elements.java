public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    //第一次pass： 先用二分法找到离target最近（或等于）的数，然后再左右指针向外扩散
    //问题依然出在容易out of boundary上，还有代码可读性不强，应封装成函数。
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if(k == 0) return new int[0];
        int start = 0, end = A.length - 1, mid = 0;
        while(start+1<end){
            mid = start + (end-start)/2;
            if(A[mid] == target) break;
            else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(A[mid] != target){
            mid = Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;
        }
        int counter = 1, left = mid-1, right = mid+1;
        int[] result = new int[k];
        result[0] = A[mid];
        while(left>=0 && right <=A.length - 1 && counter <= k-1){
            result[counter++] = Math.abs(A[left]-target) <= Math.abs(A[right]-target) ? A[left--] : A[right++];
        }
        if(left == -1 && counter < k){
            while(right <=A.length - 1 && counter <= k-1){
                result[counter++] = A[right++];
            }
        }
        if(right == A.length && counter < k){
            while(left >= 0 && counter <= k-1){
                result[counter++] = A[left--];
            }
        }
        return result;
    }
}



/////////////////////////////////////第二次pass，封装好的函数，更具可读性/////////////////////////////////////////
public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // write your code here
        if(k == 0) return new int[0];
        int mid = findClosestIndex(A, target);
        int left = mid - 1, right = mid + 1;
        int[] result = new int[k];
        result[0] = A[mid];
        for(int i = 1; i < k; i++){
            if(isLeftCloser(left,right,A,target)){
                result[i] = A[left--];
            }else{
                result[i] = A[right++];
            }
        }
        return result;
    }

    private int findClosestIndex(int[] A, int target){
        // 普通二分法先找最近的数
        int start = 0, end = A.length -1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        return Math.abs(A[start] - target) <= Math.abs(A[end] - target) ? start : end;
    }

    private boolean isLeftCloser(int left, int right,int[] A, int target){
        // 判断左边比较近还是右边比较近
        if(left < 0) return false;
        if(right > A.length - 1) return true;
        return Math.abs(A[left] - target) <= Math.abs(A[right] - target) ? true : false;
    }
}
