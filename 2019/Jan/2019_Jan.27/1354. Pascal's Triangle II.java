public class Solution {
    /**
     * @param rowIndex: a non-negative index
     * @return: the kth index row of the Pascal's triangle
     */
    public List<Integer> getRow(int rowIndex) {
        // write your code here
        return helper(new ArrayList<Integer>(), rowIndex + 1);
    }
    private List<Integer> helper(List<Integer> lastLevel, int n) {
        if (lastLevel.size() == n) return lastLevel;
        if(lastLevel.size() <= 1) {
            lastLevel.add(1);
            return helper(lastLevel, n);
        }
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 1; i < lastLevel.size(); i++) {
            list.add(lastLevel.get(i - 1) + lastLevel.get(i));
        }
        list.add(1);
        return helper(list, n);
    }
}
