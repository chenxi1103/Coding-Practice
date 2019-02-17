//注意这个minstack的设计，如何实线stack是很重要的，会考
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if(min.size() == 0) {
            min.push(x);
        } else {
            min.push(Math.min(x, min.peek()));
        }
        stack.push(x);
    }

    public void pop() {
        min.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
