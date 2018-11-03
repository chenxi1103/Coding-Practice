public class Solution {
    /*
     * @param str: A string
     * @return: a boolean
     * 很自然的想法用hashset，很久没用了所以权当复习一下hashset
     * 如果不用额外的空间的话。。。
     */
    public boolean isUnique(String str) {
        // write your code here
        HashSet<Character> set = new HashSet<Character>();
        for(int i = 0; i<str.length(); i++){
            if(set.contains(str.charAt(i))){
                return false;
            }else{
                set.add(str.charAt(i));
            }
        }
        return true;
    }
}

public class Solution {
    /*
     * @param str: A string
     * @return: a boolean
     * 不用额外空间的方法，简直是个人才233
     * 建立一个256位的boolean array（原因是ascii码表最多就表示256位）
     * 然后boolean array默认值是false，check所在位置是不是true，如果是true就是已经
     * 被遍历过的地方，就有重复字符
     * oct-30-12:24pm
     */
    public boolean isUnique(String str) {
        // write your code here
        boolean [] ascii = new boolean[256];
        for(int i = 0; i<str.length(); i++){
            int pos = str.charAt(i);
            if(ascii[pos]) return false;
            else{
                ascii[pos] = true;
            }
        }
        return true;
    }
}
