//alpha 

/*  Given a linked list of 0s, 1s and 2s, sort it.

Join the most popular course on DSA. Master Skills & Become Employable by enrolling today! 
Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.

Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
Your Task:
The task is to complete the function segregate() which segregates the nodes in the linked list as asked in the problem statement and returns the head of the modified linked list. The printing is done automatically by the driver code.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 103
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

class SortALinkedListOf0sAnd1sAnd2s
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
		   
		      head = new Solution().segregate(head);
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

class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node curr=head;
        int val0=0,val1=0,val2=0;
        
        while( curr!=null )
        {
            if( curr.data==0 )
                val0++;
            else if( curr.data==1 )
                val1++;
            else
                val2++;
                
            curr=curr.next;
        }
        
        Node temp=new Node(-1);
        Node result=temp;
        
        for( int i=1 ; i<=val0 ; i++ )
        {
            result.next=new Node(0);
            result=result.next;
        }
         for( int i=1 ; i<=val1 ; i++ )
        {
            result.next=new Node(1);
            result=result.next;
        }
         for( int i=1 ; i<=val2 ; i++ )
        {
            result.next=new Node(2);
            result=result.next;
        }
        return temp.next;
    }
}


/*another method

static Node segregate(Node head)
    {
        // add your code here
       
        int temp = 0;
        for(Node curr = head;curr != null;curr = curr.next){
            for(Node currnext = curr.next;currnext!=null;currnext = currnext.next){
                if(curr.data > currnext.data){
                    temp = curr.data;
                    curr.data  = currnext.data;
                    currnext.data = temp;
                    
                }
            }
        }
        
        return head;
    }
    */