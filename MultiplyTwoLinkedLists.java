//alpha 

/*      Multiply two linked lists
EasyAccuracy: 46.33%Submissions: 41K+Points: 2
Join the most popular course on DSA. Master Skills & Become Employable by enrolling today! 
Given elements as nodes of the two linked lists. The task is to multiply these two linked lists, say L1 and L2. 

Note: The output could be large take modulo 109+7.

Example:

Input:
2
2
3 2
1
2
3
1 0 0
2
1 0 
Output:
64
1000

Explanation:
Testcase 1: 32*2 = 64.
Testcase 2: 100*10 = 1000.
Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow, the first line of each test case contains an integer N denoting the size of the first linked list (L1). In the next line are the space-separated values of the first linked list. The third line of each test case contains an integer M denoting the size of the second linked list (L2). In the fourth line is space-separated values of the second linked list.

Output:
For each test case output will be an integer denoting the product of the two linked lists.

Your Task:
The task is to complete the function multiplyTwoLists() which should multiply the given two linked lists and return the result.

Constraints:
1 <= T <= 100
1 <= N, M <= 100
*/


//{ Driver Code Starts
import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        next=null;
    }
}

class MultiplyTwoLinkedLists
{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Node head=null;
			Node phead=null;
			int n=sc.nextInt();
			while(n-->0){
				int n1=sc.nextInt();
				if(head==null)
				head=new Node(n1);
			else{
				addHead(head,n1);
			}
			}
			int m=sc.nextInt();
			while(m-->0){
				int n1=sc.nextInt();
				if(phead==null)
				phead=new Node(n1);
			else{
				addPhead(phead,n1);
			}
			}
		GfG g=new GfG();

System.out.println(g.multiplyTwoLists(head,phead));
		}
	}
    public static void addHead(Node node,int a) {
          if (node == null)
            return;
		if(node.next==null)
			node.next=new Node(a);
		else
			addHead(node.next,a);
	}
	public static void addPhead(Node node,int a){
		 if (node == null)
            return;
		if(node.next==null)
		node.next=new Node(a);
	else
		addPhead(node.next,a);
	}
	}
	
// } Driver Code Ends


class GfG{
  /*You are required to complete this method */
   public long multiplyTwoLists(Node l1,Node l2){
          //add code here.
          long mod=1000000007;
          long val1=0,val2=0;
          Node curr1=l1;
          Node curr2=l2;
          
          while( curr1!=null )
          {
              val1=(val1*10+curr1.data)%mod;
              curr1=curr1.next;
          }
          
          while( curr2!=null )
          {
              val2=(val2*10+curr2.data)%mod;
              curr2=curr2.next;
          }
          return (val1*val2)%mod;          
   }
}