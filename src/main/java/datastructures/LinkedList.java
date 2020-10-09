package datastructures;

/**
 * DS - LinkedList
 * DS Type - List
 * <p>
 * Time Complexity -
 * - add - O(n)
 * - remove - O(n)
 * - search - O(n)
 * - exists - O(n)
 * - size - O(1)
 * <p>
 * Space Complexity -
 * - O(n)
 * <p>
 * Uses simple connected node linked list approach for the implement. All traversal are done through root node.
 *
 * @param <T>
 */
public class LinkedList<T> {

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node<T> root;
    private int size = 0;

    public void add(T data) {
        Node<T> node = this.root;
        if (node == null) {
            node = new Node<>(data);
            this.root = node;
            size++;
            return;
        }


        while (node.next != null) {
            node = node.next;
        }

        node.next = new Node<>(data);
        size++;
    }

    public T get(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("IndexOutOfBoundException");
        }

        int i = 0;
        Node<T> node = root;
        while (index > i && node != null) {
            i++;
            node = node.next;
        }
        return node.data;
    }


    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("NoSuchElementFound");
        }

        int i = 0;
        T removedElement = null;
        Node<T> node = root;
        Node<T> previousNode = null;
        while (index > i && node != null) {
            i++;
            previousNode = node;
            node = node.next;
        }

        if (index == i) {
            removedElement = node.data;
            previousNode.next = node.next;
            size--;
        }
        return removedElement;
    }

    public T remove(T data) {
        T removedElement = null;
        Node<T> node = this.root;
        boolean notFound = true;
        Node<T> previousNode = null;
        while (node != null && notFound) {
            if (node.data.equals(data)) {
                removedElement = node.data;
                if (previousNode == null) {
                    root = node.next;
                } else {
                    previousNode.next = node.next;
                }
                size--;
                return removedElement;
            }
            previousNode = node;
            node = node.next;
        }

        return removedElement;
    }


    public Integer find(T data) {
        int index = 0;
        Node<T> node = this.root;
        boolean found = false;
        while (!found && node != null) {
            if (node.data.equals(data)) {
                found = true;

            } else {
                node = node.next;
                index++;
            }
        }
        return found ? index : null ;
    }

    public boolean contains(T data) {
        Node<T> node = this.root;
        while (node != null) {
            if (node.data.equals(data)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public int size() {
        return size;
    }
}
