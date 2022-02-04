package com.greatlearning.TestCase;

import java.util.LinkedList;
import java.util.Queue;

public class Driver {
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

    void levelOrder(Node root){
        Queue<Node> queue1 = new LinkedList<Node>();
        queue1.add(root);
        while(!queue1.isEmpty()){

            Node tempNode = queue1.poll();
            System.out.print(tempNode.key + " ");

            //enqueue left node
            if (tempNode.left != null){
                queue1.add(tempNode.left);
            }

            //enqueue right node
            if (tempNode.right != null){
                queue1.add(tempNode.right);
            }

        }
    }

    public  Node rightRotation( Node y){
        Node x = y.left;
        if (x.right!=null){
            Node T2 = x.right;

            x.right = y;
            y.left = T2;
        }else{
            x.right = y;
        }

        // Return new root
        return x;
    }

    public Node BstTOSkewed(Node tree){
          if (tree == null){
              return null;
          }
              Node temp = tree;

              while(temp.left != null){
                  temp = rightRotation(temp);
              }

        // not able to rotate the right sub tree
              Node prevNode = null;
              Node dummyNode = null;



              while(temp.right.left == null ){
                  Node x = temp.right;
              }
              return temp;
    }

    public static void main(String[] args) {
        Node tree = newNode(50);
        tree.left = newNode(30);
        tree.right = newNode(60);
        tree.left.left = newNode(10);
        tree.right.left= newNode(55);

        Driver Btree = new Driver();
        System.out.println("level Order traversal of binary tree before making it skewed :");
        Btree.levelOrder(tree);
        tree = Btree.BstTOSkewed(tree);
        Btree.levelOrder(tree);

    }
}
