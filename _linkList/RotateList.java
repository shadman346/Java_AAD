package _linkList;

public class RotateList {


    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {
        ListNode one = new ListNode(0);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        one.next=two;
        two.next=three;
        one = rotateRight(one,4);
        ListNode ptr=one;
        while(ptr!=null){
            System.out.println(ptr.val);
            ptr=ptr.next;
        }
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        ListNode ahead=head,behind=head;
        while(ahead.next!=null){
            if(k<=0)
                behind=behind.next;

            ahead=ahead.next;
            k--;
            if(ahead.next==null && k>1) {
                ahead = head;
                k--;
            }
        }
        if(k==0 || head.next==null) return head; // means k%size==0 therefore no change
        ahead.next=head;
        head=behind.next;
        behind.next=null;

        return head;
    }
}
