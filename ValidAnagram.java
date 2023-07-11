//alpha 

/*  242. Valid Anagram
Easy
9.7K
307
Companies
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
 
Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 
Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
*/

import java.util.*;

//leetcode solution

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer>map=new HashMap<>();

        //check length are same or not  
        if( s.length()!=t.length() )
            return false;

        //put the 1st string characters to the map
        for( int i=0 ; i<s.length() ; i++ )
        {
            char ch=s.charAt(i);
            map.put( ch, map.getOrDefault( ch, 0 )+1 );
        }

        //check the 2nd string charachter matching or not to the map
        for( int i=0 ; i<t.length() ; i++ )
        {
            char ch=t.charAt(i);
            if( !map.containsKey(ch) )
                return false;

            if( map.get(ch)==1 )
                map.remove(ch);
            else
                map.put( ch, map.get(ch)-1 );
        }
        return true;
    }
}

//main class for drive the solution

class ValidAnagram
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int tc=Sc.nextInt();
        while(tc-->0)
        {
            String s=Sc.next();
            String t=Sc.next();

            Solution sl=new Solution();
            System.out.print(sl.isAnagram( s, t));
        }
    }
}