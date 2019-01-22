//算是queue这个数据结构的活用？
public class MovingAverage {
    /*
    * @param size: An integer
    */

    int windowsize;
    double prevSum = 0;
    Queue<Integer> queue;
    public MovingAverage(int size) {
        // do intialization if necessary
        queue = new LinkedList<>();
        windowsize = size;
    }

    /*
     * @param val: An integer
     * @return:
     */
    public double next(int val) {
        // write your code here
       if(queue.size() == windowsize){
           prevSum -= queue.poll();
       }
       prevSum += val;
       queue.offer(val);
       return (double)prevSum / queue.size();
    }
}
