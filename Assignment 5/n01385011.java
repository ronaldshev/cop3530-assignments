// ronald shevchenko
// n01385011
// assignment 5
import java.io.*;
import java.util.*;               

class Node{
   public char charData;
   public int repeatData;
   public String pathData;
   public Node leftChild;        
   public Node rightChild;      
   
}

class PriorityQueue{
   private int maxSize;
   private Node[] queArray;
   private Node[] encodedArray;
   private int nItems;
   private int k;
   
   public PriorityQueue(int s){
      maxSize = s;
      queArray = new Node[maxSize];
      encodedArray = new Node[maxSize+1];
      nItems = 0;
   }
   
   public Node insert(char cd, int rp, String pd){
      Node newNode = new Node();
      newNode.charData = cd;
      newNode.repeatData = rp;
      newNode.pathData = pd;
      
      int j;
      if (nItems == 0)
         queArray[nItems++] = newNode;
      else{
         for(j = nItems - 1; j >= 0; j--){
            if(newNode.repeatData > queArray[j].repeatData)
               queArray[j+1] = queArray[j];
            else
               break;
         }
         queArray[j+1] = newNode;
         nItems++;
      }
      return newNode;
   }
   
   public void printQueue(){
      for(int i = 0; i < nItems; i++)
         System.out.println(queArray[i].repeatData + ", " + queArray[i].charData);
   }
   
   public void printArray(){
      for(int i = 0; i < k; i++)
         System.out.println(encodedArray[i].charData + ", " + 
            encodedArray[i].repeatData + ", " + encodedArray[i].pathData);
   }
   
   public boolean isEmpty(){
      return (nItems==1);
   }
   
   public Node remove(){
      return queArray[--nItems];
   }
   
   public int treeAlgorithm(Tree theTree){
      Node removeOne = remove();
      if(removeOne.charData != '*')
         encodedArray[k++] = removeOne;
      Node removeTwo = remove();
      if(removeTwo.charData != '*')
         encodedArray[k++] = removeTwo;
      
      int combine = removeOne.repeatData + removeTwo.repeatData;
      Node combined = insert('*', combine, "");
      theTree.insert(combined, removeOne, removeTwo);

      //System.out.println("Combined: " + combine + "\n");
      return combine;
   }
   
  public void printString(String toPrint){
      for(int i = 1; i < toPrint.length(); i++){
            System.out.print(toPrint.charAt(i-1));
         if(i % 8 == 0)
            System.out.print(" ");
         if(i % 24 == 0)
            System.out.println();
      }
   }
   
   public String encode(String input){
      String encoded = "";
      
      for(int i = 0; i < input.length(); i++){
         for(int j = 0; j < encodedArray.length-1; j++){
            if(encodedArray[j].charData == input.charAt(i)){
               encoded += encodedArray[j].pathData;
            }
         }
      }
      //encoded = encoded.replaceAll("(.{8})(?!$)", "$1 ");
      return encoded;//.replaceAll("(.{24})(?!$)", "$1\n");
   }
   
   public String decode(String bitString){
      String decoded = "";
      
      for(int i = 0; i < bitString.length(); i++){
         if(!getChar(bitString.substring(0, i + 1)).equals("")){
            decoded += getChar(bitString.substring(0, i + 1));
            bitString = bitString.substring(i + 1);
            i = 0;
          }
       }
       return decoded;
   }
   
   public String getChar(String bits){
      String character = "";
      
      for(int i = 0; i < encodedArray.length - 1; i++){
         if(encodedArray[i].pathData.equals(bits))
            character = encodedArray[i].charData + "";
      }
      return character;
   }
}

class Tree{
   private Node root;             

   public Tree()                  
      { root = null; }            
      
   public void insert(Node combined, Node removeOne, Node removeTwo){
      combined.leftChild = removeOne;
      combined.rightChild = removeTwo;
      root = combined;
   }

   public void traverse(){
      preOrder(root, "");
      }

   private void preOrder(Node localRoot, String pd){
      if(localRoot != null){
         if(localRoot.leftChild == null && localRoot.rightChild == null){
            System.out.println(localRoot.charData + ": " + pd);
            localRoot.pathData = pd;
            return;
         }
         preOrder(localRoot.leftChild, pd + "0");
         preOrder(localRoot.rightChild, pd + "1");
         }
      }

   public void displayTree(){
      Stack globalStack = new Stack();
      globalStack.push(root);
      int nBlanks = 32;
      boolean isRowEmpty = false;
      System.out.println(
      "......................................................");
      while(isRowEmpty==false)
         {
         Stack localStack = new Stack();
         isRowEmpty = true;

         for(int j=0; j<nBlanks; j++)
            System.out.print(' ');

         while(globalStack.isEmpty()==false)
            {
            Node temp = (Node)globalStack.pop();
            if(temp != null)
               {
               System.out.print(temp.charData);
               localStack.push(temp.leftChild);
               localStack.push(temp.rightChild);

               if(temp.leftChild != null ||
                                   temp.rightChild != null)
                  isRowEmpty = false;
               }
            else
               {
               System.out.print("__");
               localStack.push(null);
               localStack.push(null);
               }
            for(int j=0; j<nBlanks*2-2; j++)
               System.out.print(' ');
            }  
         System.out.println();
         nBlanks /= 2;
         while(localStack.isEmpty()==false)
            globalStack.push( localStack.pop() );
         }  
      System.out.println(
      "......................................................\n");
      }

   }

public class n01385011{
   public static void main(String[] args) throws IOException, FileNotFoundException{
      Scanner x = new Scanner(new File(args[0]));
            
      char value;
      String encoded = "";
      
      Tree theTree = new Tree();
      PriorityQueue thePQ = new PriorityQueue(7);

      String info = x.nextLine();

      while(true)
         {
         System.out.print("\nEnter a, b, c, or d: ");
         int choice = getChar();
         switch(choice)
            {
            case 'a':
               int countA = 0, countB = 0, countC = 0, countD = 0, 
               countE = 0, countF = 0, countG = 0;
               
               String side = "";
               
               for(int i = 0; i < info.length(); i++){
                  if(info.charAt(i) == 'A')
                     countA++;
                  else if(info.charAt(i) == 'B')
                     countB++;
                  else if(info.charAt(i) == 'C')
                     countC++;
                  else if(info.charAt(i) == 'D')
                     countD++;
                  else if(info.charAt(i) == 'E')
                     countE++;
                  else if(info.charAt(i) == 'F')
                     countF++;
                  else if(info.charAt(i) == 'G')
                     countG++;
               }
               
               //System.out.println(countA + ", " + countB + ", " + countC + ", " 
               //   + countD + ", " + countE + ", " + countF + ", " + countG + ".");
               
               thePQ.insert('A', countA, side);
               thePQ.insert('B', countB, side);
               thePQ.insert('C', countC, side);
               thePQ.insert('D', countD, side);
               thePQ.insert('E', countE, side);
               thePQ.insert('F', countF, side);
               thePQ.insert('G', countG, side);
               //thePQ.printQueue();
               
               while(!thePQ.isEmpty()){
                  thePQ.treeAlgorithm(theTree);
                  //thePQ.printQueue();
               }
               
               theTree.displayTree();
               break;
            case 'b':
               System.out.println("\nEncoded using preorder.");
               theTree.traverse();
               break;
            case 'c':
               //thePQ.printArray();
               encoded = thePQ.encode(info);
               thePQ.printString(encoded);
               break;
            case 'd':
               System.out.println(thePQ.decode(encoded));
               break;
            default:
               System.out.print("Invalid entry\n");
            }  
         } 
      }  

   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }

   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }

   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
   }  