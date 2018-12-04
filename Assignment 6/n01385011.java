// ronald shevchenko
// n01385011
import java.io.*;
import java.util.*;

class DataItem {
   private String data;
   private int val;
   
   public DataItem(String ii){
      if(ii != "-1"){
         String[] part = ii.split("(?<=\\D)(?=\\d)");
         if(part.length == 1){
            data = part[0];
            data = data.trim();
         }
         else{
            data = part[0];
            data = data.trim();
            val = Integer.parseInt(part[1]);
         }
      }
      else{
         data = ii;
      }
   }
     
   public String getKey(){
      if(data == null)
         return null;
      else
         return data; 
   }
   
   public int getVal(){
      return val;
   }
   
   public String setKey(String h){
      data = h;
      return data;
   }
}

class HashTable{
   private DataItem[] hashLinear;
   private DataItem[] hashQuadratic;
   private int arraySize;
   private DataItem nonItem;
   
   public HashTable(int size){
      arraySize = getPrime(2*size);
      hashLinear = new DataItem[arraySize];
      hashQuadratic = new DataItem[arraySize];
      nonItem = new DataItem("-1");
   }
   
   private int getPrime(int min){
      for(int j = min+1; true; j++)
         if(isPrime(j))
            return j;
   }
   private boolean isPrime(int n){
      for(int j = 2; (j*j <= n); j++)
         if(n % j == 0)
            return false;
      return true;
   }
      
   public int hash(String key){
      char oneChar;
      int hashVal = 0;
      
      if(key.length() > 0 && key.charAt(0) != '\n'){
         oneChar = key.charAt(0);
         key = key.substring(1);
         hashVal = ((int)oneChar) % arraySize;
      }  
      while(key.length() > 0){
         oneChar = key.charAt(0);
         key = key.substring(1);
         if(oneChar != '\n'){
            hashVal = (hashVal * 26 + (int)oneChar) % arraySize;
         }
      }
      return hashVal;
   }
   
   public void insertLinear(DataItem item){
      String key = item.getKey();
      int hashVal = hash(key);
      
      if(hashLinear[hashVal] == null){
         hashLinear[hashVal] = item;
         System.out.println("stored " + item.getKey() + " " + item.getVal() + " at location " + hashVal);
      }
      else{
         while(hashLinear[hashVal] != null && hashLinear[hashVal].getKey() != "-1" && !(hashLinear[hashVal].getKey().equals(item.getKey()))){
            ++hashVal;
            hashVal %= arraySize;
         }
         if(hashLinear[hashVal] == null){
            hashLinear[hashVal] = item;
            System.out.println("stored " + item.getKey() + " " + item.getVal() + " at location " + hashVal);
         }
         else if(hashLinear[hashVal].getKey().equals(item.getKey())){
            System.out.println("ERROR " + item.getKey() + " already exists at location " + hashVal);
            return;
         }  
      }
   }
  
   public int[] searchLinear(String key){
      int i = hash(key);
      int h = 1;
      int[] b = new int[3];
      
      while(hashLinear[i] != null){
         if(hashLinear[i].getKey().equals(key)){
            b[0] = 1;
            b[1] = i;
            b[2] = hashLinear[i].getVal();
            return b;
         } 
         i = (i + 1) % (arraySize);
      }
      b[0] = -1;
      b[1] = i;
      return b;
   }
   
   public int[] removeLinear(String key){
      int[]  b = searchLinear(key);
         if(b[0] == -1)
            return b;
            
      int i = hash(key);
      int probeLength = 1;
      
      while(!key.equals(hashLinear[i].getKey())){
         i = (i + 1) % (arraySize);
         probeLength++;
      }
      b[1] = probeLength;
      hashLinear[i] = nonItem;
      return b;
   }
}

class n01385011{
   public static void main(String[] args) throws IOException{
      DataItem aDataItem;
      int size = 0;
      String current;
      DataItem dI;
      
      Scanner x = new Scanner(new File(args[0])); //finding size of array
      while(x.hasNext()){
         x.nextLine();
         size++;
      }
      
      HashTable hashTable = new HashTable(size); //creates hashtable
      
      x = new Scanner(new File(args[0]));
      while(x.hasNext()){
         current = x.nextLine();
         aDataItem = new DataItem(current);
         if(aDataItem.getVal() == 0){
            int[] s = hashTable.searchLinear(aDataItem.getKey());
            if(s[0] == 1)
               System.out.println("Found " + aDataItem.getKey() + " at location " + s[1] + " with value " + s[2]);
            else
               System.out.println("ERROR " + aDataItem.getKey() + " not found");
         }
         else
            hashTable.insertLinear(aDataItem);
      }
      
      //hashTable.displayTableIns();
   }           
}