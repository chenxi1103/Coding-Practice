public class Solution {
    /*
    * @param k: An integer
    */
    PriorityQueue<Integer> pq;
    int size;
    public Solution(int k) {
        // do intialization if necessary
        pq = new PriorityQueue<>();
        size = k;
    }
    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        pq.offer(num);
        while(pq.size() > size){
            pq.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> list = new ArrayList<>(pq);
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        return list;
    }
}
////////////////////////////////////////或者////////////////////////////////////
public class Solution {
    /*
    * @param k: An integer
    */
    PriorityQueue<Integer> pq;
    int size;
    public Solution(int k) {
        // do intialization if necessary
        pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        size = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        pq.offer(num);
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        // write your code here
        List<Integer> list = new ArrayList<>();
        int count = size;
        if(pq.size() < size) count = pq.size();
        for(int i = 0; i < count; i++){
            list.add(pq.poll());
        }
        while(!pq.isEmpty()){
            pq.poll();
        }
        for(int i = 0; i < count; i++){
            pq.offer(list.get(i));
        }
        return list;
    }
}
