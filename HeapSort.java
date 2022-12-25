import java.io.*;
import java.util.*;

public class HeapSort
{
  public static int[] array;

  public static void main(String[] args){
    array = fillArray( promptForSize() );
    System.out.print("Unsorted Array: ");
    printArr(array);
    System.out.print("Sorted Array:   ");
    heapSort();
    printArr(array);

  }

  public static int promptForSize(){
    int size = 0;
    boolean validIn = false;
    Scanner scn;
    do{
      try{
        scn = new Scanner(System.in);
        System.out.print("Enter array size ( less than 20 ): ");
        size = scn.nextInt();
        if ( size > 20 )
          throw new Exception();
        validIn = true;
      }
      catch( Exception e){
        System.out.println("Oops something went wrong, integers only");
        scn = new Scanner(System.in);
        validIn = false;
      }

    } while ( !validIn );
    return size;

  }

  public static int[] fillArray( int size ){
    int[] arr = new int[size];
    Random rnd = new Random();

    for ( int i = 0; i < size; i++ )
      arr[i] = rnd.nextInt(51); // generates random numbers from 0 - 100

    return arr;


  }
  public static void heapSort(){
    int length = array.length;
    // iterating from the first non-leaf node, which is at index (length/2) - 1
    // building max heap
    for ( int i = (length/2) - 1; i >= 0; i-- )
      heapify(length, i );

    for ( int j = length-1; j>=0; j--){
      // swaps root with last element
      int temp = array[0];
      array[0] = array[j];
      array[j] = temp;
      heapify( j, 0 );
    }
  }

  public static void heapify(int length, int i){
    int parent = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if ( left < length && array[left] > array[parent] )
      parent = left; // swapping indexes
    if ( right < length && array[right] > array[parent] )
      parent = right;

    if ( parent != i ){
      int temp = array[parent];
      array[parent] = array[i];
      array[i] = temp;
      heapify(length, parent);
    }
  }
  static void printArr( int[] arr){
    for ( int i = 0; i < arr.length; i++)
      System.out.print( arr[i] + " ");
    System.out.println();
  }







}
