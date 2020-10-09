package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testCreateLinkedList(){
        LinkedList<Integer> integerList = new LinkedList<>();
        Assert.assertNotNull(integerList);
    }

    @Test
    public void testAddElement(){
        LinkedList<Integer> integerList = new LinkedList<>();
        Assert.assertNotNull(integerList);
        integerList.add(1);
        integerList.add(2);
        Assert.assertEquals(integerList.size(), 2);
    }

    @Test
    public void testGetByIndex(){
        LinkedList<Integer> integerList = new LinkedList<>();
        Assert.assertNotNull(integerList);
        integerList.add(1);
        integerList.add(2);
        Assert.assertEquals(integerList.size(), 2);
        Assert.assertEquals(integerList.get(0), new Integer(1 ));
        Assert.assertEquals(integerList.get(1), new Integer(2));
    }

    @Test
    public void testRemoveByIndex(){
        LinkedList<Integer> integerList = new LinkedList<>();
        Assert.assertNotNull(integerList);
        integerList.add(100);
        integerList.add(200);
        Assert.assertEquals(integerList.size(), 2);
        Integer removed = integerList.remove(1);
        Assert.assertEquals(integerList.size(), 1);
        Assert.assertEquals( removed, new Integer(200 ));
    }

    @Test
    public void testRemoveByElement(){
        LinkedList<Integer> integerList = new LinkedList<>();
        Assert.assertNotNull(integerList);
        integerList.add(100);
        integerList.add(200);
        Assert.assertEquals(integerList.size(), 2);
        Integer removed = integerList.remove(new Integer(200 ));
        Assert.assertEquals(integerList.size(), 1);
        Assert.assertEquals( removed, new Integer(200 ));
        removed = integerList.remove(new Integer(1000 ));
        Assert.assertEquals(integerList.size(), 1);
        Assert.assertEquals( removed,null);
    }

    @Test
    public void testFind(){
        LinkedList<Integer> integerList = new LinkedList<>();
        Assert.assertNotNull(integerList);
        integerList.add(1);
        integerList.add(2);
        Assert.assertEquals(integerList.find(2).intValue(), 1);
        Assert.assertEquals(integerList.find(1).intValue(), 0);
        Assert.assertEquals(integerList.find(3), null);
    }


    @Test
    public void testContains(){
        LinkedList<Integer> integerList = new LinkedList<>();
        Assert.assertNotNull(integerList);
        integerList.add(1);
        integerList.add(2);
        Assert.assertEquals(integerList.contains(2), true);
        Assert.assertEquals(integerList.contains(1), true);
        Assert.assertEquals(integerList.contains(3), false);
    }
}
