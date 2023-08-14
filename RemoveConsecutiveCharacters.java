//gfg 

/*      Remove Consecutive Characters
BasicAccuracy: 53.35%Submissions: 66K+Points: 1
Join the most popular course on DSA. Master Skills & Become Employable by enrolling today! 
Given a string S. For each index i(1<=i<=N-1), erase it if s[i] is equal to s[i-1] in the string.

Example 1:

Input:
S = aabb
Output:  ab 
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
Similiar explanation for b at
4th position.

Example 2:

Input:
S = aabaa
Output:  aba
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
'a' at fifth position is appearing
2nd time consecutively.
 
Your Task:
You dont need to read input or print anything. Complete the function removeConsecutiveCharacter() which accepts a string as input parameter and returns modified string.
 
Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).
 
Constraints:
1<=|S|<=105
All characters are lowercase alphabets.
*/ 

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class RemoveConsecutiveCharacters 
{
    public static void main(String args[]) throws IOException 
    {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) 
        {      
            String S = read.readLine().trim();
            
            Solution ob = new Solution();
            String ans = ob.removeConsecutiveCharacter(S);
            
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public String removeConsecutiveCharacter(String S)
    {    
        StringBuilder result=new StringBuilder();
        result.append( S.charAt(0) );   //first character always input to the result string
        
        for( int i=1 ; i<S.length() ; i++ )
        {
            //check two character are same or not if not same then added to the result
            if( S.charAt(i-1)!=S.charAt(i) )
            {
                result.append( S.charAt(i) );
            }
        }
        return result.toString();
    }
}