public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        dfs(s, result, new ArrayList<String>(), 0);
        return result;
    }
    private void dfs(String s, List<List<String>> result, ArrayList<String> subset, int index){
        if(s.length() == index){
            result.add(new ArrayList<String>(subset));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String curr_str = s.substring(index, i + 1);
            if(curr_str.length() > 2) break;
            subset.add(curr_str);
            dfs(s, result, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
