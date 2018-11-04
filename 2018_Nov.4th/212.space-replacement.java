public class Solution {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     * 有点坑，不知道为啥不能用stringbuffer，返回的length有问题，以后再说吧
     * 问题本身不难，要从后面往前面copy value因为从前面的话数就被覆盖了
     * nov4th 2:05pm
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        if(string == null || string.length == 0) return 0;
        int counter = 0;
        for(int i = 0; i<string.length; i++){
            if(string[i] == 32) counter++;
        }
        int newLen = length+counter*2;
        int i = 1;
        for(int j = length-1; j>=0; j--){
            if(string[j]!= 32){
                string[newLen - i] = string[j];
                i++;
            }else{
                string[newLen - i] = '0';
                i++;
                string[newLen - i] = '2';
                i++;
                string[newLen - i] = '%';
                i++;
            }
        }
        return newLen;
    }
}
