import java.util.ArrayList;
import java.util.List;

public class list_add_two_numbers {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));
        ListNode l2 = new ListNode(2, new ListNode(9, new ListNode(4)));
        ListNode p = new Solution().addTwoNumbers(l1, l2);
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ArrayList<ListNode> list1 = new ArrayList<>();
            ArrayList<ListNode> list2 = new ArrayList<>();
            ListNode p = l1;
            while (p != null) {
                list1.add(p);
                p = p.next;
            }
            p = l2;
            while (p != null) {
                list2.add(p);
                p = p.next;
            }
            ArrayList<ListNode> maxLength = list1.size() >= list2.size() ? list1 : list2;
            int c = 0;
            ListNode target = null;
            for (int i = 0, j = 0; maxLength == list1 ? i < list1.size() : j < list2.size(); i++, j++) {
                int sum = (i < list1.size() ? list1.get(i).val : 0) + (j < list2.size() ? list2.get(j).val : 0) + c;
                c = sum / 10;
                target = maxLength == list1 ? list1.get(i) : list2.get(j);
                target.val = sum % 10;
            }
            ListNode ret = maxLength == list1 ? l1 : l2;
            if (c != 0) {
                target.next = new ListNode(1);
            }
            return ret;
        }
    }
}
