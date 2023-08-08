//alpha

/*  42. Trapping Rain Water
Hard
27.7K
383
Companies
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 
Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

import java.util.*;

class Solution 
{
    public int trap(int[] height) 
    {
        int n=height.length;
        int leftMax[]=new int[n];
        leftMax[0]=height[0];
        for( int i=1 ; i<n ; i++ )
        {
            //find next greter element from left to right
            leftMax[i]=Math.max( leftMax[i-1],height[i] );
        }
        int rightMax[]=new int[n];
        rightMax[n-1]=height[n-1];
        for( int i=n-2 ; i>=0 ; i-- )
        {
            //find next greater element from right to left
            rightMax[i]=Math.max( rightMax[i+1],height[i] );
        }
        int trapped=0;
        for( int i=0 ; i<height.length ; i++ )
        {
            //find min height and calculate trapped water    
            int waterLevel=Math.min( leftMax[i], rightMax[i] );
            trapped+=waterLevel-height[i];
        }
        return trapped;
    }
}

//driver code
public class TrappingRainWater
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
        System.out.print( sl.trap(height) );
    }
}