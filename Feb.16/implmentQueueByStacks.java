class MyQueue {

    /** Initialize your data structure here. */
    Stack<Integer> stack;
    boolean flag = false;
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty()) {
            temp.add(stack.pop());
        }
        temp.add(x);
        while(!temp.isEmpty()) {
            stack.add(temp.pop());
        }
        return;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
