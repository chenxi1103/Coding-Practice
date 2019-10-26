class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> min = new ArrayList<>();

        for (int i = 0; i < triangle.size(); i++) {
            min.add(new ArrayList<>());
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int currMin = getMin(triangle, min, i, j);
                min.get(i).add(currMin);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < min.get(min.size() - 1).size(); i++) {
            result = Math.min(min.get(min.size() - 1).get(i), result);
        }
        return result;
    }

    private int getMin(List<List<Integer>> triangle, List<List<Integer>> min, int row, int col) {
        int curNum = triangle.get(row).get(col);
        int neighborRow = row - 1;
        int neighborCol1 = col - 1;
        int neighborCol2 = col;

        int result = Integer.MAX_VALUE;
        if (neighborRow  >= 0 && neighborCol1 >= 0) {
            result = Math.min(result, min.get(neighborRow).get(neighborCol1) + curNum);
        }
        if (neighborRow  >= 0 && neighborCol2 < min.get(neighborRow).size()) {
            result = Math.min(result, min.get(neighborRow).get(neighborCol2) + curNum);
        }
        return result == Integer.MAX_VALUE ? curNum : result;
    }
}
