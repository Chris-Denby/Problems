/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.problems;

import com.mycompany.problems.Vertice;
import java.awt.Event;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.swing.JButton;

/**
 *
 * @author chris
 */
public class Main 
{

    
    public static void main(String[] args)
    {
      
        /**
        ArrayList nums = new ArrayList<Integer>();
        nums.add(9);
        nums.add(3);
        nums.add(5);
        nums.add(1);
        nums.add(7);
        nums.add(2);
        nums.add(4);
        nums.add(8);
        nums.add(6);        
        
        //binarySearch2(nums, 3);
        binarySearch(3,nums);
        **/
        /**
        
        ArrayList things = new ArrayList<Thing>();
        things.add("Bob");
        things.add("Chris");
        things.add("Freya");
        things.add("Maynard");
        things.add("Celeste");
        things.add("Jenny");
        things.add("Genie");
        things.add("Peter");
        things.add("Leanne");
        things.add("Tommy");
        things.add("Asher");
        things.add("Hana");
        things.add("Taco");
        things.add("Elka");
        things.add("Paul");
        things.add("Indigo");
        things.add("Ayla");
        binarySearchGeneric(things,"Taco");
        **/
        
        //binaryTree();
        
        //factorNumberRevision2(8);  
        //graph();
        
        //lambda();
        //System.out.println(reverseString("Maynard"));
        //swapTwoNumbers(7,4);
        //System.out.println(checkVowels("Mbynbrd"));
        //System.out.println(""+factorizer(7));
        //System.out.println("Reverse factorizer = " + reverseFactorial(5040));
        
        //int[] arrayA = new int[]{1,2,3,4,5,6,7,8,9};
        //int[] arrayB =  new int[]{1,2,3,4,5};
        
        /**
        int[] arrayC = new int[]{5,3,7,4,2,11,6,8,90,76,45,332,11,4,6,789,76,5,432};
        insertSort3(arrayC);
        for(int i:arrayC)
        {
            System.out.println(i);
        }
        **/
        System.out.println(factorizer(6));
    }
        
    public static void linkedList()
    {
        LinkedList<Integer> ll = new LinkedList<>();
        LinkedList<Integer> ll1 = new LinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        System.out.println(ll);
       
        
        ll.descendingIterator().forEachRemaining(ll1::add);
        System.out.println(ll1);
    }
    
    public static void findSecondLargest()
    {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int highest = 0;
        int secondHighest = 0;
        
        for(int i:array)
        {
            if(i>highest)
            {
                secondHighest = highest;
                highest = i;  
            }
            else if(i > secondHighest)
            {
                secondHighest = i;
            }
        }
        
        
        
        System.out.println(highest);
    }
    
    public static void passByCopy(Boob b)
    {
        Boob bb = b;
        bb.quality = "saggy";   //manipuates the reference passed in 'b'
        System.out.println("in the method, the original boob is " + b.quality);
        System.out.println("in the method, the new reference to boob is " + bb.quality);
    }
    
    
    public static class Boob
    {
        String quality = "perky";
    }
    
    public static <T extends Comparable> void binarySearchGeneric(ArrayList list, T toFind)
    {
        //generic method accepts any generic type <T> that extends Comparable
        T result;
        List<T> shortList = list;
        Collections.sort(shortList);
        System.out.println("\n" + "*****************HEADER******************" );
        System.out.println("The thing to search is: " + toFind.toString());
        System.out.println("The list to search is:" + list.toString());
        System.out.println("Number of items in list: " + list.size());
        System.out.println("*****************SEARCH******************" );
        

        //
        if(toFind.compareTo(list.get(0)) <0 || toFind.compareTo(list.get(list.size()-1)) >0)
        { 
            System.out.println(toFind + " is not in this list");
            return;
        }      
        
        do
        {
            if(shortList.get(shortList.size()/2).compareTo(toFind)<0)
            {
                //search term is in upper half
                //split the list to top half
                System.out.println("Middle ("+shortList.get(shortList.size()/2)+") is lower than " + toFind);
                shortList = shortList.subList(shortList.size()/2,shortList.size());
                System.out.println("New List is: " + shortList.toString());
                System.out.println("New Middle is: " + shortList.get(shortList.size()/2));
                
            }
            if(shortList.get(shortList.size()/2).compareTo(toFind)>0)
            {
                //search term is in lower half
                //split the list to bottom half
                System.out.println("Middle ("+shortList.get(shortList.size()/2)+") is higher than " + toFind);
                shortList = shortList.subList(0,shortList.size()/2);
                System.out.println("New List is: " + shortList.toString());
                System.out.println("New Middle is: " + shortList.get(shortList.size()/2));
            }
        }
        while(shortList.get(shortList.size()/2).compareTo(toFind)!=0);
        
        result = shortList.get(shortList.size()/2);
        
        System.out.println("Result is: " + result.toString());
        System.out.println("*****************************************" );
    }
    
