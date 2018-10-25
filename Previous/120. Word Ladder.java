public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        //Special cases:
        if (dict == null) return 0;
        if (start.equals(end)) return 1;
        
        int result = 0;
        //Actually start and end are not included in dict, so we need to add them
        dict.add(end);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        
        //BFS
        while(!queue.isEmpty()){
            result++;
            //To find the shortest path, need to loop the queue.size.
            int size = queue.size();
            for(int i = 0; i<size; ++i){
                String currStr = queue.poll();
                if(currStr.equals(end)) return result;
                for(String neighbor : findNeighbor(currStr,dict)){
                    if(neighbor.equals(end)) return result+1;
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }
    
    //define a function to get the neighbors and remove them from dict
    private ArrayList<String> findNeighbor(String word, Set<String> dict){
        ArrayList<String> result = new ArrayList<String>();
        for(String str:dict){
            int counter = 0;
            for(int i = 0; i<word.length();i++){
                if(str.charAt(i) == word.charAt(i)){
                    continue;
                }
                counter++;
            }
            if(counter == 1){
                result.add(str);
            }
        }
        dict.removeAll(result);
        return result;
    }
}
