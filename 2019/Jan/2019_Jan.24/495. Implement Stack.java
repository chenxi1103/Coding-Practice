public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    ArrayList<Integer> list = new ArrayList<>();
    public void push(int x) {
        // write your code here
        list.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        list.remove(list.size() - 1);
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        return list.get(list.size() - 1);
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return list.size() == 0;
    }
}
