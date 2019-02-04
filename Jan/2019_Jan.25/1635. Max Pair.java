//今日感想： 逻辑都对，就是exceed time limit。。。可见平时写码从来都不注意时间空间复杂度的优化了。。。
//感觉面试题都是，只能达到做出来的水平，但是时间空间复杂度都不尽人意，希望以后能在写题前多想想有什么办法可以有最优解，然后再下笔把。。。
public class Solution {
    /**
     * @param a: the first list
     * @param b: the second list
     * @param x: the max sum
     * @return: the pairs whose sum are not exceed x
     */
    public int[][] getAns(int[] a, int[] b, int x) {
        // Write your code here.
        Arrays.sort(a);
        Arrays.sort(b);
        ArrayList<ArrayList<Integer>> list = findMax(a, b, x);
        int count = 0;
        int[][] result = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            result[i][0] = list.get(i).get(0);
            result[i][1] = list.get(i).get(1);
        }
        return result;
    }
    private ArrayList<ArrayList<Integer>> findMax(int[] a, int[] b, int x) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int left = 0, right = b.length - 1, max = 0;
        while(left < a.length && right >= 0) {
            int curr = a[left] + b[right];
            if(curr < max) {
                left++;
            } else if (curr > max) {
                if (curr <= x) {
                    max = curr;
                    list.clear();
                    ArrayList<Integer> sublist = new ArrayList<>();
                    sublist.add(a[left]);
                    sublist.add(b[right]);
                    list.add(sublist);
                    left++;
                } else {
                    right--;
                }
            } else {
                ArrayList<Integer> sublist = new ArrayList<>();
                sublist.add(a[left]);
                sublist.add(b[right]);
                list.add(sublist);
                left++;
            }
        }
        return list;
    }
}
