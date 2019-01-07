public class Solution {
    /**
     * @param ages: The ages
     * @return: The answer
     * Facebook经典题型，注意它给的是不发好友请求的情况，那么发好友请求的情况就要反过来，“<”变成“>=”之类的，不要写错！
     */
    public int friendRequest(int[] ages) {
        int result = 0;
        for(int i = 0;i < ages.length; i++){
            for(int j = 0; j<ages.length; j++){
                if(i == j) continue;
                if(ages[i]>=ages[j] && ages[i]<(ages[j]-7)*2){
                    if(ages[i]<=100){
                        result++;
                    }
                    if(ages[i]>100 && ages[j] >=100){
                        result++;
                    }
                }
            }
        }
        return result;
    }
}