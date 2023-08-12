/*      238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 
Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 
Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)        */


import java.util.*;

//leetcode solution
class Solution 
{
    public int[] productExceptSelf(int[] nums) 
    {
        int mul=1,count=0;  
        for( int i=0 ; i<nums.length ; i++ )
        {
            if( nums[i]!=0 )
                mul*=nums[i];   //if the element is not 0 then multiply
            else
                count++;    //count 0 present in the array
        }   

        if( nums.length==count )
            return nums;    //if all the elements are 0 

        for( int i=0 ; i<nums.length ; i++ )
        {
            if( (count!=0 && nums[i]!=0) || (count>1 && nums[i]==0) )
                nums[i]=0;  //if count value is positive means there is 0 present in the array
                //so multiplication result is 0
            
            else if( ( count!=0 && nums[i]==0 ) )
                nums[i]=mul;
                //if the element is 0 then add mul to it

            else if( count==0 )
                nums[i]=mul/nums[i];
                //if no zero present do the operation 
        }
        return nums;
    }
}

//main class for drive the solution
public class ProductOfArrayExceptSelf
{
    public static void main(String args[])
    {
        Scanner Sc =new Scanner(System.in);
        int t=Sc.nextInt();
        while(t-->0)
        {
            int index = Sc.nextInt();
            int nums[] = new int[index];
            for( int i=0 ; i<index ; i++ )
                nums[i]=Sc.nextInt();

            Solution sl=new Solution();
            sl.productExceptSelf( nums);
            for( int i=0 ; i<index ; i++ )
                System.out.print(nums[i]+" ");
        }
    }
}