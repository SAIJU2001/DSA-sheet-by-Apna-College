//alpha

/*      11. Container With Most Water
Medium
25.3K
1.4K
Companies
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:

Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:

Input: height = [1,1]
Output: 1
 
Constraints:
n == height.length
2 <= n <= 105
0 <= height[i] <= 104
*/

import java.util.*;

//leetcode solution
class Solution 
{
    public int maxArea(int[] height) 
    {    
        int area=0,maxArea=Integer.MIN_VALUE;
        int leftH=0,rightH=height.length-1,minH=0;
        //when the left height less than right height
        while( leftH<rightH )
        {
            //calculate minimumum height from left and right
            minH=Math.min( height[leftH], height[rightH] );
            //formula of  calculate area
            area=minH*( rightH-leftH );
            maxArea=Math.max( area, maxArea );
            //min height pointer shifted 1 place
            if( minH==height[rightH] )
                rightH--;
            else
                leftH++;
        }
        return maxArea;
    }
}


//driver code
public class ContainerWithMostWater
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int n=Sc.nextInt();     //enter the length of the array
        int height[]=new int[n];
        for( int i=0 ; i<n ; i++ )
        {
            //enter the elements of the array
            height[i]=Sc.nextInt();
        }
        Solution sl=new Solution();
        System.out.print( sl.maxArea(height) );
    }
}