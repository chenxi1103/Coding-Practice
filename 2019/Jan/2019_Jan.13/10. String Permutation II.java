//这是组合题，和之前做的排列题有些不同
//用同样的方法去重，但是这个更类似图的题，要记录已经visit的点，而不是记录index，for循环也是从0开始for而不是从index开始for。
//可能还是没有完全理解吧，多做做这种题，但是总体来说换汤不换药
public class Solution {
    /**
     * @param str: A string
     * @return: all permutations
     */
    public List<String> stringPermutation2(String str) {
        // write your code here
        List<String> result = new ArrayList<>();
        char[] split = str.toCharArray();
        Arrays.sort(split);
        boolean[] visited = new boolean[split.length];
        dfs(split, visited, result, "");
        return result;
    }
    private void dfs(char[] split, boolean[] visited, List<String> result, String currStr){
        if(currStr.length() == split.length){
            result.add(new String(currStr));
            return;
        }
        for(int i = 0; i < split.length; i++){
            if(visited[i] || (i != 0 && split[i] == split[i-1] && !visited[i-1])){
                continue;
            }
            currStr += split[i];
            visited[i] = true;
            dfs(split, visited, result, currStr);
            currStr = currStr.substring(0, currStr.length() - 1);
            visited[i] = false;
        }
    }
}
