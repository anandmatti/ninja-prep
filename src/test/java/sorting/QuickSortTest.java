package sorting;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void testIntegerSort(){
        Integer[] array = {10, 0, 5, -10, 19, 20};
        Integer[] expectedArray = {-10, 0, 5, 10, 19, 20};
        QuickSort<Integer> quickSort = new QuickSort<>(array);
        Integer[] sortedArray  = quickSort.sort();
        for ( int i =0; i < array.length ; i++) {
            Assert.assertEquals(String.format("%sth element is incorrect", i), sortedArray[i], expectedArray[i]);
        }
    }

    @Test
    public void testIntegerSortWithNull(){
        Integer[] array = {10, 0, 5, -10, 19, 20, null};
        Integer[] expectedArray = {-10, 0, 5, 10, 19, 20, null};
        QuickSort<Integer> quickSort = new QuickSort<>(array);
        Integer[] sortedArray  = quickSort.sort();
        for ( int i =0; i < array.length ; i++) {
            Assert.assertEquals(String.format("%sth element is incorrect", i), sortedArray[i], expectedArray[i]);
        }
    }

    @Test
    public void testStringSort(){
        String[] array = { "mattianand", "anand1", "anand", "mattikopp" };
        String[] expectedArray = { "anand", "anand1", "mattianand", "mattikopp" };
        QuickSort<String> quickSort = new QuickSort<>(array);
        String[] sortedArray  = quickSort.sort();
        for ( int i =0; i < array.length ; i++) {
            Assert.assertEquals(String.format("%sth element is incorrect", i), sortedArray[i], expectedArray[i]);
        }
    }
}
