// 有一些边界条件容易忘掉，比如如果单纯用空格分开的话，有些单词可能后面跟着逗号句号感叹号啥的
// 要用Character.isLetter()来判断最后一个字符是不是英文字母，还有就是要toLowerCase!
public class Solution {
    /**
     * @param paragraph:
     * @param banned:
     * @return: nothing
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        //
        String[] words = paragraph.split(" ");
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        HashMap<String, Integer> map = new HashMap<>();
        String result = "";
        int maxCount = 0;
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            if(!Character.isLetter(currWord.charAt(currWord.length() - 1))) {
                currWord = currWord.substring(0, currWord.length() - 1);
            }
            currWord = currWord.toLowerCase();
            if(!set.contains(currWord)) {
                if (map.containsKey(currWord)) {
                    map.put(currWord, map.get(currWord) + 1);
                } else {
                    map.put(currWord, 1);
                }
                if(map.get(currWord) > maxCount) {
                    maxCount = map.get(currWord);
                    result = currWord;
                }
            }
        }
        return result;
    }
}
