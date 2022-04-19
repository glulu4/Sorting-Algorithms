import java.util.*;
import java.io.*;

public class InsertionSort
{
  public static void main(String[] args) throws Exception
  {
    int size = 0;

      boolean go = true;
      do
      {
      try
      {
        Scanner in = new Scanner ( System.in );
        System.out.print("Enter a number: ");
        size = in.nextInt();
        go = true;
      }
      catch ( Exception e)
      {
        //System.out.println("Enter a number: ");
        Scanner in = new Scanner ( System.in );
        go = false;
      }

    } while ( !go );

  int[] arr = new int[size];
  fillArray(arr);
  System.out.print("Unsorted Array: ");
  printArr(arr);

  int[] sortedArr = InsertionSort(arr);
  System.out.print("Sorted Array:   ");
  printArr(sortedArr);




  } // END OF MAIN

  // 4,3,2,15,7,89,0
  public static int[] InsertionSort( int[] arr ) // compare arr[i] to all values before and move the min to the back
  {

    // iterate trhough sorrted portion, starts at j and go down
    for ( int j = 0; j < arr.length-1; j++)
    {
      for ( int i = j; i >= 0 ; i--) // this loops backwards from wherever j is. so lets say j=5, then the inner loop
      {                              // will iterate from 5 to zero backwards
        if ( arr[i+1] < arr[i])
        {
          int temp = arr[i+1];
          arr[i+1] = arr[i];
          arr[i] = temp;
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
  static void fillArray ( int[] arr)
  {
    Random rnd = new Random();
    for ( int i = 0; i < arr.length ; i++)
      arr[i] = rnd.nextInt(101); // generates random numbers from 0-100!

  }








} // END OF CLASS
