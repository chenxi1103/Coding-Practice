public class Solution {
    /**
     * @param org: a permutation of the integers from 1 to n
     * @param seqs: a list of sequences
     * @return: true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // write your code here
        if(seqs == null || seqs.length == 0 || org == null) return false;
        if(org.length == 0) return true;
        if(org.length == 1 && seqs.length == 1
                && seqs[0].length >= 1 && seqs[0][0] == org[0]) return true;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        for(int i = 0; i < org.length; i++) {
            map.put(org[i], new ArrayList<Integer>());
            degree.put(org[i], 0);
        }
        int size = 0;
        for(int i = 0; i < seqs.length; i++) {
            size += seqs[i].length;
            if(seqs[i].length == 0) continue;
            if(seqs[i].length == 1 && (seqs[i][0] <= 0 || seqs[i][0] > org.length)) return false;
            for(int j = 1; j < seqs[i].length; j++) {
                int before = seqs[i][j-1];
                int after = seqs[i][j];
                if(!degree.containsKey(before) || !degree.containsKey(after)) return false;
                degree.put(after, degree.get(after) + 1);
                ArrayList<Integer> list = map.get(before);
                list.add(after);
                map.put(before, list);
            }
        }
        if(size < org.length) return false;
        Queue<Integer> queue = new LinkedList<>();
        for(int key : degree.keySet()) {
            if(degree.get(key) == 0) queue.offer(key);
        }
        ArrayList<Integer> record = new ArrayList<>();
        while(!queue.isEmpty()) {
            if(queue.size()!= 1) return false;
            int curr = queue.poll();
            record.add(curr);
            ArrayList<Integer> list = map.get(curr);
            for(int i = 0; i < list.size(); i++) {
                degree.put(list.get(i), degree.get(list.get(i)) - 1);
                if(degree.get(list.get(i)) == 0) {
                    queue.offer(list.get(i));
                }
            }
        }
        if(record.size() != org.length) return false;
        for(int i = 0; i < record.size(); i++) {
            if(record.get(i) != org[i]) return false;
        }
        return true;
    }
}
