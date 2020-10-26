package datastructures.trees;

import jdk.nashorn.internal.ir.WhileNode;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.concurrent.*;

public class BinarySearchTreeTest {

    @Test
    public void testTreeCreation(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>( 7, 2, 8, 4, 5, 9, 20, 25);
        Assert.assertEquals( binarySearchTree.size(), 8 );
    }

    @Test
    public void testTreeRoot(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>( 7, 2, 8, 4, 5, 9, 20, 25);
        int root = binarySearchTree.getRoot().value;
        Assert.assertEquals(root, 7 );
    }

    @Test
    public void testInOrderTraversal(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>( 7, 2, 8, 4, 5, 9, 20, 25);
        Assert.assertEquals( binarySearchTree.size(), 8 );
        String inOrderTree = "2 4 5 7 8 9 20 25";
        Assert.assertEquals( binarySearchTree.printInOrder(), inOrderTree);
    }

    @Test
    public void testPreOrderTraversal(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>( 7, 2, 8, 4, 5, 9, 20, 25);
        Assert.assertEquals( binarySearchTree.size(), 8 );
        String preOrderTree = "7 2 4 5 8 9 20 25";
        Assert.assertEquals( binarySearchTree.printPreOrder(), preOrderTree);
    }

    @Test
    public void testPostOrderTraversal(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>( 7, 2, 8, 4, 5, 9, 20, 25);
        Assert.assertEquals( binarySearchTree.size(), 8 );
        String postOrderTree = "5 4 2 25 20 9 8 7";
        Assert.assertEquals( binarySearchTree.printPostOrder(), postOrderTree);
    }


    @Test
    public void testTreeDelete(){
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(7, 2, 8, 4, 5, 9, 20, 25);
        Assert.assertEquals( binarySearchTree.size(), 8 );
        String preOrderTree = "7 2 4 5 8 9 20 25";
        Assert.assertEquals( binarySearchTree.printPreOrder(), preOrderTree);

        binarySearchTree.delete(7);
        preOrderTree = "8 2 4 5 9 20 25";
        Assert.assertEquals( binarySearchTree.printPreOrder(), preOrderTree);

        binarySearchTree.delete(9);
        preOrderTree = "8 2 4 5 20 25";
        Assert.assertEquals( binarySearchTree.printPreOrder(), preOrderTree);

        binarySearchTree.delete(4);
        preOrderTree = "8 2 5 20 25";
        Assert.assertEquals( binarySearchTree.printPreOrder(), preOrderTree);
    }

}
