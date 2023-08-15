//alpha

/*          Print all the duplicate characters in a string
Read
Discuss(80+)
Courses
Practice
Video

Given a string S, the task is to print all the duplicate characters with their occurrences in the given string.

Example:
Input: S = “geeksforgeeks”
Output:
e, count = 4
g, count = 2
k, count = 2
s, count = 2


Explanation: e,g,k,and s are characters which are occured in string in more than one times.

Find the duplicate characters in a string using Hashing.
Store the characters count of a string in an unordered map which allows operations in constant time.
Then, print the characters which have a frequency greater than 1.
Steps to implement the above approach:

Declare a unordered map of the char-int pair.
Traverse the string using a loop and increase the count of the present char in the map.
Iterate through the map and print a character that has a value greater than one in map.
Below is the implementation of the above approach:

/*package whatever //do not write package name here */
import java.io.*;
import java.util.*;

class PrintAllDuplicateCharactersInString
{
    //approach 1
    
        // Java program to count all duplicates
        // from string using maps
        /*static void printDups(String str)
        {
            Map<Character, Integer> count = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
            if(count.containsKey(str.charAt(i)))
                count.put(str.charAt(i) , count.get(str.charAt(i))+1);
            else count.put(str.charAt(i),1);
            //increase the count of characters by 1
            }

            for (Map.Entry<Character,Integer> mapElement : count.entrySet()) { //iterating through the unordered map
            if (mapElement.getValue() > 1) //if the count of characters is greater than 1 then duplicate found
                System.out.println(mapElement.getKey() + ", count = " + mapElement.getValue());
            }
        }*/

    //approach 2
        public static void printDups(String str)
        {
            int len = str.length();

            // Sorting the string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            // Loop through the sorted string to find duplicates
            for (int i = 0; i < len; i++) {
                int count = 1;

                // Counting the occurrences of each character
                while (i < len - 1
                    && sortedStr.charAt(i)
                            == sortedStr.charAt(i + 1)) {
                    count++;
                    i++;
                }

                // Printing the duplicate character and its
                // count
                if (count > 1) {
                    System.out.println(sortedStr.charAt(i)
                                    + ", count = " + count);
                }
            }
        }

    /* Driver program to test above function*/
    public static void main(String args[])
    {
        String str = "test string";
        printDups(str);
    }
}
