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
    public class Vertice
    {
        //name of object the Vertice represents
        String name;
        int value;   
        
        //Vertice contains a list of its outgoing edges
        ArrayList<Graph.Edge> verticeEdges;
        
        //public Vertice(){}
        
        public Vertice(String name, int value)
        {
            verticeEdges = new ArrayList();
            this.name = name;
            this.value = value;
        }
        
        public Vertice(String name)
        {
            verticeEdges = new ArrayList();
            this.name = name;
        }
        
        public ArrayList<Graph.Edge> getEdges()
        {
            return verticeEdges;
        }
    }
