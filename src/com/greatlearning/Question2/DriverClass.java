package com.greatlearning.Question2;

public class DriverClass {

    static class Node
    {
        int data;
        Node left ;
        Node right;

        Node (int data)
        {
          this.data = data;
          left = null;
          right = null;
        };
    }

    static void print(Node parent){
        Node curr = parent;
        while(curr!= null){
            System.out.println(curr.data + " ");
            curr = curr.right;
        }
    }

    static Node prev;
    // Function to perform
    // in-order traversal

    static void Inorder(Node curr){
        // Base case
        if (curr == null){
            return;
        }
        Inorder(curr.left);
        prev.left = null;
        prev.right = curr;
        prev = curr;
        Inorder(curr.right);
    }

    //function to make the bst skewed
    // tree using level order
    // traversal
    static Node BSTToSkewed(Node parent){
        // Dummy node
        Node dummy = new Node(-1);

        //Pointer to previous
        // element
        prev = dummy;

        // Calling in-order
        // traversal

        Inorder(parent);

        prev.left = null;
        prev.right = null;
        Node ret = dummy.right;

        // Delete dummy node
        // delete dummy
        return ret;
    }

    public static void main(String[] args) {
        Node tree = new Node(50);

        tree.left = new Node(30);
        tree.right = new Node(60);
        tree.left.left = new Node(10);
        tree.right.left= new Node(55);

        //Calling required function
        print(BSTToSkewed(tree));

    }
}
