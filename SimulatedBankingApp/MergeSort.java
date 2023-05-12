import javax.swing.*; // The package where the components are
import java.awt.event.*; // Used for event listeners and events
import java.awt.font.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

/* Java program for Merge Sort */
//below code was implemented from https://www.withexample.com/merge-sort-using-arraylist-java-example/
//all that was changed was the arraylist type and comparison of amount in transaction
public class MergeSort {
  private ArrayList<TransactionInfo> inputArray;

  public ArrayList<TransactionInfo> getSortedArray() {
    return inputArray;
  }

  public MergeSort(ArrayList<TransactionInfo> inputArray) {
    this.inputArray = inputArray;
  }

  public void sortGivenArray() {
    divide(0, this.inputArray.size() - 1);
  }

  public void divide(int startIndex, int endIndex) {

    // Divide till you breakdown your list to single element
    if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
      int mid = (endIndex + startIndex) / 2;
      divide(startIndex, mid);
      divide(mid + 1, endIndex);

      // merging Sorted array produce above into one sorted array
      merger(startIndex, mid, endIndex);
    }
  }

  public void merger(int startIndex, int midIndex, int endIndex) {

    // Below is the mergedarray that will be sorted array Array[i-midIndex] ,
    // Array[(midIndex+1)-endIndex]
    ArrayList<TransactionInfo> mergedSortedArray = new ArrayList<TransactionInfo>();

    int leftIndex = startIndex;
    int rightIndex = midIndex + 1;

    while (leftIndex <= midIndex && rightIndex <= endIndex) {
      if ((inputArray.get(leftIndex)).getAmountDouble() <= (inputArray.get(rightIndex)).getAmountDouble()) {
        mergedSortedArray.add(inputArray.get(leftIndex));
        leftIndex++;
      } else {
        mergedSortedArray.add(inputArray.get(rightIndex));
        rightIndex++;
      }
    }

    // Either of below while loop will execute
    while (leftIndex <= midIndex) {
      mergedSortedArray.add(inputArray.get(leftIndex));
      leftIndex++;
    }

    while (rightIndex <= endIndex) {
      mergedSortedArray.add(inputArray.get(rightIndex));
      rightIndex++;
    }

    int i = 0;
    int j = startIndex;
    // Setting sorted array to original one
    while (i < mergedSortedArray.size()) {
      inputArray.set(j, mergedSortedArray.get(i++));
      j++;
    }
  }
}
