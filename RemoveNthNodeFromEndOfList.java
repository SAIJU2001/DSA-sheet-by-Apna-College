//alpha

/*  19. Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 
Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
*/ 


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

 import java.util.*;


class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currNode=head;
        int count=0;
        while( currNode!=null )
        {
            count++;
            currNode=currNode.next;
        }

        if( count==n )
            return head.next;

        currNode=head;
        for(int i=0 ; i<count-n-1 ; i++ )
        {
            currNode=currNode.next;
        }
        currNode.next=currNode.next.next;
        return head;
    }
}

//for drive thw solution

class ListNode
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) 
    { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) 
    { 
        this.val = val; this.next = next; 
    }
}

class RemoveNthNodeFromEndOfList
{
    ListNode head;  
    ListNode tail;
	public void addToTheLast(ListNode node) 
	{
	  if (head == null) 
	  {
	    head = node;
	    tail = node;
	  }
	  else
      {
	      tail.next = node;
	      tail = node;
	  }
	}
      void printList()
    {
        ListNode temp = head;
        while (temp != null)
        {
           System.out.print(temp.val+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
	/* Drier program to test above functions */
	public static void main(String args[])
    {
        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		  
		 while(t>0)
         {
			int n = sc.nextInt();
			RemoveNthNodeFromEndOfList llist = new RemoveNthNodeFromEndOfList();
			int a1=sc.nextInt();
			ListNode head= new ListNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new ListNode(a));
			}
            int pos=sc.nextInt();
		//llist.printList();	
        Solution g = new Solution();
		llist.head = g.removeNthFromEnd(head, pos);
		llist.printList();
		
        t--;		
        }
    }
}
