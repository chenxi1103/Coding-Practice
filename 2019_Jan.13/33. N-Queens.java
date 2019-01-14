//怎么感觉组合类都是不看index的…
//典型的n皇后问题，记住解题思路，还有就是皇后的走法是米字形走法，记得如何判断valid
public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), n);
        return result;
    }
    private List<String> drawChessboard(List<Integer> cols){
        List<String> result = new ArrayList<>();
        for(int i = 0; i<cols.size(); i++){
            int curr_col = cols.get(i);
            String str = "";
            for(int j = 0; j<cols.size(); j++){
                if(j != curr_col){
                    str += ".";
                }else{
                    str += "Q";
                }
            }
            result.add(str);
        }
        return result;
    }

    private void dfs(List<List<String>> result, List<Integer> cols, int n){
        if(cols.size() == n){
            List<String> subset = drawChessboard(cols);
            result.add(subset);
        }
        for(int i = 0; i < n; i++){
            if(!isValid(cols, i)) continue;
            cols.add(i);
            dfs(result, cols, n);
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(List<Integer> cols, int curr_col){
        int curr_row = cols.size();
        for(int i = 0; i<cols.size(); i++){
            int col = cols.get(i);
            int row = i;
            if(col == curr_col) return false;
            if(Math.abs(curr_col - col) == Math.abs(curr_row - row)) return false;
        }
        return true;
    }

}
