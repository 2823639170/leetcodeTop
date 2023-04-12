import java.util.List;

public class class01_k {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode next = head;
        ListNode pre = head;
        ListNode res = head;
        boolean isOver = true;
        for (int i = 0; i < k; i++) {
            if (next == null) {
               return head;
            }
            res = next;
            next = next.next;

        }
        while (isOver && cur != null) {
            ListNode p = reverseK(cur, k);
            if (pre != null) {
                pre.next = p;
            }
            pre = cur;
            cur = next;
            for (int i = 0; i < k; i++) {
                if (next == null) {
                    isOver = false;
                    break;
                }
                next = next.next;
            }
            if(isOver == false){
                pre.next = cur;
            }
        }
        return res;
    }

    public ListNode reverseK(ListNode head, int k) {
        ListNode cur = head;
        ListNode next = head.next;
        ListNode pre = null;
        for (int i = 0; i < k - 1; i++) {
            ListNode temp = cur;
            cur.next = pre;
            cur = next;
            next = next.next;
            pre = temp;
        }
        cur.next = pre;
        return cur;
    }
}
