//alpha

/*Write a program to reverse an array
Read
Discuss(210+)
Courses
Practice

 
Given an array (or string), the task is to reverse the array/string.
Examples : 
 

Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}
 
*/

 //  Java Program to reverse an array
import java.io.*;

class ReverseArray 
{

	// Function to reverse arr[] from start to end(Recursive)
        static void rvereseArray(int arr[], int start, int end)
        {
            int temp;

            if (start >= end)
                return;
                
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            rvereseArray(arr, start+1, end-1);
        }

    // Function to reverse arr[] from start to end(Iterative)
        /*    
            static void rvereseArray(int arr[], int start, int end)
            {
                int temp;

                while (start < end)
                {
                    temp = arr[start];
                    arr[start] = arr[end];
                    arr[end] = temp;
                    start++;
                    end--;
                }
            }	
        */

	/* Utility that prints out an array on a line */
	static void printArray(int arr[], int size)
	{
		for (int i=0; i < size; i++)
        {
			System.out.print(arr[i] + " ");
        }
		System.out.println("");
	}

	/*Driver function to check for above functions*/
	public static void main (String[] args) 
    {
		int arr[] = {1, 2, 3, 4, 5, 6};
		printArray(arr, 6);
		rvereseArray(arr, 0, 5);
		System.out.println("Reversed array is ");
		printArray(arr, 6);
	}
}

    