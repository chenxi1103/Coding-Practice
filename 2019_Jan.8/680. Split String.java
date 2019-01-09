public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if(s == null) return result;
        dfs(s, result, new ArrayList<String>(), 0);
        return result;
    }
    private void dfs(String s, List<List<String>> result, ArrayList<String> subset, int index){
        if(index == s.length()){
            result.add(new ArrayList<String>(subset));
        }
        for(int i = index; i < s.length(); i++){
            if(i > index + 1) break;
            String str = s.substring(index, i+1);
            subset.add(str);
            dfs(s, result, subset, i+1);
            subset.remove(subset.size() - 1);
        }
    }
}
