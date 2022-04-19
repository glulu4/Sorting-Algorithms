import java.io.*;
import java.util.*;

// Notes to self:
// add a way to read in ints from a file then do the sort
// maybe add a way to use system.in and read in numbers and sort them


public class SelectionSort
{
  public static void main(String[] args) throws Exception
  {
    if ( args.length<1)  die("Next time enter the desired size of array");
    int arrSize = Integer.parseInt(args[0]);


    int[] arr = new int[arrSize];
    Random rnd = new Random();
    System.out.print("Unsorted array: ");
    for ( int i = 0; i < arr.length; i++)
    {
      arr[i] = rnd.nextInt(101); // generates random numbers from [0,101)
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    int[] sortedArr;
    sortedArr = SelectionSort(arr);
    System.out.print("Sorted Array:   ");
    printArr(sortedArr);



  } // end of main
  public static int[] SelectionSort( int[] arr )
  {
    //int count = arr.length-1;
    for ( int j = 0; j < arr.length; j++)
    {
      int minIndex = j;
      int min = arr[j];
      for ( int i = 0+j; i < arr.length; i++) // the +j increments the array search space so that you dont search the beggining part as you sort
      {
        if ( min > arr[i])
        {
          min = arr[i]; // finds min in the array ( array is shortened by j every loop )
          minIndex = i; // gives us the val of where the min value came from
        }
      }
      int temp = arr[j];
      arr[j] = min; // swapping min value for the val at j
      arr[minIndex] = temp; // moving val at j to where the min came from

    }
    return arr;
  }

  public static void printArr( int[] arr)
  {
    for ( int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
  }
  static void die(String errMsg)
	{
		System.out.println(errMsg);
		System.exit(0);
	}
} // END OF CLASS
