//alpha

/*   143. Reorder List
Medium
9K
299
Companies
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/

import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

 //solution for leetcode
class Solution {
    public void reorderList(ListNode head) {
        
        ListNode mid=getMid(head);
        ListNode curr=mid.next;
        mid.next=null;
        ListNode next;
        ListNode prev=null;
        while( curr!=null )
        {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode curr1=head;
        ListNode curr2=prev;
        ListNode currL,currR;
        while( curr1!=null && curr2!=null )
        {
            currL=curr1.next;
            curr1.next=curr2;
            currR=curr2.next;
            curr2.next=currL;
            curr1=currL;
            curr2=currR;
        }
    }
    public ListNode getMid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head.next;
        while( fast!=null && fast.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
//main class for drive the program
public class ReorderListLeetcode
{
    ListNode head; // head of lisl
    ListNode last; // last of linked list

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(ListNode node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner Sc=new Scanner(System.in);
        int t = Sc.nextInt();
        while (t > 0) {
            int n = Sc.nextInt();
            ReorderListLeetcode llist = new ReorderListLeetcode();
            int a1 = Sc.nextInt();
            ListNode head = new ListNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = Sc.nextInt();
                llist.addToTheLast(new ListNode(a));
            }

            new Solution().reorderList(llist.head);

            llist.printList();

            t--;
        }
    }
}