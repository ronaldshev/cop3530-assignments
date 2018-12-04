import java.util.Stack;
import java.io.*;
import javax.swing.*;
import java.util.Arrays;

public class n01385011{
   public static int capacity = 0;

   public static void main(String[] args){
      Knapsack get = new Knapsack();
      String sinput[] = new String[25];
      int items[] = new int[25];
      String s = null;
   
      while (true) {
   
         s = JOptionPane.showInputDialog(new JFrame("Input Params"), "Please enter total weight, followed a list of item weights)","Run Parameters",JOptionPane.QUESTION_MESSAGE);
   
         if ((s == null) || (s.equals("")))
            System.exit(0);
   
         sinput = s.split(" ");
   
         for (int i = 0; i < sinput.length; i++){
            if (i == 0){
               capacity = Integer.parseInt(sinput[i], 10);
            } else {
               items[i-1] = Integer.parseInt(sinput[i], 10);
            }
         }
        items = Arrays.copyOfRange(items, 0, sinput.length - 1);
       get.populateSubset(items, 0, items.length, capacity);
      }
    }   
}

class Knapsack extends n01385011{
    private Stack<Integer> stack = new Stack<Integer>();

    private int sumInStack = 0;

    public void populateSubset(int[] data, int fromIndex, int endIndex, int capacity){
        if (sumInStack >= capacity){
            if(sumInStack == capacity){
               System.out.println(stack);
            }
            return;
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++){
            if (sumInStack + data[currentIndex] <= capacity){
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];
                
                populateSubset(data, currentIndex + 1, endIndex, capacity);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }
}