//alpha


/*      k largest elements
MediumAccuracy: 53.56%Submissions: 139K+Points: 4
Register for Mega Job-A-Thon For Experienced Professionals on 21st July | Apply to 15+ Companies

Given an array Arr of N positive integers and an integer K, find K largest elements from the array.  The output elements should be printed in decreasing order.

Example 1:

Input:
N = 5, K = 2
Arr[] = {12, 5, 787, 1, 23}
Output: 787 23
Explanation: 1st largest element in the
array is 787 and second largest is 23.
Example 2:

Input:
N = 7, K = 3
Arr[] = {1, 23, 12, 9, 30, 2, 50}
Output: 50 30 23
Explanation: 3 Largest element in the
array are 50, 30 and 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function kLargest() which takes the array of integers arr, n and k as parameters and returns an array of integers denoting the answer. The array should be in decreasing order.

Expected Time Complexity: O(N + KlogK)
Expected Auxiliary Space: O(K+(N-K)*logK)

Constraints:
1 ≤ K ≤ N ≤ 105
1 ≤ Arr[i] ≤ 106
*/ 


//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class kLargestElements 
{
    public static void main(String[] args) throws Exception 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) 
        {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
            {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) 
            {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution 
{
    int[] kLargest(int[] arr, int n, int k) 
    {
        // Approach 1 ==> using sorting technique
            /*  
                int res[] = new int[k];
                Arrays.sort(arr);
            
                for(int j =0, i=n-1; j<k;j++,i--)
                {
                        res[j]=arr[i];
                }
                return res;
            */

        // Approach 2 ==> Priority Queue

            //Priority Queue use as Decending order
            PriorityQueue<Integer>pq=new PriorityQueue<>(Comparator.reverseOrder());
            int result[]=new int[k];

            for( int i=0 ; i<n ; i++ )
            {
                //add the array element to the priority queue
                pq.add(arr[i]);
            }
            for( int i=0 ; i<k ; i++ )
            {
                //remove the value from priority queue upto k-1 place and add in the result
                result[i]=pq.remove();
            }
            return result;
    }
}
