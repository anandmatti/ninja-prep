package datastructures;

import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {

    @Test
    public void testCreateHashTable(){
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        Assert.assertNotNull(hashTable);
    }

    @Test
    public void testPutAndGetHashTable(){
        HashTable<String, Integer> hashTable = new HashTable<>(10);
        Assert.assertNotNull(hashTable);
        hashTable.put( "key_01", 100);
        hashTable.put( "key_02", 200);
        hashTable.put( "key_03", 300);
        Assert.assertEquals(hashTable.get("key_01"), new Integer( 100 ));
        Assert.assertEquals(hashTable.get("key_02"), new Integer(200 ));
        Assert.assertEquals(hashTable.get("key_03"), new Integer(300 ));
        hashTable.put( "key_03", 400);
        Assert.assertEquals(hashTable.get("key_03"), new Integer(400 ));

    }
}
