package com.company;
/******************************************************************************************
Name: Thanh Le
Course:CS125-01 
Lab#: Lab One
Submission Date: 8:00pm, Wed (9/20)
Brief Description: Part 1 - Circle operation class - Declare radius, compute Diameter, 
Area and Circumfence based on the radius. 
********************************************************************************************/
public class RecursiveSum
{

    /***************************************************
     * Method for Computing Recursive Sum
     ***************************************************/
      public int calculateRecursiveSum(int numberAccepted)
      {
            if (numberAccepted == 0) {
                return numberAccepted;
            }
            return numberAccepted + calculateRecursiveSum(numberAccepted - 1);
      }
      
}