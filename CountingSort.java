import java.util.*;
import java.io.*;

public class CountingSort
{
  static int[] arr;
  static int[] sortedArr;
  public static void main(String[] args)
  {
    int size = promptUser();
    arr = new int[size];
    fillArray(arr);
    System.out.print("Unsorted Array: ");
    printArray( arr );

    sortedArr = countingSort(arr);
    System.out.print("Sorted   Array: ");
    printArray( sortedArr );


  } // end of main
  static int promptUser()
  {
    int pSum = 0;
    boolean go = true;
    do
    {
    try
    {
      Scanner in = new Scanner ( System.in );
      System.out.print("Enter the array size: ");
      pSum = in.nextInt();
      go = true;
    }
    catch ( Exception e)
    {
      //System.out.println("Enter a number: ");
      Scanner in = new Scanner ( System.in );
      go = false;
    }

  } while ( !go );
  return pSum;

  } // End of promptUser
  static void fillArray( int[] arr )
  {
    Random rnd = new Random();
    for ( int i = 0; i < arr.length; i++)
      arr[i] = rnd.nextInt(26); // generates numbers from 0-25
  }
  static void printArray(int[] arr )
  {
    for ( int i = 0; i < arr.length; i++ )
      System.out.print(arr[i] + " ");
    System.out.println();
  }

  static int[] countingSort( int[] arr )
  {
    int max = 0;
    for ( int i = 0; i < arr.length; i++ ){
      if ( max < arr[i] )
        max = arr[i];
    }

    int[] countArr = new int[max + 1];
    // going thru original array and counting how many times each elem occurs then indexing straight into the count arrau with the num
    for ( int j = 0; j < arr.length; j++ ){
      countArr[ arr[j] ]++;
    }

    // adding the prev elem starting at 1 to the next index... can start at 0 or 1 doenst matter
    for ( int k = 0; k < countArr.length-1; k++ ){
      countArr[k+1] += countArr[k];
    }

    int[] sorted = new int[arr.length];




    for ( int i = 0; i < arr.length; i++){
      int index = countArr[ arr[i] ] - 1;
      sorted[index] = arr[i];
      countArr[ arr[i] ]--; // descresing the count of that elem we just stored into the final array
    }
    return sorted;




  }


}// end of class
