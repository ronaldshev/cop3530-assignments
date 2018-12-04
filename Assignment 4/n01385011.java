import javax.swing.*;
import java.util.Arrays;

// Main Program
class n01385011 {

   static int itemCount = 0; // total number of items 
   static int pos = 0; // position indicator in the "sack" array
   static int sack[] = new int[25]; // sack to hold items on right branches
   static int sack2[] = new int[25];

   public static void main(String[] args) {

   String sinput[] = new String[25]; // temp string array to hold parameters before     converting to integers
   int items[] = new int[25]; // array to hold the items
   int capacity = 0; // knapsack capacity
   String s = null; // temp string to hold user input

   while (true) { // infinite loop

      // Use a JOptionPane dialog to get the user's input
      s = JOptionPane.showInputDialog(new JFrame("Input Params"), "Please enter total weight, followed a list of item weights)","Run Parameters",JOptionPane.QUESTION_MESSAGE);

      if ((s == null) || (s.equals(""))) { // user pressed X, cancel or left it blank.
         System.exit(0);  // exit cleanly
      }

      sinput = s.split(" "); // split the parameters on the whitespace

      for (int i = 0; i < sinput.length; i++) { // iterate through the array and copy the elements to the correct variables
         if (i == 0) {
            capacity = Integer.parseInt(sinput[i], 10); // knapsack weight in the first position
         } else {
            items[i-1] = Integer.parseInt(sinput[i], 10); // the rest are item weights
         }
      }
     items = Arrays.copyOfRange(items, 0, sinput.length - 1); // truncate the items array to remove empty elements at the end

      knapSack(capacity, items); // call the knapsack method that will in turn call the recursive function
   }   
      }

   public static void knapSack(int capacity, int[] items) {

      itemCount = items.length; // keep track of original number of items

      recknapSack(capacity, items, 0); // start recursive calls
   }


   /*
      recursive knapsack method: called repeatedly to find the correct combinations of items such that their weights
  total to the max capacity that the knapsack can hold

      capacity: knapsack capacity
      items: array of items (weights)
      branch: flag indicating whether the call is a left branch (item not included) or right branch (item included)
         0 - initial call, non recursive
         1 - left branch, weight not included
         2 - right branch, weight included
   */
   public static int recknapSack(int capacity, int[] items, int branch) {
      //System.out.print("\nCap: " + capacity + " Items: " + Arrays.toString(items)); // recursive call tracking debugging

      /*if (capacity == 0){ // debugging - for breaking at certain points in the tree
         assert Boolean.TRUE; // set breakpoint on this line20 11 
      }*/


      // base cases - ends of the branches
      if (capacity == 0){ // sack is exactly full, item weights = total weight
            int sum = 0;
            /* for(int i = 0; i<sack2.length; i++){
               sum += sack2[i];
               if(sack2[i] == 0)
                  continue;
               else if(sum <= 20)
                  System.out.print(sack2[i] + ", ");
               else
                  break;
            }*/
            System.out.println(Arrays.toString(sack2));
            System.out.println("\t  -> good tree"); // debugging
            //JOptionPane.showMessageDialog(new JFrame("Results"), "The valid combinations are: ");
            Arrays.fill(sack2, 0);
            Arrays.fill(sack, 0); // clear the sack, this was a successful branch, will start again for another solution
            return capacity;
      } else if (capacity < 0) { // bag overloaded
            //System.out.print("\t  -> overload tree"); // debugging
            if (branch == 2) // if this is an "included" branch
               sack[--pos] = 0; // remove the last item placed in the sack
        return capacity;
           } else if (items.length == 0){ // out of items and/or capacity not reached
        //System.out.print("\t  -> empty src tree"); // debugging
        if (branch == 2)
           sack[--pos] = 0;
        return capacity;
   } else {

             int firstItem; // this the first item, it will either be discarded (not included) or placed in the sack array (included)
             firstItem = items[0];

             items = Arrays.copyOfRange(items, 1, items.length); // for either recursive branch: remove the first item from the list

             recknapSack(capacity, items, 1); // call recursive function, left branch, where item is discarded and not placed in sack

             // prepare for right branch, where item is placed in sack
             capacity -= firstItem; // subtract the left most item weight from from capacity
             int temp = pos;
             sack2[pos] = firstItem;
             sack[pos++] = firstItem; // place the item in the sack
             //System.out.println("First item " + firstItem);
             int ret = recknapSack(capacity, items, 2); // recursive right branch call, item is placed in sack, weight subtracted from capacity
             if(ret != 0)
             {
                 //System.out.println("Removing " + sack[temp] + " at position " + (temp));
                 sack[temp] = 0;
                 pos = temp;
             }


      }

  return capacity;
   }
}