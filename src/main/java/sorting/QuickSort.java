package sorting;

import java.util.Arrays;

/**
 * AlgoName - Quick Sort
 * AlgoType - Divide and Conquer
 * Time Complexity -
 *     - Best - O(n log(n) )
 *     - Average - O(n log(n))
 *     - Worst - O(n^2)
 *
 * Algorithm Steps -
 * 1. Find the pivot index - pi
 * 2. Partition the array around pivot index (Pivot is at it's right place)
 * 3. Repeat the step 1 and 2 for array from low to pi - 1
 * 4. Repeat the step 1 and 2 for array from pi+1 to high
 * <p>
 * Options for Pivot
 * - Pick the first element
 * - Pick the last element
 * - Pick the middle element
 * - Pick a random element
 * - Pick the median element
 * <p>
 * Partition Algorithm
 * - Put elements smaller than pivot to the left.
 * - Put elements greater than pivot to the right.
 *
 * The implementation here takes last element for the pivot
 *
 * @param <T extends Comparable>
 */
public class QuickSort<T extends Comparable<T>> {
    T[] array;

    public QuickSort(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
    }

    public T[] sort() {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private int partition(T[] array, int low, int high) {
        T pivot = array[high];
        int lastElementLessThanPivot = low - 1;
        for (int i = low; i < high; i++) {
            if (array[i] == null || pivot == null || array[i].compareTo(pivot) < 0) {
                lastElementLessThanPivot++;
                T temp = array[lastElementLessThanPivot];
                array[lastElementLessThanPivot] = array[i];
                array[i] = temp;
            }
        }
        T temp = array[lastElementLessThanPivot + 1];
        array[lastElementLessThanPivot + 1] = array[high];
        array[high] = temp;

        return lastElementLessThanPivot + 1;
    }
}

