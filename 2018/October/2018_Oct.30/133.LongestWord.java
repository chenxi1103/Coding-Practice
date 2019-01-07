public class Solution {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     * 可以，这个题是自己想出来的，不用在复习了2333，为了不循环两次，让时间复杂度变o(n)，
     * 很自然的想到了用queue，这个是一个进步，我能独立思考了！
     * 加油！
     * oct-30 1:30 am
     */
    public List<String> longestWords(String[] dictionary) {
        // write your code here
        List<String> list = new ArrayList<String>();
        if(dictionary == null || dictionary.length == 0) return list;
        int max_count = 0;
        Queue<String> queue = new LinkedList<>();
        for(String str: dictionary){
            if(str.length() == max_count){
                queue.offer(str);
            }
            if(str.length() > max_count){
                max_count = str.length();
                while(!queue.isEmpty()){
                    queue.poll();
                }
                queue.offer(str);
            }
        }
        while(!queue.isEmpty()){
            list.add(queue.poll());
        }
        return list;
    }
}
