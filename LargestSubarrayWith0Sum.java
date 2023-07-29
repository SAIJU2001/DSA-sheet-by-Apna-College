//alpha


/*  Largest subarray with 0 sum
EasyAccuracy: 41.84%Submissions: 222K+Points: 2
Share your Interview, Campus or Work Experience to win GFG Swag Kits and much more!

Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

Example 1:

Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.
Your Task:
You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 <= N <= 105
-1000 <= A[i] <= 1000, for each valid i
*/


//{ Driver Code Starts
import java.util.*;

class LargestSubarrayWith0Sum
{  
    // Returns length of the maximum length subarray with 0 sum
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG
{
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer>map=new HashMap<>();
        int length=0,sum=0;
        map.put(0,-1);  //tracker
        for( int i=0 ; i<n ; i++ )
        {
            sum+=arr[i];
            if( map.containsKey( sum) )
            {
                //if key is present find the max length
                length=Math.max( length, i-map.get( sum) );
            }
            else
            {
                //key and value add to tha map 
                map.put( sum, i);
            }
        }
        return length;
    }
}