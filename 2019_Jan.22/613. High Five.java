/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> map = new HashMap<>();
        PriorityQueue<Record> pq = new PriorityQueue<Record>(results.length, new Comparator<Record>(){
            @Override
            public int compare(Record a, Record b){
                int diff = a.id - b.id;
                if(diff == 0){
                    diff = b.score - a.score;
                }
                return diff;
            }
        });
        for(int i = 0; i < results.length; i++){
            pq.offer(results[i]);
        }
        int count = 0;
        double sum = 0;
        while(!pq.isEmpty()){
            Record currRec = pq.poll();
            if(!map.containsKey(currRec.id)){
                count = 1;
                sum = (double)currRec.score;
                map.put(currRec.id, sum);
            }else{
                if(count < 5){
                    sum += currRec.score;
                    map.put(currRec.id, sum);
                    count++;
                    if(count == 5) map.put(currRec.id, (double)sum/5);
                }
            }
        }
        return map;
    }
}
