    /*
     * 注意点： 双端queue用双端链表(linkedlist)实现, 因为内置queue就是用linkedlist实现的（queue q = new LinkedList())
     * 但是因为普通内置linkedlist不是双端链表，所以要自己写这个双端链表（自己写node class）
     * 日期：2018-10-24
     */
public class Dequeue {
    class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int val){
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    public ListNode headPointer;
    public ListNode tailPointer;
    public int length;
    public Dequeue() {
        // do intialization if necessary
        headPointer = new ListNode(0);
        tailPointer = new ListNode(0);
        length = 0;
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_front(int item) {
        // write your code here
        ListNode head = new ListNode(item);
        if(length == 0){
            headPointer.next = head;
            head.prev = headPointer;
            head.next = tailPointer;
            tailPointer.prev = head;
        }else{
            headPointer.next.prev = head;
            head.next = headPointer.next;
            headPointer.next = head;
            head.prev = headPointer;
        }
        length++;
    }

    /*
     * @param item: An integer
     * @return: nothing
     */
    public void push_back(int item) {
        // write your code here
        ListNode tail = new ListNode(item);
        if(length == 0){
            headPointer.next = tail;
            tail.prev = headPointer;
            tail.next = tailPointer;
            tailPointer.prev = tail;
        }else{
            tailPointer.prev.next = tail;
            tail.prev = tailPointer.prev;
            tail.next = tailPointer;
            tailPointer.prev = tail;
        }
        length++;
    }

    /*
     * @return: An integer
     */
    public int pop_front() {
        // write your code here
        if(length == 0) return -1;
        int result = headPointer.next.val;
        ListNode newHead = headPointer.next.next;
        headPointer.next = newHead;
        newHead.prev = headPointer;
        length--;
        return result;
    }

    /*
     * @return: An integer
     */
    public int pop_back() {
        // write your code here
        if(length == 0) return -1;
        int result = tailPointer.prev.val;
        ListNode newTail = tailPointer.prev.prev;
        newTail.next = tailPointer;
        tailPointer.prev = newTail;
        length--;
        return result;
    }
}