public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        Set<String> set = new HashSet<String>();
        
        int min = s.length();
        queue.offer(s);
        set.add(s);
        
        //To understand BFS, we store all the possible directions in the queue
        //The best solution would come first
        while(!queue.isEmpty()){
            String currStr = queue.poll();
            for(String str: dict){
                int index = currStr.indexOf(str);
                while(index!=-1){
                    String newStr = currStr.substring(0,index)+currStr.substring(index+str.length(),currStr.length());
                    if(!set.contains(newStr)){
                        if(newStr.length()<min){
                            min = newStr.length();
                        }
                        queue.offer(newStr);
                        set.add(newStr);
                    }
                    //There may be more than one substring in the string
                    //So we start at the next char after the index to find the next substring
                    index = currStr.indexOf(str,index+1);
                }
            }
        }
        return min;
    }
}
