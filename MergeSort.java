import java.io.*;
import java.util.*;

public class MergeSort
{
  public static void main(String[] args)
  {
    int size = promptUser();
    int[] arr = new int[size];

    System.out.print("Unsorted Array: ");
    fillArray(arr);
    printArr(arr);

    System.out.print("Sorted Array:   ");
    mergeSort( arr, 0, arr.length-1);
    printArr(arr);



  } // end of main
  static int promptUser()
  {
    int size = 0;
    boolean go = true;
    do
    {
    try
    {
      Scanner in = new Scanner ( System.in );
      System.out.print("Enter size of array: ");
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
  return size;

  } // End of promptUser


  static void printArr( int[] arr)
  {
    for ( int i = 0; i < arr.length; i++)
      System.out.print(arr[i] + " ");
    System.out.println();
  }
  static void fillArray( int[] arr )
  {
    Random rnd = new Random();
    for ( int i = 0; i < arr.length; i++)
      arr[i] = rnd.nextInt(101); // generates numbers from 0-100
  }
  public static void mergeSort( int[] arr, int leftIndex, int rightIndex ) // rightIndex comes in as 0, leftIndex comes in as arr.length-1
  {
    if ( leftIndex < rightIndex )
    {
      int midpoint = ( rightIndex + leftIndex)/2; // finds midpoint of subArray
      mergeSort(arr, leftIndex, midpoint ); // first half of array
      mergeSort(arr, midpoint+1, rightIndex ); // second half of array
      merge(arr, leftIndex, midpoint, rightIndex );
    }


  }
  public static void merge( int[] arr, int leftIndex, int midpoint, int rightIndex)
  {
    int leftSubArrayLength = ( midpoint - leftIndex ) + 1;
    int rightSubArrayLength = ( rightIndex - midpoint );

    int[] leftSubArray = new int[leftSubArrayLength];
    int[] rightSubArray = new int[rightSubArrayLength];

    for ( int i = 0; i < leftSubArrayLength; i++ )
      leftSubArray[i] = arr[i+leftIndex];

    for ( int j = 0; j < rightSubArrayLength; j++ )
      rightSubArray[j] = arr[j + midpoint + 1];

    int arr1Index = 0;
    int arr2Index = 0;
    int index = leftIndex;
    while ((arr1Index < leftSubArrayLength) && (arr2Index < rightSubArrayLength)) // looping through both arrays
    {
      if ( leftSubArray[arr1Index] <= rightSubArray[arr2Index] ) // if elem in first array is less than elem in second array
      {
        arr[index] = leftSubArray[arr1Index];
        arr1Index++;
      }
      else
      {
        arr[index] = rightSubArray[arr2Index];
        arr2Index++;
      }
      index++;
    }
    while ( arr1Index < leftSubArrayLength )
    {
      arr[index] = leftSubArray[arr1Index];
      index++;
      arr1Index++;
    }
    while ( arr2Index < rightSubArrayLength)
    {
      arr[index] = rightSubArray[arr2Index];
      index++;
      arr2Index++;
    }



  }
} // END OF CLASS
