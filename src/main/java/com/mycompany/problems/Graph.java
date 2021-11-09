/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.problems;

import java.util.HashSet;

/**
 *
 * @author chris
 */
public class Graph 
{     
    //adjacency list
    //contains vertices and edges
    
    //weighted direct graph
    //HashSet of Vertices
    //Each Verticie has a name and a list of all its outgoing edges
    //Each edge has a weight and a destination vertice
    
    //contains the nodes in the graph
    HashSet<Vertice> nodes;
    
    public Graph()
    {
        nodes = new HashSet<Vertice>();
    }
    
    public void AddEdge(Vertice originVertice, Vertice destinationVertice, int weight)
    {
        //adds and edge between a the specified vertice and the given vertice
        originVertice.getEdges().add(new Edge(destinationVertice, weight));
    }
    
    public void addVertice(Vertice newVertice)
    {
        //adds the specified vertice to the graph
        nodes.add(newVertice);        
    }
    
    public void removeVertice(Vertice v)
    {
        //remove vertice from list hashset of vertice's
        nodes.remove(v);        
    }
    
    public void printGraph()
    {
        for(Vertice v:nodes)
        {
            //print vertice name
            System.out.println("Vertice: " + v.name);
            //then each of its edges
            for(Edge e:v.getEdges())
            {
                //print edge from-to
                System.out.println("# Edge to:" + e.destination.name);
                //white space
            }
            System.out.println("\n");
        }
    }
    
    
    public class Edge
    {
        //class variables
        int weight;
        Vertice destination;
        
        public Edge(Vertice destination, int weight)
        {
            this.weight = weight;
            this.destination = destination;
        }
        
        //contructor to use for unweighted graph
        public Edge(Vertice destination)
        {
            this.destination = destination;
            this.weight = 1; //all values are 1 for unweighted graph
        }
    }

}
