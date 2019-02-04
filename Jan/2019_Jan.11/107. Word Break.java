//注意，用dfs写这道题可能会超时
public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        List<List<String>> possible = new ArrayList<>();
        dfs(s, possible, new ArrayList<String>(), 0, dict);
        if(possible.size() > 0) return true;
        return false;
    }
    private void dfs(String s, List<List<String>> possible, ArrayList<String> subset, int index, Set<String> dict){
        if(index == s.length()){
            possible.add(new ArrayList<String>(subset));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String curr_str = s.substring(index, i+1);
            if(!dict.contains(curr_str)) continue;
            subset.add(curr_str);
            dfs(s, possible, subset, i+1, dict);
            subset.remove(subset.size() - 1);
        }
    }
}
