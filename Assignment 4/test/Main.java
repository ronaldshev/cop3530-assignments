import java.util.Stack;

class isThisGoingToWork {

    /** Set a value for target sum */
    public static final int TARGET_SUM = 50;

    private Stack<Integer> stack = new Stack<Integer>();

    /** Store the sum of current elements stored in stack */
    private int sumInStack = 0;

    public void populateSubset(int[] data, int fromIndex, int endIndex) {

        /*
        * Check if sum of elements stored in Stack is equal to the expected
        * target sum.
        * 
        * If so, call print method to print the candidate satisfied result.
        */
        if (sumInStack >= TARGET_SUM) {
            if(sumInStack == TARGET_SUM){
               System.out.println(stack);
            }
            return;
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (sumInStack + data[currentIndex] <= TARGET_SUM) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];

                /*
                * Make the currentIndex +1, and then use recursion to proceed
                * further.
                */
                populateSubset(data, currentIndex + 1, endIndex);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }

    /**
    * Print satisfied result. i.e. 15 = 4+6+5
    */

    /*private void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }*/
}

public class Main {

    private static final int[] DATA = {40, 30, 20, 10, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        isThisGoingToWork get = new isThisGoingToWork();
        get.populateSubset(DATA, 0, DATA.length);
    }
}