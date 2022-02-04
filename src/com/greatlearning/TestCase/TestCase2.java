package com.greatlearning.TestCase;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestCase2 {
    static class Node {
        int key = 0;
        Node right = null;
        Node left = null;
    }

    static Node newNode(int data){
        Node temp = new Node();
        temp.key = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    void inOrder(Node curr,Node prev){
        if (curr == null){
            return;
        }else{
            inOrder(curr.left,prev);
            prev.left = null;
            prev.right = curr;
            inOrder(curr.right,prev);
        }
    }

    Node flatten(Node parent){
        Node dummy = newNode(-1);
        Node prev = dummy;
        inOrder(parent,prev);

        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;
        return ret;

    }

    static void print(Node parent)
    {
        Node curr = parent;
        while (curr != null)
        {
            System.out.print(curr.key + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {

        Node tree = newNode(50);
        tree.left = newNode(30);
        tree.right = newNode(60);
        tree.left.left = newNode(10);
        tree.right.left= newNode(55);

        TestCase2 Btree = new TestCase2();

        TestCase2.print(Btree.flatten(tree));




    }
}
