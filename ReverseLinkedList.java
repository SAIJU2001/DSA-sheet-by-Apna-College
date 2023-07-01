/*      206. Reverse Linked List.
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:                                      

Input: head = [1,2]
Output: [2,1]

Example 3:

Input: head = []
Output: []
 
Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000       */

//the solution for leetcode
/*  class Solution {
    public ListNode reverseList(ListNode head) {
        
        if( head == null || head.next == null )
        return head;
        
        ListNode newNode = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        
        return newNode;
        
    }
}   */

import java.util.Scanner;

public class ReverseLinkedList
{
    static Node head;

    class Node
    {
        int data;
        Node next;

        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    } 

    // add last
    public void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head==null)
        {
            head=newNode;
            return;
        }

        Node currNode=head;
        while( currNode.next != null )
        {
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    // print
    public void printList()
    {
        if(head==null)
        {
            System.out.println("The linked list is empty.");
        }
        Node currNode=head;
        while( currNode != null )
        {
            System.out.print(currNode.data+" => ");
            currNode=currNode.next;
        }
        System.out.println("null"); 
    }

    // delete first
    public void removeFirst()
    {
        if(head==null)
        {
            System.out.println("The linked list is empty.");
        }
        head=head.next;
    }

    //reverse the linked list
    public Node reverseList(Node head) 
    {    
        if( head == null || head.next == null )
        return head;
        
        Node newNode = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        
        return newNode;
        
    } 
    public static void main(String args[])
    {
        ReverseLinkedList list = new ReverseLinkedList();
        Scanner Sc = new Scanner(System.in);
        int val;
        do
        {
            System.out.print("For Exit press 0.\nAdd to the linked list press 1.\nprint the linked list press 2.\nReverse the linked list press 3.\nRemove from the linked list press 4.\n\npress here : ");
            
            val = Sc.nextInt();

            switch(val)
            {
                case 0 :
                    System.out.println("Program Terminated !!");
                    break;
                case 1 :
                    System.out.print("Enter the value : ");
                    int data1 = Sc.nextInt();
                    list.addLast(data1);
                    System.out.println("The value is sucessfully added to the linked list.\n");
                    break;
                case 2 :
                    list.printList();
                    break;
                case 3 :
                    head = list.reverseList(head);
                    break;
                case 4 :
                    list.removeFirst();
                    break;
                default : 
                    System.out.println("Invalid number.");
                    break;
            }
        }while(val!=0);
    }
}
