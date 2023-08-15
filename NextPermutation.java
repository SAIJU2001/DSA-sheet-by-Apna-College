//alpha

/*      Next Permutation
MediumAccuracy: 40.66%Submissions: 115K+Points: 4
Done with this problem? Now use these skills to apply for a job in Job-A-Thon 21!

Implement the next permutation, which rearranges the list of numbers into Lexicographically next greater permutation of list of numbers. If such arrangement is not possible, it must be rearranged to the lowest possible order i.e. sorted in an ascending order. You are given an list of numbers arr[ ] of size N.

Example 1:

Input: N = 6
arr = {1, 2, 3, 6, 5, 4}
Output: {1, 2, 4, 3, 5, 6}
Explaination: The next permutation of the 
given array is {1, 2, 4, 3, 5, 6}.

Example 2:

Input: N = 3
arr = {3, 2, 1}
Output: {1, 2, 3}
Explaination: As arr[] is the last 
permutation. So, the next permutation 
is the lowest one.

Your Task:
You do not need to read input or print anything. Your task is to complete the function nextPermutation() which takes N and arr[ ] as input parameters and returns a list of numbers containing the next permutation.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 10000
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class NextPermutation
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution
{
    static List<Integer> nextPermutation(int N, int arr[])
    {
        // code here
         ArrayList<Integer>list=new ArrayList<>();
        int index=-1;   //indiacte breaking point
        for( int i=N-2 ; i>=0 ; i-- )
        {
            //find breaking point
            //where the current elemnt is less compare to the previous that is the breaking point
            if( arr[i]<arr[i+1] )
            {
                index=i;
                break;
            }
        }
        if( index==-1 )
        {
            //if no breaking point present it means it is the last permutation
            //just reverse the array
            reverse( arr, 0, N-1);
            copy( list, arr);
            return list;
        }
        for( int i=N-1 ; i>index ; i-- )
        {
            //traverse from the end and check which is lowest greter element compare to breaking point 
            if( arr[i]>arr[index] )
            {
                //if find then swap that element with breaking point
                int temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
                break;
            }
        }
        //then reverse the array after breaking point
        reverse( arr, index+1, N-1);
        copy( list, arr);
        return list;
    }
    
    static void copy( ArrayList<Integer>list, int arr[] )
    {
        for( int i=0 ; i<arr.length ; i++ )
        {
            list.add( arr[i]);
        }
    }
    
    static void reverse( int arr[], int start, int end )
    {
        while( start<end )
        {
            int temp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=temp;
        }
    }
}