    public static void binaryTree()
    {
        //the way to get from one node to the next is via the pointer to the left or right child
        //if no child on a pointer, pointer value is null
        //each node consists of [pointer left][pointer right][data on node]
        
        //root node of tree
        BinaryTree btree = new BinaryTree(20);
        System.out.println("Root is " + btree.root.value);
        btree.addNodeSorted(15,btree.root);
        btree.addNodeSorted(17,btree.root);
        btree.addNodeSorted(3,btree.root);
        btree.addNodeSorted(10,btree.root);
        btree.addNodeSorted(2,btree.root);
        btree.addNodeSorted(11,btree.root);
        btree.addNodeSorted(21,btree.root);
        btree.addNodeSorted(25,btree.root);
        btree.addNodeSorted(11,btree.root);
        
        btree.displayTree(btree.root);
        //btree.findNodeByValue(3);
        //System.out.println("and has decendants " + btree.getDecendants(btree.findNodeByValue(3)));
        //btree.displayTree(btree.findNodeByValue(3));
        btree.deleteNodev2(3);
        //btree.findNodeByValue(10);
        btree.displayTree(btree.root);
        
    }
    
    public static void graph()
    {
        Graph graph = new Graph();        
        //sample data
        
        Vertice v1 = new Vertice("Chris");
        Vertice v2 = new Vertice("Maynard");
        Vertice v3 = new Vertice("Freya");
        Vertice v4 = new Vertice("Celeste");
        Vertice v6 = new Vertice("Zoe");
                
        graph.addVertice(v1);
        graph.addVertice(v2);
        graph.addVertice(v3);
        graph.addVertice(v4);
        graph.addVertice(v6);
        
        graph.AddEdge(v1, v2, 0);
        graph.AddEdge(v1, v3, 0);
        graph.AddEdge(v1, v4, 0);     
        
        graph.AddEdge(v2, v1, 0);
        graph.AddEdge(v2, v3, 0);
        graph.AddEdge(v2, v4, 0);
        
        graph.AddEdge(v3, v1, 0);
        graph.AddEdge(v3, v2, 0);
        graph.AddEdge(v3, v4, 0);
        graph.AddEdge(v3, v6, 0);
        
        graph.AddEdge(v4, v1, 0);
        graph.AddEdge(v4, v2, 0);
        graph.AddEdge(v4, v3, 0);
        
        graph.AddEdge(v6, v3, 0);
        
        graph.printGraph();
    }
    
    public static void lambda()
    {
        //lambda's can only be used in place of a single method functional interface call
        // (argument) -> { //body }
        
        
        JButton button = new JButton();
        button.addActionListener((var)-> System.out.println(":)")); 
        
        Integer[] nums = new Integer[]{1,2,3,4,5};    
        List<Integer> list = Arrays.asList(nums);
                
        list.forEach(num -> {
            System.out.println(num);
        });
        
        Consumer<Integer> printConsumer = new Consumer<Integer>(){
            public void accept(Integer num)
            {
                System.out.println(num);                
            }
        };
        
        list.forEach(printConsumer);
        
        button.addActionListener((event)-> graph());
        list.forEach(num->graph());
        
        list.forEach((num)->
                System.out.println(num)
        );
        
        Consumer<Integer> method;
        method = (n) -> {System.out.println("Something");};
        list.forEach(method);
        
        ActionListener action;
        action = (event) -> {graph();}; 
        
        LambdaInterface x = (s) -> s + "!";
        LambdaInterface y = (s) -> s + "?";
        lambdaMethod("Hello",x);
        lambdaMethod("Hello",y);
    }
    
    interface LambdaInterface
    {
        public String run(String str);
    }
    
    static void lambdaMethod(String s, LambdaInterface lm)
    {
        String result = lm.run(s);
        System.out.println(result);
    }
    
    static String reverseString(String str)
    {
        if(str==null)
        {
            throw new IllegalArgumentException("not a valid string");
        }
        else
        {
            char[] array = str.toCharArray();
            StringBuilder reversed = new StringBuilder();
            for(int x = array.length-1; x>-1;x--)
            {
                reversed.append(array[x]);
            }
            return reversed.toString(); 
        }
    }
    
