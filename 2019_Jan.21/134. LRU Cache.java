public class LRUCache {
    /*
    * @param capacity: An integer
    */
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    int size;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    public LRUCache(int capacity) {
        // do intialization if necessary
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if(!map.containsKey(key)) return -1;
        Node current = map.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        move2tail(current);
        return current.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
         if (get(key) != -1){
            map.get(key).value = value;
            return;
        }
        if(map.size() == size){
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        Node node = new Node(key, value);
        move2tail(node);
        map.put(key, node);
    }
    private void move2tail(Node current){
        tail.prev.next = current;
        current.prev = tail.prev;
        current.next = tail;
        tail.prev = current;
    }
}
