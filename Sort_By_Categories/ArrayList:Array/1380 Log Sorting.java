public class Solution {
    /**
     * @param logs: the logs
     * @return: the log after sorting
     * 这道题的重点是： 学会写自己的Comparator,就Collections.sort(list, Comparator)这个Comparator是一个接口可以自定义去实现的，
     * 做题时想到了要自定义一个Comparator但是语言功底不扎实，不知道怎么写，要学会implement接口实现特定的功能（非常重要）
     * 还有一些string的方法要复习一下
     * 时间： 2018-Oct.24 
     */
    public String[] logSort(String[] logs) {
        // Write your code here
        class myCompare implements Comparator{
            public int compare(Object o1, Object o2){
                String str1 = (String) o1;
                String str2 = (String) o2;
                int index1 = str1.indexOf(" ");
                int index2 = str2.indexOf(" ");
                String head1 = str1.substring(0,index1);
                String head2 = str2.substring(0,index2);
                String body1 = str1.substring(index1);
                String body2 = str2.substring(index2);
                if(body1.equals(body2)){
                    return head1.compareTo(head2);
                }else{
                    return body1.compareTo(body2);
                }
            }
        }
        ArrayList<String> strList = new ArrayList<>();
        String[] result = new String[logs.length];
        int counter = logs.length-1;
        for(int i = logs.length-1; i>=0;i--){
            if(Character.isDigit(logs[i].split(" ",2)[1].charAt(0))){
                result[counter--] = logs[i];
            }else{
                strList.add(logs[i]);
            }
        }
        myCompare strCompare = new myCompare();
        Collections.sort(strList,strCompare);
        counter = 0;
        for(String str : strList){
            result[counter++] = str;
        }
        return result;
    }
}