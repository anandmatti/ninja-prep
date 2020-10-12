package datastructures;


/**
 * DS - HashTable
 * DS Type - HashTable
 * <p>
 * Time Complexity -
 * Average Case -
 * - Insertion - O(1)
 * - Retrieval - O(1)
 * - Delete - O(1)
 * - Contains - O(1)
 * Worst Case -
 * - Insertion - O(n)
 * - Retrieval - O(n)
 * - Delete - O(n)
 * - Contains - O(n)
 * <p>
 * It is implementation an array (of list of items) of size n i.e n buckets where an item can be loaded as key value pairs.
 * Each item has is associated with a hashCode, which determines the bucket the item would be inserted into.
 * <p>
 * Implementation can be done in two ways
 * - 2D Array.
 * - Array of List.
 */
public class HashTable<K, V> {

    private Entry<K, V>[] entrySet;
    private int size;

    private class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
        public int getHash() {
            return hash;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public void setValue( V value){
            this.value = value;
        }

    }

    public HashTable(int size) {
        entrySet = new Entry[size];
        this.size = size;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode();
        int hash = Math.abs(hashCode % size);
        if (entrySet[hash] == null) {
            entrySet[hash] = new Entry<>(hash, key, value);
        } else {
            Entry<K, V> node = entrySet[hash];
            while (node != null && !node.getKey().equals(key)) {
                node = node.next;
            }
            if (node.getKey().equals(key)) {
                node.setValue( value );
            } else {
                node.next = new Entry<>(hash, key, value);
            }

        }
    }

    public V get(K key) {
        int hashCode = Math.abs(key.hashCode() % size);

        Entry<K, V> entryNode = entrySet[hashCode];
        if (entryNode.getKey().equals(key)) {
            return entryNode.getValue();
        } else {
            while (entryNode.next != null) {
                entryNode = entryNode.next;
                if (entryNode.getKey().equals(key)) {
                    return entryNode.getValue();
                }
            }
        }
        return null;
    }

    public V delete(K key) {
        int hashCode = Math.abs(key.hashCode() % size);
        Entry<K, V> entryNode = entrySet[hashCode];
        if (entryNode.getKey().equals(key)) {
            V value = entryNode.getValue();
            entrySet[hashCode] = null;
            return value;
        } else {
            Entry<K, V> previousNode = null;
            while (entryNode.next != null) {
                if (entryNode.getKey().equals(key)) {
                    if (previousNode == null) {
                        entrySet[hashCode] = null;
                    } else {
                        previousNode.next = entryNode.next;
                    }
                    return entryNode.getValue();
                }
                previousNode = entryNode;
                entryNode = entryNode.next;
            }
        }
        return null;
    }

}
