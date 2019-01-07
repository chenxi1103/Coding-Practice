public class Solution {
    /**
     * @param key: A string you should hash
     * @param HASH_SIZE: An integer
     * @return: An integer
     * 这个问题很tricky，因为没有说明key里到底有几个字符，其实字符多了就非常容易超过整数范围
     * 所以这个sum一定得是long，因为取余之后就会很小变成int，但是sum就不一定了，随便一个33的
     * 好多好多次方，就凉了。
     * 还有就是为了尽可能让long也足够长，要每次只乘一个33，并每次都及时做取余，不要全加完了
     * 再取余，会爆炸💥
     * 需要重新复习的题目！ Oct.30
     */
    public int hashCode(char[] key, int HASH_SIZE) {
        // write your code here
        int counter = key.length-1;
        long sum = 0;
        for(char c : key){
            sum = (sum*33+(int)c)% HASH_SIZE;
        }
        return (int)sum;
    }
}
