public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    //只有掌握了这道题才算真的会二分法！
    //用的方法是先找到rotate index确定target在哪个区间，再去用二分法找target，相当于用了两次二分法
    //要注意判断条件，容易错在判断条件上，要多加练习
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        int min_index = findRotateIndex(A);
        if(target < A[min_index]) return -1;
        if(target <= A[A.length-1]){
            return findFinalIndex(A, min_index, A.length-1, target);
        }else{
            if(min_index == 0 && A[A.length-1] != target) return -1;
            return findFinalIndex(A, 0, min_index - 1, target);
        }

    }
    private int findRotateIndex(int[] A){
        int start = 0, end = A.length - 1;
        int target = A[end];
        if(A[0] < target) return 0;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(A[mid-1]>A[mid]) return mid;
            else if(A[mid] < target) end = mid;
            else start = mid;
        }
        return A[start] < A[end] ? start : end;
    }
    private int findFinalIndex(int[] A, int start, int end, int target){
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] < target) start = mid;
            else end = mid;
        }
        if(A[start] == target) return start;
        if(A[end] == target) return end;
        return -1;
    }
}


/////////////////////////////////第二种方法，更简洁，更需要理解，只用一次二分法////////////////////////////
public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        int start = 0, end = A.length-1;
        while(start + 1 < end){
            int mid = start + (end-start)/2;
            if(A[mid] == target) return mid;
            if(A[start] < A[mid]){
                if(A[start] <= target && target <=A[mid]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(A[mid] <= target && target <= A[end]){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(A[start] == target) return start;
        if(A[end] == target) return end;
        return -1;
    }
}
