/*          Max Min
Given an array A of size N of integers. Your task is to find the sum of minimum and maximum element in the array.

Example 1:
Input:
N = 5
A[] = {-2, 1, -4, 5, 3}                                                 
Output: 1
Explanation: min = -4, max =  5. Sum = -4 + 5 = 1
 
Example 2:
Input:
N = 4
A[]  = {1, 3, 4, 1}
Output: 5
Explanation: min = 1, max = 4. Sum = 1 + 4 = 5
 
Your Task:  
You don't need to read input or print anything. Your task is to complete the function findSum() which takes the array A[] and its size N as inputs and returns the summation of minimum and maximum element of the array.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 <= N <= 105
-109 <= Ai <= 109               */

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


class MaxMin 
{
	public static void main (String[] args) 
    {    
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++)
                a[i] = sc.nextInt();
            
            Solution ob = new Solution();
            System.out.println(ob.findSum(a,n));
        }   
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        //code here
        Arrays.sort(A);
        return A[0]+A[N-1];
    }
}
