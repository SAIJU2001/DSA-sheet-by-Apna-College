//alpha

/*  Merge Sort for Linked List
MediumAccuracy: 74.76%Submissions: 56K+Points: 4
Sharpen up your programming skills, participate in coding contests & explore high-paying jobs

Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.

Example 1:

Input:
N = 5
value[]  = {3,5,2,4,1}
Output: 1 2 3 4 5
Explanation: After sorting the given
linked list, the resultant matrix
will be 1->2->3->4->5.
Example 2:

Input:
N = 3
value[]  = {9,15,0}
Output: 0 9 15
Explanation: After sorting the given
linked list , resultant will be
0->9->15.
Your Task:
For C++ and Python: The task is to complete the function mergeSort() which sort the linked list using merge sort function.
For Java: The task is to complete the function mergeSort() and return the node which can be used to print the sorted linked list.

Expected Time Complexity: O(N*Log(N))
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
*/


//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class MergeSortForLinkedList
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
//solution
class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null )
            return head;
        // add your code here
        Node mid=getMid(head);
        Node rightHead=mid.next;
        mid.next=null;
        
        Node left=mergeSort( head );
        Node right=mergeSort( rightHead );
        return conquer( left,right );
    }
    static Node getMid(Node head)
    {
        Node fast=head.next,slow=head;
        while( fast!=null && fast.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    static Node conquer( Node left,Node right )
    {
        Node result=new Node(-1);
        Node temp=result;
        while( left!=null && right!=null )
        {
            if( left.data<=right.data )
            {
                temp.next=left;
                left=left.next;
                temp=temp.next;
            }
            else
            {
                temp.next=right;
                right=right.next;
                temp=temp.next;
            }
        }
        while( left!=null )
        {
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }
        while( right!=null )
        {
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }
        return result.next;
    }
}



