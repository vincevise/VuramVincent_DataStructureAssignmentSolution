package com.greatlearning.Question1.DriverClass;

import com.greatlearning.Question1.SortStack.SortStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the total no of floors in the building");
        // taking input from the user n = no of floors
        int n = sc.nextInt();

        // adding floor no. in the queue(floor) in descending order so that floor.peek() becomes the largest floor
        Queue<Integer> floor = new LinkedList<Integer>();
        for (int i = n; i > 0 ; i--) {
            floor.add(i);
        }

        Queue<Integer> floorSize = new LinkedList<Integer>();

        // push floor size values(taken by the user) in the queue(floorSize) Day wise
        for (int i = 1; i <= n; i++) {
            System.out.println("enter the floor size given on day :" + i);
            int f = sc.nextInt();
            floorSize.add(f);
        }

        System.out.println("The order of construction is as follows");

        // store values in the
        Stack<Integer> stack = new Stack<Integer>();
        // to avoid empty stack exception
        stack.push(-1);

        SortStack sortStack = new SortStack();
        for (int i = 1; i <=n ; i++) {
            System.out.println( );
            System.out.println("Day " + i  +" :");
            if (floorSize.peek() != floor.peek() ){
                // if the floor's head and floorSize's head are not equal then remove the head from the floorSize add push it to the stack
                stack.push(floorSize.poll());
                // Sort the stack so that the largest element becomes the head
                stack = sortStack.sort(stack);
            }else if (floorSize.peek() == floor.peek()){
                // if the floor's head and floorSize's heads are equal then remove the
                // heads then print the removed head of floorSize
                floor.remove();
                System.out.print(floorSize.poll() + " ");
                while(floor.peek() == stack.peek()){
                        floor.remove();
                        System.out.print(stack.pop() + " ");
                }
            }
        }
    }
}
