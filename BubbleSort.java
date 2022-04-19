import java.io.*;
import java.util.*;

public class BubbleSort
{
  public static void main(String[] args) throws Exception
  {
    if ( args.length<1)  die("Next time enter the desired size of array");
    int size = Integer.parseInt(args[0]);

    int[] arr = new int[size];
    Random rdm = new Random();
    for ( int i = 0; i < arr.length; i++)
      arr[i] = rdm.nextInt(101); // generates random numbers from 0 - 100
    System.out.print("Unsorted Array: ");
    printArr(arr);

    int[] sortedArr = BubbleSort(arr);
    System.out.print("Sorted Array:   ");
    printArr(sortedArr);

  } // END OF MAIN

  public static int[] BubbleSort( int[] arr )
  {
    boolean sorted = false;
    while ( !sorted)  // while array is not sorted
    {
      sorted = true;
      for ( int i = 0; i < arr.length-1; i++)
      {
        if ( arr[i+1]<arr[i] ) // if second elem is less than one before
        {
          int swap = arr[i]; // stores val before swap
          arr[i] = arr[i+1]; // one after puts his number into position before
          arr[i+1] = swap;
          sorted= false;
        }
      }
    }
    return arr;
  }

  static void printArr( int[] arr)
  {
    for ( int i = 0; i < arr.length; i++)
      System.out.print( arr[i] + " ");
    System.out.println();
  }


  static void die(String errMsg)
	{
		System.out.println(errMsg);
		System.exit(0);
	}

} // END OF CLASS
