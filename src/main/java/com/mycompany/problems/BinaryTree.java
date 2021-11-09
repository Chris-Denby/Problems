/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.problems;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class BinaryTree 
{
    //the way to get from one node to the next is via the pointer to the left or right child
    //if no child on a pointer, pointer value is null
    //each node consists of [pointer left][pointer right][data on node]

    //root node of tree
    BinaryNode root;
    
    public BinaryTree(int value)
    {
        //sets value for root note
        root = new BinaryNode(value);
    }
    
    public void add(BinaryNode parent, int value)
    {
        //if value of the new child is lower or equal to the parent
        if(value < parent.value)
        {
            //insert as left child of parent
            parent.left = new BinaryNode(value);
            
        }
        //if the value of the new child is higher than the parent
        else if(value > parent.value)
        {
            //insert as right child of parent
            parent.right = new BinaryNode(value);
        }
    }
    
    public void displayTree(BinaryNode fromNode)
    {
        StringBuilder output = new StringBuilder();
        int level = 1;
        ArrayList <BinaryNode> children = new ArrayList<BinaryNode>();
             
        children.add(fromNode);
        output.append("L"+level+":      "+fromNode.value+"\n");
        level++;
        for(int x=0;x<children.size();x++)
        {
            
            output.append("L"+level+":");
            if(children.get(x).left != null)
            {
                children.add(children.get(x).left);
                output.append("     (L)"+children.get(x).left.value);
            }

            if(children.get(x).right != null)
            {
                children.add(children.get(x).right);
                output.append("     (R)"+children.get(x).right.value);
            }

            level++;
            output.append("\n");        
            
 
        }
        System.out.println(output);
    }
   
    
    int addLevel = 1;
    public void addNodeSorted(int value, BinaryNode currentNode)
    {
        addLevel ++;
        if(value > currentNode.value)
        {
            if(currentNode.left!=null)
            {

                //if node is a child, continue traversal
                addNodeSorted(value, currentNode.left);
            }
            else
            {
                //if node is a leaf, add new node
                currentNode.left = new BinaryNode(value);
                System.out.println(value + " added on level " + addLevel);
                addLevel = 1;
            } 
        }
        else if(value < currentNode.value)
        {
            if(currentNode.right!=null)
            {
                //if node is a child, continue traversal
                addNodeSorted(value, currentNode.right); 
            }
            else
            {
                //if node is a leaf, add new node
                currentNode.right = new BinaryNode(value);
                System.out.println(value + " added on level " + addLevel);
                addLevel = 1;
            }  
        }
        else if (value == currentNode.value)
        {
            addLevel = 1;
            return;
        }
    }
    
    public BinaryNode findNodeByValue(int value)
    {
        BinaryNode currentNode = root;
        //traverse the tree until matching element is found or a leaf node is reached
        
        while(currentNode != null)
        {
            if(value == currentNode.value)
            {
                System.out.println(value + " found!");
                //System.out.println("nodes left is " + currentNode.left.value);
                //System.out.println("Nodes right is " + currentNode.right.value);
                return currentNode;
            }
            else if(value > currentNode.value)
            {
                //if searched value is less than current node - move to left child
                currentNode = currentNode.left;            
            }
            else if(value < currentNode.value)
            {
                //if searched value is greater than current node - move to right child
                currentNode = currentNode.right;
            }   
        }
        System.out.println(value + " not found..."); 
        return null;
    }
    
        public void deleteNode(int value)
    {
        
        
        //find node to delete
        BinaryNode nodeToDelete = findNodeByValue(value);
        
        //perform action on node to delete
        if(nodeToDelete != null)
        {
            nodeToDelete = null;
            findNodeByValue(3);
        }
            /**
            System.out.println("I will delete " + nodeToDelete.value);
            
            //if node has no children
            if(nodeToDelete.left == null & nodeToDelete.right == null)
            {
                //make node null
                nodeToDelete = null;
                System.out.println("Leaf deleted");
                return;
            }
            else
            {   
                //replace node with a new node with same value but no children;
                nodeToDelete = new BinaryNode(nodeToDelete.value);
                nodeToDelete = null;
                //children have been removed                
            }
            **/
            
            
            
            
            /**
            else
            //if node has a left child but no right
            if(nodeToDelete.left != null & nodeToDelete.right == null)
            {
                nodeToDelete = null;
                System.out.println("Node delete");
            }
            else
            //if node has a right child but no left
            if(nodeToDelete.left == null & nodeToDelete.right != null)
            {
                nodeToDelete = null;
                System.out.println("Node delete");
            }
            else
            //if node has both left and right children
            if(nodeToDelete.left != null & nodeToDelete.right != null)
            {
                nodeToDelete = null;
                System.out.println("Node delete");
                //then all trailing nodes get re-added
            }
            **/
            
        
    }
        
    public void deleteNodev2(int value)
    {
         BinaryNode currentNode = root;
        //traverse the tree until matching element is found or a leaf node is reached
        
        while(currentNode != null)
        {
            if(currentNode.left != null && value > currentNode.left.value)
            {
                //if searched value is less than current node - move to left child
                currentNode = currentNode.left;            
            }
            else if(currentNode.right != null && value < currentNode.right.value)
            {
                //if searched value is greater than current node - move to right child
                currentNode = currentNode.right;
            }  
            else if(currentNode.left != null && value == currentNode.left.value)
            {                
                System.out.println("Node found");
                ArrayList<BinaryNode> nodes = new ArrayList<BinaryNode>();
                nodes = this.getDecendants(currentNode.left);
                currentNode.left = null;
                for(BinaryNode n:nodes)
                {
                    this.addNodeSorted(n.value, currentNode);
                }
                System.out.println("Node deleted...");
                return;
            }
            else if(currentNode.right != null && value == currentNode.right.value)
            {
                System.out.println("Node found");
                ArrayList<BinaryNode> nodes = new ArrayList<BinaryNode>();
                nodes = this.getDecendants(currentNode.right);
                currentNode.right = null;
                for(BinaryNode n:nodes)
                {
                    this.addNodeSorted(n.value, currentNode);
                }
                System.out.println("Node deleted...");
                return;               
            }
            else
            {
                System.out.println("Cant delete" + value);
                return;
            }
        } 
        
    }
    
    public ArrayList<BinaryNode> getDecendants(BinaryNode fromNode)
    {
        ArrayList <BinaryNode> children = new ArrayList<BinaryNode>();
        children.add(fromNode);
        for(int x=0;x<children.size();x++)
        {
            //add found children to list
            //iterate through each child in the list and add their children
            //until no more children found
            if(children.get(x).left != null)
            {
                children.add(children.get(x).left);
            }

            if(children.get(x).right != null)
            {
                children.add(children.get(x).right);
            } 
        }
        //remove root node
        children.remove(0);
        return children;
    }
    
    public void insertNode(int value)
    {
        //
        
    }
    
    public class BinaryNode 
    {
        //nodes data value
        int value;

        //reference to child nodes (pass by reference)
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int value)
        {
            this.value = value;
            left = null;
            right = null;
        }
        
        @Override
        public String toString()
        {
            return ""+value;
        }
    } 
}


