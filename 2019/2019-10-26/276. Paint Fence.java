
class Solution {
    public int numWays(int n, int k) {
        int[] posts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) posts[i] = k;
            else if (i == 2) posts[i] = k * k;
            else {
              //涂色和前一个不一样 = posts[i-1] * (k-1)
              //涂色和前一样一样 = posts[i-2] * (k-1)
                posts[i] = (posts[i - 2] + posts[i - 1]) * (k - 1);
            }
        }
        return posts[n];
    }
}
