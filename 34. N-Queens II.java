public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        List<Integer> solution = new ArrayList();
        List<List<Integer>> list = new ArrayList();
        
        DFS(solution, n, list, new boolean[n]);
        int num = list.size();
        return num;
    }
    
    private void DFS(List<Integer> solution,
                    int n,
                    List<List<Integer>> list,
                    boolean[] usedcolumn) {
        
        if (!isValid(solution)) {
            return;
        }
        
        if (solution.size() == n) {
            list.add(solution);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (usedcolumn[i]) {
                continue;
            }
            solution.add(i);
            usedcolumn[i] = true;
            DFS(solution, n, list, usedcolumn);
            solution.remove(solution.size() - 1);
            usedcolumn[i] = false;
        }
        return;
    }
    
    private boolean isValid(List<Integer> solution) {
        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();
        
        for (int i = 0; i < solution.size(); i++) {
            if (set1.contains(i + solution.get(i))) {
                return false;
            }
            if (set2.contains(i - solution.get(i))) {
                return false;
            }
            set1.add(i + solution.get(i));
            set2.add(i - solution.get(i));
        }
        return true;
    }
}
