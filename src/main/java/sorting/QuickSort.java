package sorting;

import java.util.Arrays;

/**
 * Quick Sort Algorithms
 * 1. Find the pivot index - pi
 * 2. Partition the array around pivot index (Pivot is at it's right place)
 * 3. Repeat the step 1 and 2 for array from low to pi - 1
 * 4. Repeat the step 1 and 2 for array from pi+1 to high
 * <p>
 * Options for Pivot
 * - Pick the first element
 * - Pick the last element
 * - Pick a random element
 * - Pick the median element
 * <p>
 * Partition Algorithm
 * - Put elements smaller than pivot to the left.
 * - Put elements greater than pivot to the right.
 *
 * @param <T>
 */
public class QuickSort<T extends Integer> {
    T[] array;

    public QuickSort(T[] array) {
        this.array = Arrays.copyOf( array, array.length);
    }

    public T[] sort() {
        quickSort(array, 0, array.length - 1 );
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
            if (array[i].compareTo(pivot) < 0) {
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

    public static void main(String[] args) {
        Integer[] array = {10, 0, 5, -10, 19, 20};
        print( "Original Array - ", array );

        QuickSort<Integer> quickSort = new QuickSort<>(array);
        Integer[] sortedArray  = quickSort.sort();

        print("Sorted Array - ", sortedArray );
    }

    private static void print(String message, Integer[] array) {
        System.out.println(message);
        Arrays.stream(array).forEach(item -> System.out.print(item + ","));
        System.out.println();
    }
}

