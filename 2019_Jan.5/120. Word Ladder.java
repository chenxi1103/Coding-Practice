//第一：找到所有nextword，用hashmap判断是否杯循环过，没有就压进queue和hashmap。hard难度，记得复习
public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(dict == null) return 0;
        if(start.equals(end)) return 1;
        dict.add(start);
        dict.add(end);
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0; i<size; i++){
                String currStr = queue.poll();
                ArrayList<String> list = findNextWord(currStr, dict);
                for(String word : list){
                    if(set.contains(word)) continue;
                    if(word.equals(end)) return count;
                    queue.offer(word);
                    set.add(word);
                }
            }
        }
        return 0;
    }
    private ArrayList<String> findNextWord(String word, Set<String> dict){
        ArrayList<String> list = new ArrayList<>();
        for(char c = 'a'; c<='z'; c++){
            for(int i = 0; i<word.length(); i++){
                if(word.charAt(i) == c) continue;
                String replaced = replace(word, c, i);
                if(dict.contains(replaced)) list.add(replaced);
            }
        }
        return list;
    }
    private String replace(String word, Character c, int index){
        char[] chars = word.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
