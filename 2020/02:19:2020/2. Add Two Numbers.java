/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 /*
 * 啊时隔一百年我终于又开始刷题了，虽然两次就通过了但你看看这些的是什么代码啊喂！！！怎么会有这么冗余难看的代码啊喂！完全忘记怎么写代码了吧魂淡！
 * 下周一就要入职了你到底在想什么呢！！！哎，只能慢慢恢复了啊。。。
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = new ListNode(0);
        result.next = head;
        Boolean flag = false;
        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            int sum = a + b;
            if (flag) {
                sum += 1;
            }
            if (sum >= 10) {
                flag = true;
                sum -= 10;
            } else {
                flag = false;
            }
            head.next = new ListNode(sum);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode l3 = l1 == null ? l2 : l1;
        while (l3 != null) {
            int sum = l3.val;
            if (flag) {
                sum += 1;
            }
            if (sum >= 10) {
                flag = true;
                sum -= 10;
            } else {
                flag = false;
            }
            head.next = new ListNode(sum);
            head = head.next;
            l3 = l3.next;
        }
        
        if (flag) {
            head.next = new ListNode(1);
        }
        return result.next.next;
    }
}