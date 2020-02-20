public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        if(org.length == 0) return true;
        if(org.length == 1 && seqs.length == 1 && seqs[0][0] == org[0]) return true;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Integer,Integer> degrees = new HashMap<>();
        for(int i = 0; i<org.length; i++){
            map.put(org[i], new ArrayList<Integer>());
            degrees.put(org[i], 0);
        }
        int size = 0;
        for(int i = 0; i<seqs.length; i++){
            size += seqs[i].length;
            if(seqs[i].length >= 1 && (seqs[i][0] <= 0 || seqs[i][0] > org.length)) return false;
            for(int j = 1; j<seqs[i].length; j++){
                if(seqs[i][j] <= 0 || seqs[i][j] > org.length) return false;
                if(map.get(seqs[i][j-1]).add(seqs[i][j])){
                    if(!degrees.containsKey(seqs[i][j])) return false;
                    degrees.put(seqs[i][j], degrees.get(seqs[i][j]) + 1);
                }
            }
        }

        if(size < org.length) return false;
        Queue<Integer> queue = new LinkedList<>();
        for(int key : degrees.keySet()){
            if(degrees.get(key) == 0) queue.offer(key);
        }
        int count = 0;
        while(queue.size() == 1){
            int point = queue.poll();
            if(point != org[count]) return false;
            count++;
            ArrayList<Integer> neigbors = map.get(point);
            for(int i = 0; i<neigbors.size(); i++){
                int currPoint = neigbors.get(i);
                degrees.put(currPoint, degrees.get(currPoint) - 1);
                if(degrees.get(currPoint) == 0) queue.offer(currPoint);
            }
        }
        return count == org.length;
    }
}
