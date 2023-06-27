/*      54. Spiral Matrix
Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100             */

import java.util.*;

//leetcode solution
class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        int top=0,bottom=matrix.length-1;
        int left=0,right=matrix[0].length-1;
        int count=0;
        ArrayList<Integer> list=new ArrayList<>();
        while( left<=right && top<=bottom )
        {
            if( count==0 )
            {
                for( int i=left ; i<=right ; i++ )
                    list.add(matrix[top][i]);
                top++;
            }
            else if( count==1 )
            {
                for( int i=top ; i<=bottom ; i++ )
                    list.add(matrix[i][right]);
                right--;
            }
            else if( count==2 )
            {
                for( int i=right ; i>=left ; i-- )
                    list.add(matrix[bottom][i]);
                bottom--;
            }
            else if( count==3 )
            {
                for( int i=bottom ; i>=top ; i-- )
                    list.add(matrix[i][left]);
                    left++;
            }
            count++;
            count=count%4;
        }
        return list;
    }
}

//main class for drive the program
public class SpiralMatrix
{
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int t=Sc.nextInt();
        while(t-->0)
        {
            int n=Sc.nextInt();
            int matrix[][]=new int[n][n];
            for( int i=0 ; i<n ; i++ )
                for( int j=0 ; j<n ; j++ )
                    matrix[i][j]=Sc.nextInt();
            
            Solution sl=new Solution();
            ArrayList<Integer> lt=new ArrayList<>(sl.spiralOrder( matrix));
            for( int i=0 ; i<lt.size() ; i++ )
                System.out.print( lt.get(i) );
        }
    }
}