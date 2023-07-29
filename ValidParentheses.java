//alpha

/*      20. Valid Parentheses
Easy
20.7K
1.3K
Companies
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 
Example 1:

Input: s = "()"
Output: true

Example 2:

Input: s = "()[]{}"
Output: true

Example 3:

Input: s = "(]"
Output: false
 
Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/


import java.util.*;

//solution for leetcode
class Solution 
{
    public boolean isValid(String s) 
    {
        //create stack
        Stack<Character> st=new Stack<>();

        for( int i=0 ; i<s.length() ; i++ )
        {
            //opening braces push into the stack
            if( s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[' )
                st.push( s.charAt(i) );

            //check the same pair and pop when closing braces appear
            else if( !st.isEmpty() && ( (st.peek()=='(' && s.charAt(i)==')' ) ||
            (st.peek()=='{' && s.charAt(i)=='}' ) || (st.peek()=='[' && s.charAt(i)==']' ) ))
                st.pop();
                
            else 
                return false;    
        }
        if( !st.isEmpty() )
            return false;

        return true;
    }
}


//drive code

public class ValidParentheses
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int t=Sc.nextInt(); //testcase
        while( t-->0 )
        {
            //enter your string
            String s=Sc.next();
            Solution sl=new Solution();
            System.out.print(sl.isValid( s));
        }
    }
}