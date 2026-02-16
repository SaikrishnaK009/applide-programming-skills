/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummyHead = new ListNode(-1);
        var pq = new PriorityQueue<ListNode>((a, b) ->  a.val - b.val);

        
        for(int i = 0; i<lists.length; i++) {
            if (lists[i] != null) pq.add(lists[i]);
        }
        ListNode ptr = dummyHead;

        while(!pq.isEmpty()) {
            var nextNode = pq.poll();
            if (nextNode.next != null) {pq.add(nextNode.next);}
            ptr.next = nextNode;
            ptr = nextNode;
            ptr.next = null;
        }

        return dummyHead.next;
    }
}