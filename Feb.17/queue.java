class MyQueue {
    private ArrayList<Integer> elements;  // 用ArrayList存储队列内部元素
    private int pointer;  // 表示队头的位置

    // 队列初始化
    public MyQueue() {
        this.elements = new ArrayList<>();
        pointer = 0;
    }

    // 获取队列中元素个数
    public int size() {
        return this.elements.size() - pointer;
    }

    // 判断队列是否为空
    public boolean empty() {
        return this.size() == 0;
    }

    // 在队尾添加一个元素
    public void add(Integer e) {
        this.elements.add(e);
    }

    // 弹出队首元素，如果为空则返回null
    public Integer poll() {
        if (this.empty()) {
            return null;
        }
        return this.elements.get(pointer++);
    }
}
