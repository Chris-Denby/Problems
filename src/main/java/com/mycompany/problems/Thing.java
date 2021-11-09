/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.problems;

/**
 *
 * @author chris
 */
public class Thing implements Comparable
{
    String name = "bob";
    
    public Thing(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    

    @Override
    public int compareTo(Object  o) 
    {
        Thing other = (Thing) o;
        return name.compareToIgnoreCase(other.name);        
    }
    
}
