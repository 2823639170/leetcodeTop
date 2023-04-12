//https://leetcode.cn/problems/add-two-numbers/?favorite=2cktkvj

/**
 * 不能转化为long或者int因为会溢出
 * 可以转化为数组，代码实现会简单很多
 */
public class Class02_AddTwoNum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null;
        ListNode head = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int num2 = 0;

        int flag;
        while (cur1 == null || cur2 == null) {

            int num = cur1.val + cur2.val + num2;
            int num1 = num % 10;
            num2 = num / 10;
            ListNode node = new ListNode();
            node.val = num1;
            if (res == null) {
                head = node;
                res = node;
            } else {
                res.next = node;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (cur1 == null && cur2 == null) {
                if (num2 == 0) {
                    return res;
                } else {
                    ListNode node1 = new ListNode();
                    node.val = num1;
                    res.next = node1;
                    return res;

                }
            }
            if (cur1 == null) {
                if (num2 == 0) {
                    while (cur2 != null) {
                        res.next = cur2.next;
                    }
                } else {
                    ListNode node1 = new ListNode();
                    node.val = num1;
                    res.next = node1;
                    return res;

                }
            }
            if (cur1 == null && cur2 == null) {
                if (num2 == 0) {
                    return res;
                } else {
                    ListNode node1 = new ListNode();
                    node.val = num1;
                    res.next = node1;
                    return res;

                }
            }
        }


        return res;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null;
        ListNode head = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int num2 = 0;

        int flag;
        while (cur1 != null || cur2 != null) {
            if (cur1.next == null && cur2.next != null) {
                cur1.next = new ListNode(0);
            }
            if (cur2.next == null && cur1.next != null) {
                cur2.next = new ListNode(0);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        cur1 = l1;
        cur2 = l2;
        while (cur1 != null) {
            int num = cur1.val + cur2.val + num2;
            int num1 = num % 10;
            num2 = num / 10;
            ListNode node = new ListNode();
            node.val = num1;
            System.out.println(node.val);
            if (res == null) {
                head = node;
                res = node;
            } else {
                res.next = node;
                res = node;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        if (num2 == 1) {
            res.next = new ListNode(1);
        }
        return head;
    }

    public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null;
        ListNode head = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int num2 = 0;
        while (cur1 != null || cur2 != null) {
            int num = cur1.val + cur2.val + num2;
            int num1 = num % 10;
            num2 = num / 10;
            ListNode node = new ListNode();
            node.val = num1;
            System.out.println(node.val);
            if (res == null) {
                head = node;
                res = node;
            } else {
                res.next = node;
                res = node;
            }
            if (cur1.next == null && cur2.next != null) {
                cur1.next = new ListNode(0);
            }
            if (cur2.next == null && cur1.next != null) {
                cur2.next = new ListNode(0);
            }
            cur1 = cur1.next;
            cur2 = cur2.next;

        }
        if (num2 == 1) {
            res.next = new ListNode(1);
        }
        return head;
    }


}
