/**
 * public class GitRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use GitRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 * 和普通的first position of target的区别是： 只要找到badversion，就要一直往前找，到最后，
 * 先判断start是不是bad的，不是bad一定是end，因为只要有bad version，end一定是等于bad version的（详见22行）
*/
public class Solution {
    /**
     * @param n: An integer
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if(n == 1) return 1;
        int start = 1, end = n;
        while(start+1 < end){
            int mid = start + (end - start)/2;
            if(SVNRepo.isBadVersion(mid)){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(SVNRepo.isBadVersion(start)) return start;
        return end;
    }
}
