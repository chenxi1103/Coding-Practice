public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // write your code here
        if(lists == null || lists.size() == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(int i = 0; i<lists.size(); i++){
            if(lists.get(i) == null) continue;
            ListNode node = lists.get(i);
            while(node != null){
                pq.offer(node);
                node = node.next;
            }
        }
        if(pq.size() == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode head = pq.poll();
        dummy.next = head;
        while(pq.size() != 0){
            head.next = pq.poll();
            head = head.next;
        }
        return dummy.next;
    }
}
