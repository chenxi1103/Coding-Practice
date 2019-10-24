class Solution {
  //很久不刷题，非常手生，这道题的关键在于，如果A全变成一样了，那变成一样的那个值就是A[0]，如果B都变成一样了，那变成一样的那个值就是B[0]，所以如果
  //但凡有一个位置A[i]和B[i]都不等于A[0],也不等于B[0]，就证明它只能是-1了，不可能实现了
    public int minDominoRotations(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0 || A.length != B.length) {
            return -1;
        }
        int[] p = new int[]{A[0], B[0]};
        int[] countA = new int[]{0, 0};
        int[] countB = new int[]{0, 0};
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < p.length; j++) {
                if (p[j] != 0) {
                    if(A[i] == p[j]) countA[j]++;
                    if(B[i] == p[j]) countB[j]++;
                    if(A[i] != p[j] && B[i] != p[j]) p[j] = 0;
                }
            }
        }
        if(p[0] == 0 && p[1] == 0) return -1;
        int min = A.length;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > 0) min = Math.min(min, A.length - Math.max(countA[i], countB[i]));
        }
        return min;
    }
}
