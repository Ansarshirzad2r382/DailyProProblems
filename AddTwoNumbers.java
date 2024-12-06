public class AddTwoNumbers {

    /*
     * Aufgabestellung:
     * You are given two non-empty linked lists representing two non-negative
     * integers. The digits are stored in reverse order, and each of their nodes
     * contains a single digit. Add the two numbers and return the sum as a linked
     * list.
     * You may assume the two numbers do not contain any leading zero, except the
     * number 0 itself.
     * 
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     * Example 2:
     * 
     * Input: l1 = [0], l2 = [0]
     * Output: [0]
     * Example 3:
     * 
     * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * Output: [8,9,9,9,0,0,0,1]
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;

        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // wenn l1 nicht leer ist
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = (sum / 10); // 6+4 = 10 -> 10 / 10 = 1 -> 1 im übertrag speichern

            current.next = new ListNode(sum % 10); // 6 + 4 = 10 -> 10 % 10 = 0 -> also, dann 0 in diese Knote
                                                   // speichern.
            current = current.next;
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(2); // 243 564
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        // liste verketten
        a1.next = a2;
        a2.next = a3;
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);
        // liste verketten
        b1.next = b2;
        b2.next = b3;

        AddTwoNumbers a = new AddTwoNumbers();

        ListNode res = a.addTwoNumbers(a1, b1);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}