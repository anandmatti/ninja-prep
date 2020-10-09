package algorithms.sorting;

import algortihms.sorting.MergeSort;
import org.junit.Assert;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testIntegerSort(){
        Integer[] array = {10, 0, 5, -10, 19, 20};
        Integer[] expectedArray = {-10, 0, 5, 10, 19, 20};
        MergeSort<Integer> quickSort = new MergeSort<>(array, Integer.class);
        Integer[] sortedArray  = quickSort.sort();
        for ( int i =0; i < array.length ; i++) {
            Assert.assertEquals(String.format("%sth element is incorrect", i), sortedArray[i], expectedArray[i]);
        }
    }

    @Test
    public void testIntegerSortWithNull(){
        Integer[] array = {10, 0, 5, -10, null, null, 19, 20};
        Integer[] expectedArray = {-10, 0, 5, 10, 19, 20, null, null};
        MergeSort<Integer> quickSort = new MergeSort<>(array, Integer.class);
        Integer[] sortedArray  = quickSort.sort();
        for ( int i =0; i < array.length ; i++) {
            Assert.assertEquals(String.format("%sth element is incorrect", i), sortedArray[i], expectedArray[i]);
        }
    }

    @Test
    public void testStringSort(){
        String[] array = { "mattianand", "mattikopp", null, "anand", "anand1" };
        String[] expectedArray = { "anand", "anand1", "mattianand", "mattikopp", null };
        MergeSort<String> quickSort = new MergeSort<>(array, String.class);
        String[] sortedArray  = quickSort.sort();
        for ( int i =0; i < array.length ; i++) {
            Assert.assertEquals(String.format("%sth element is incorrect", i), sortedArray[i], expectedArray[i]);
        }
    }
}
