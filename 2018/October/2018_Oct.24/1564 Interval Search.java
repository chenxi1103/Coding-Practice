public class Solution {
    /**
     * @param intervalList: 
     * @param number: 
     * @return: return True or False
     * 备注：谷歌面试题，简单级
     * 日期：2018-10-24
     */
    public String isInterval(List<List<Integer>> intervalList, int number) {
        // Write your code here
        for(int i = 0; i<intervalList.size(); i++){
            if(number>intervalList.get(i).get(1)){
                continue;
            }else{
                if(number>intervalList.get(i).get(0)){
                    return "True";
                }
            }
        }
        return "False";
    }
}