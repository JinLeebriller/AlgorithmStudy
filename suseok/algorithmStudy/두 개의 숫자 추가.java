
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode(l1.val);
        ListNode temp = answer;
 
        while(l1.next != null) {
            temp.next = new ListNode(l1.next.val);
            l1 = l1.next;
            temp = temp.next;
        }
        
        int p = 0;
        temp = answer;
        while(l2 != null || p == 1) {
            int sum = l2 != null ? temp.val + l2.val : temp.val;
            p = sum >= 10 ? 1 : 0;
            temp.val = sum % 10;
 
            if(p == 1) {
                if(temp.next != null) {
                    temp.next.val += p;
                } else {
                    temp.next = new ListNode(p);
                }
            }
            l2 = l2 != null ? l2.next : null;
            temp.next = temp.next == null ? (l2 != null ? new ListNode(0) : null) : temp.next;
            temp = temp.next;
        }
 
        return answer;
    }
}