    static void swapTwoNumbers(int a, int b)
    {
        System.out.println("Before");
        System.out.println("a =" + a);
        System.out.println("b =" + b);
        
        
        b = a + b; //a = 1, b = 3
        a = b - a; //a = 2, b = 3
        b = b - a; //b = 1, a = 2
        
        System.out.println("After");
        System.out.println("a =" + a);
        System.out.println("b =" + b);
    }
    
    static boolean checkVowels(String str)
    {
        if(str == null)
        {
            throw new IllegalArgumentException("Cant ne bull");
        }
        
        return str.toLowerCase().matches(".*[aeiou].*");
    }
        
        
    static boolean checkPrime(int num)
    {
        boolean isPrime = true;
        
        //need to get a list of integers
        
        for(int i=num;i<=Math.sqrt(num);i++)
        {
            if(num % i !=0)
            {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static int factorizer(int x)
    {
        int result = x;
        if(x<1 || x>=Integer.MAX_VALUE)
        {
            throw new IllegalArgumentException("Invalid integer given");           
        }
        else
        {
            do
            {
                x--;
               result = result*x; 
            }
            while(x>1);
            return result;
        }
    }
    
    public static int reverseFactorial(int x)
    {
            if(x!=(int)x) 
            {
               throw new IllegalArgumentException("Number is not an integer"); 
            }
            else
            {
                int result = x;
                int factor = 0;
                
                for(int i=1;result>1;i++)
                {
                    result = result/i;
                    factor = i;
                }
                
                return factor;
            } 
        }
    
    public static void binarySearch(int num, List array)
    {
        List<Integer> shortList = array;
        Collections.sort(array);
        System.out.println(array);
        if(num < shortList.get(0) | num>shortList.get(shortList.size()-1))
        {
            //number not in array
            System.out.println(num + " not in array");
            return;
        }
        else
        {
            if(num<shortList.get(shortList.size()/2))
            {
                shortList = shortList.subList(0, shortList.size()/2);
                binarySearch(num,shortList);
            }
            else if(num>shortList.get(shortList.size()/2))
            {
                shortList = shortList.subList(shortList.size()/2,shortList.size());
                binarySearch(num,shortList);
            }
            else if(num == shortList.get(shortList.size()/2))
            {
                System.out.println("found "+num+" at index "+shortList.indexOf(num));
            }
        }           
    }

    static void insertSort1(int[] array)
    {
        //on each iterate
        //checks the value against
        //the largest in the list
        //if larger - leave there
        //if smaller - move
        
        //start at 2nd element (i)
        int i = 1;
        //outer while loops over all elements except 1st
        while(i<array.length)
        {
            //declare inner iterator to be same as outer
            int j = i;
            //while current position is > 0
            //and while previous index > current index
            while(j>0 && array[j-1]> array[j])
            {
                //if previous index is a larger number than the current index
                //swap current and previous index
                //moving hte larger numbers to the right
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                //decememnt incrementor to evaluate pair to the left
                j--;
            }
            //increase incrementor to next pair fo indexes
            i++;
        }  
    }
    
    static void insertSort2(int[] array)
    {
        //incrementor for outer loop
        int outer = 1;
        //outter loop
        while(outer<array.length)
        {
            int inner = outer;
            //inner loop
            //while current pos is > 0
            //if previous index > current index
            //swap elements - moving largest to the right
            while(inner>0 && array[inner-1]>array[inner])
            {
                //swap elements
                //a = array[inner-1]
                //b = array[inner]
                //
                //b = a+b b=5
                //a = b-a a=3
                //b = b-a b=2
                //
                array[inner] = array[inner] + array[inner-1];
                array[inner-1] = array[inner]-array[inner-1];
                array[inner] = array[inner]-array[inner-1];
                //decrement inner, moving index left
                inner--;
            }
            //increment outter moving pairs to the right
            outer++;            
        }
    }
    
    static void insertSort3(int[] array)
    {
        //outer incrementor
        int i = 1;
        while(i<array.length)
        {
            //internal incrementor starting at the next position on each loop
            int j = i;
            while(j>0 && array[j-1]>array[j])
            {                
                //swap elements;
                //b = a+b = 5
                //a = b-a =5-2 =3
                //b = b-a =5-3=2
                array[j] = array[j-1]+array[j];
                array[j-1] = array[j]-array[j-1];
                array[j] = array[j]-array[j-1];
                //decrement inner - to evaluate pairs to the left until it reachest 1st element
                j--;
            }
            //increment outer to progress pair evaluation to the right          
            i++;
        }
        
        
        
        
        
        
        
        
    }

    static int factoriser2(int x)
    {
        int result = x;
        do
        {
            x--;
            result = result *x;
        }
        while(x>1);
        return result;
    }


        
        
}
