public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     * 给的答案用的是data stream的方法，暂时不知道是什么鬼，以后再快看看
     * 自己的方法是把string拆分成character的array进行sort。记住这里有个小坑，
     * 是回到c[pointer1-1]不是c[pointer1]
     */
    public char firstUniqChar(String str) {
        // Write your code here
        char[] c = str.toCharArray();
        Arrays.sort(c);
        int pointer1 = 1;
        int pointer2 = 0;
        while(pointer1<c.length&&pointer2<c.length){
            if(c[pointer1] == c[pointer2]){
                pointer1++;
            }else{
                if(pointer1-pointer2 == 1) return c[pointer1-1];
                pointer2 = pointer1;
            }
        }
        return c[pointer1-1];
    }
}
