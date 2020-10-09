package algortihms.sorting;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * AlgoName - Merge Sort
 * AlgoType - Divide and Conquer
 *
 * Time Complexity -
 * - Best - O(n log(n) )
 * - Average - O(n log(n))
 * - Worst -O(n log
 *
 * Space Complexity - O(n)
 *
 * Algorithm Steps -
 * 1. Divide the array into two partitions
 * 2. Sort Partition 1
 * 3. Sort Partition 2
 * 4. Merge both partitions
 * <p>
 * Options for partitions
 * 1. Middle element
 * 2. Random Number
 *
 * This implementation for Merge Sort takes NULLs at last approach using stack.
 *
 */
public class MergeSort<T extends Comparable<T>> {
    T[] array;
    Class<T> clazz;

    public MergeSort(T[] array, Class<T> clazz) {
        this.array = Arrays.copyOf(array, array.length);
        this.clazz = clazz;
    }

    public T[] sort() {
        mergeSort(array, 0, array.length - 1);
        return array;
    }

    private void mergeSort(T[] array, int low, int high) {
        if (low < high) {
            int pivot = (low + high) / 2;
            mergeSort(array, low, pivot);
            mergeSort(array, pivot + 1, high);
            merge(array, low, pivot, high);
        }
    }

    private void merge(T[] array, int low, int pivot, int high) {
        int leftArraySize = pivot - low + 1;
        int rightArraySize = high - pivot;

        // Initialize two temporary arrays
        T[] leftArray = createNewArray(leftArraySize);
        T[] rightArray = createNewArray(rightArraySize);
        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[low + i];
        }
        for (int i = 0; i < rightArraySize; i++) {
            rightArray[i] = array[pivot + 1 + i];
        }

        //merge the data from temp array to main array
        int firstIndex = 0;
        int secondIndex = 0;
        int mainIndex = low;

        while (mainIndex < high && firstIndex < leftArraySize && secondIndex < rightArraySize) {
            if ( leftArray[firstIndex] != null && rightArray[secondIndex] != null && leftArray[firstIndex].compareTo(rightArray[secondIndex]) > 0) {
                array[mainIndex++] = rightArray[secondIndex++];
            } else {
                array[mainIndex++] = leftArray[firstIndex++];
            }
        }

        Stack<String> nullStack = new Stack<>();
        if ( firstIndex < leftArraySize) {
            for (int i= firstIndex; i< leftArraySize ; i++){
                if (leftArray[i] != null) {
                    array[mainIndex++] = leftArray[i];
                } else {
                    nullStack.push("NULL");
                }
            }
        }

        if ( secondIndex < rightArraySize) {
            for (int i= secondIndex; i< rightArraySize ; i++){
                if (rightArray[i] != null) {
                    array[mainIndex++] = rightArray[i];
                } else {
                    nullStack.push("NULL");
                }
            }
        }

        while( !nullStack.isEmpty() && nullStack.peek() != null ){
            nullStack.pop();
            array[mainIndex++] = null;
        }
    }

    private T[] createNewArray(int size) {
        return (T[]) Array.newInstance( clazz, size);
    }

}
