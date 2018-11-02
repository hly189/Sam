package com.company;
/******************************************************************************************
Name: Thanh Le
Course:CS125-01 
Lab#: Lab One
Submission Date: 8:00pm, Wed (9/20)
Brief Description: Part 1 - Circle operation class - Declare radius, compute Diameter, 
Area and Circumfence based on the radius. 
********************************************************************************************/
public class Circle
{
	
    private double radius;


    /****************************************************
     * A accessor method for returning the radius field.
     ****************************************************/
     public double getRadius ()
     {
          return radius;
     }

    /****************************************************
     * Method for setting the radius field.
     ****************************************************/
     public void setRadius (double radius) // A mutator method for setting the radius field.
     {
      	  this.radius = radius;
     }
    /***************************************************
     * Method for computing Area
     ***************************************************/
     public double computeArea()
     {
            return radius * Math.PI * radius; // Returning calculation of Area
     }
    /***************************************************
     * Method for Computing Diameter
     ***************************************************/
      public double computeDiameter()
      {
    	    return radius * 2;            //Returning calculation of diameter
      }
    /***************************************************
     * Method for Computing Circumference
     ***************************************************/
      public double computeCircumference()
      {
 	        return radius * 2 * Math.PI ;  //Returning Calculation  of Circumference
      }
      
}