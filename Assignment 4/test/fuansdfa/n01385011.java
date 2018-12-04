// ronald shevchenko
// n01385011
// knapsack assignment

import java.util.Arrays;
import java.util.Stack;
import javax.swing.*;
import java.io.*;

public class n01385011{
   public static int capacity = 0;

   public static void main(String[] args){
      Knapsack knapsack = new Knapsack();
      
      while (true){
         String input[] = new String[25];
         int items[] = new int[25];
         String inputString = null;
         inputString = JOptionPane.showInputDialog("Enter the first digit as total weight, and the following digits as all possible weights");
         if ((inputString == null) || (inputString.equals("")))
            System.exit(0);
  
         input = inputString.split(" ");
   
         for (int i = 0; i < input.length; i++){
            if (i == 0)
               capacity = Integer.parseInt(input[i], 10);
            else
               items[i-1] = Integer.parseInt(input[i], 10);
         }
        
         items = Arrays.copyOfRange(items, 0, input.length - 1);
         knapsack.populateSubset(items, 0, items.length, capacity);
         System.out.println("----------------------");
      }
   }   
}

class Knapsack extends n01385011{
    private Stack<Integer> correctWeights = new Stack<Integer>();

    private int sumInStack = 0;

    public void populateSubset(int[] data, int start, int end, int capacity){
        if (sumInStack >= capacity){
            if(sumInStack == capacity){
               System.out.println(correctWeights);
            }
            return;
        }

        for (int current = start; current < end; current++){
            if (sumInStack + data[current] <= capacity){
                correctWeights.push(data[current]);
                sumInStack += data[current];
                
                populateSubset(data, current + 1, end, capacity);
                sumInStack -= (Integer) correctWeights.pop();
            }
        }
    }
}