import java.io.*;
import java.lang.*;
import java.util.*;

public class n00935124{

   public static void main(String[] args)throws IOException{
   
      if(args.length==0)
      {
         System.out.println("file names are missing");
         System.exit(0);
      }
   
      BufferedReader br = new BufferedReader(new FileReader(args[0]));
      String line;
      int count = 0;
      
      while((line = br.readLine())!= null){
         count++;
      }
      br.close();
      
      int hashVal = hornerRule(2 * count);
      System.out.println("Prime:" + hashVal);
      
      String[] arrayA = new String[hashVal];
      int[] probeArray = new int[hashVal];
      
      String[] arrayB = new String[hashVal];
      int[] probeArrayB = new int[hashVal];
      
      br = new BufferedReader(new FileReader(args[0]));
      
      while((line = br.readLine())!= null){
      
      addA(line, arrayA, probeArray);
      addB(line, arrayB, probeArrayB);
      
      }
      br.close();
      System.out.println("----------");
      System.out.println("Array A");
      System.out.println("-------------------------------------------------------------");
      System.out.println(String.format("%-5s %-40s %-16s","Index","String","|PL for insert|"));
      
      double probelen = 0;
      double cnt = 0;
      
      for(int i = 0; i < hashVal; i++){
      
         if(arrayA[i]!= null){
            System.out.println(String.format("%-5d %-40s %7d",i,arrayA[i],probeArray[i]));
            probelen += probeArray[i];
            cnt++;
         }
      }
      System.out.println(" ");
      System.out.println("Average probe length:"+" "+ probelen/cnt);
      System.out.println("-------------------------------------------------------------"); 
      
      probelen = 0;
      cnt = 0;
      
      System.out.println("Array B"); 
      System.out.println("-------------------------------------------------------------");
      System.out.println(String.format("%-5s %-40s %-16s","Index","String","|PL for insert|"));
      
      for(int i = 0; i < hashVal; i++){
         if(arrayB[i]!= null){
         
            System.out.println(String.format("%-5d %-40s %7d",i,arrayB[i],probeArrayB[i]));
            probelen += probeArrayB[i];
            cnt++;
         }
      }
      System.out.println(" ");
      System.out.println("Average probe length:"+" "+ probelen/cnt);
      System.out.println("-------------------------------------------------------------"); 
      System.out.println("\n\nSEARCHING");
      System.out.println("-------------------------------------------------------------");
      
      //Searching 2nd file strings in array a
      
      br = new BufferedReader(new FileReader(args[1]));
      System.out.println("Array A using Linear Probing");
      System.out.println(String.format("%-40s %9s %-9s %-14s %-14s","String","|Success|","|Failure|","|PL for success|","|PL for failure|"));
      
      double probelenScc = 0;
      double probelenFail = 0;
      double cntScc = 0;
      double cntFail = 0;
      
      while((line=br.readLine())!= null){
         int[] t = searchLP(line, arrayA);
         if(t[0] == 1){
            System.out.println(String.format("%-40s %9s %6s %14d %12s",line,"yes","",t[1],""));
            probelenScc += t[1];
            cntScc++;
         }else{
            System.out.println(String.format("%-40s %9s %6s %14s %12d",line," ","yes"," ",t[1]));
            probelenFail += t[1];
            cntFail++;
         }
      }
      br.close();
      
      if(cntScc!= 0 && cntFail!= 0)
         System.out.println(String.format("%-40s %9s %6s %14f %12f","Average Probe length:","","",(probelenScc/cntScc),(probelenFail/cntFail)));
         System.out.println("-------------------------------------------------------------");
         
      br = new BufferedReader(new FileReader(args[1]));
      System.out.println("Array B using Quadratic Probing");
      System.out.println(String.format("%-40s %9s %-9s %-14s %-14s","String","|Success|","|Failure|","|PL for success|","|PL for failure|"));
      probelenScc = 0;
      probelenFail = 0;
      cntScc = 0;
      cntFail = 0;
      
      while((line = br.readLine())!=null){
         int[] t = searchQP(line,arrayB);
         if(t[0] == 1){
            System.out.println(String.format("%-40s %9s %6s %14d %12s",line,"yes","",t[1],""));
            probelenScc += t[1];
            cntScc++;
         
         }else{        
            System.out.println(String.format("%-40s %9s %6s %14s %12d",line," ","yes"," ",t[1]));
            probelenFail += t[1];
            cntFail++;
         }
      }
      br.close();
      
      if(cntScc!=0 && cntFail!=0)
         System.out.println(String.format("%-40s %9s %6s %14f %12f","Average Probe length:","","",(probelenScc/cntScc),(probelenFail/cntFail)));
         
         System.out.println("\n\nDELETING");
         System.out.println("-------------------------------------------------------------");
         
         //Deleting Array A
         
         br = new BufferedReader(new FileReader(args[2]));
         System.out.println("Array A using Linear Probing");
         System.out.println("");
         System.out.println(String.format("%-40s %9s %-9s %-14s %-14s","String","|Success|","|Failure|","|PL for success|","|PL for failure|"));
         probelenScc = 0;
         probelenFail = 0;
         cntScc = 0;
         cntFail = 0;
      
         while((line = br.readLine())!=null){ 
            int[] t = removeLP(line, arrayA);
            if(t[0] == 1){
            System.out.println(String.format("%-40s %9s %6s %14d %12s",line,"yes","",t[1],""));
            probelenScc += t[1];
            cntScc++;
         
         }else{
         
            System.out.println(String.format("%-40s %9s %6s %14s %12d",line," ","yes"," ",t[1]));
            probelenFail += t[1];
            cntFail++;
         }
      }
      br.close();
      
      if(cntScc!=0 && cntFail!=0)
         System.out.println(String.format("%-40s %9s %6s %14f %12f","Average Probe length:","","",(probelenScc/cntScc),(probelenFail/cntFail)));
         System.out.println("-------------------------------------------------------------");
       
      //Deleting Array B     
      br = new BufferedReader(new FileReader(args[2]));
         System.out.println("Array B using Quadratic Probing");
         System.out.println("");
         System.out.println(String.format("%-40s %9s %-9s %-14s %-14s","String","|Success|","|Failure|","|PL for success|","|PL for failure|"));
         probelenScc = 0;
         probelenFail = 0;
         cntScc = 0;
         cntFail = 0;
      
         while((line = br.readLine())!=null){ 
            int[] t = removeQP(line, arrayB);
            if(t[0] == 1){
            System.out.println(String.format("%-40s %9s %6s %14d %12s",line,"yes","",t[1],""));
            probelenScc += t[1];
            cntScc++;
         
         }else{
         
            System.out.println(String.format("%-40s %9s %6s %14s %12d",line," ","yes"," ",t[1]));
            probelenFail += t[1];
            cntFail++;
         }
      }
      br.close();
      
      if(cntScc!=0 && cntFail!=0)
         System.out.println(String.format("%-40s %9s %6s %14f %12f","Average Probe length:","","",(probelenScc/cntScc),(probelenFail/cntFail)));
         System.out.println("-------------------------------------------------------------");

   
     
   }
   //Horners Rule
   
   public static int hornerRule(String key, int n){
      char oneChar;
      int hash = 0;
      
      if(key.length() > 0 && key.charAt(0) != '\n'){
         oneChar = key.charAt(0);
         key = key.substring(1);
         hash = ((int)oneChar) % n;
      }  
      while(key.length() > 0){
         oneChar = key.charAt(0);
         key = key.substring(1);
         if(oneChar != '\n'){
            hash = (hash*26+(int)oneChar)%n;
         }
      }
      return hash;
   }
   
   // Prime Number Checker
   
   public static int primeNum(long pN){
   
      //Is it a multiple of 2?
      if(pN % 2 == 0)
         return 0;
         
      //If not check the odds
      for(int i = 3; i <= Math.sqrt(pN); i += 2){
         if(pN % i == 0)
            return 0; 
      }
      return 1;
   }
   
   //Prime number greater than pN
   
   public static int hornerRule(int pN){
   
      if(pN == 0)
         return 2;
      if(pN%2 == 0)
         pN++;
      else
         pN += 2;
      
      while(true){   
         if(primeNum(pN)== 1){
            return pN;
         }      
         pN += 2;
      }
   }
   
   //Inserting using Linear Probing for array A
   
   public static void addA(String key, String[] arrayA, int[] probeArray){
      
      int probe;
      int cntProbe = 1;
      int cde = hornerRule(key, arrayA.length);
      
      if(arrayA[cde] == null){
         arrayA[cde] = key;
         probeArray[cde] = cntProbe;
         probe = -1;
         
      }else{
      
         if(cde == (arrayA.length - 1)){
            cntProbe++;
            probe = 0;
         
         }else{
            cntProbe++;
            probe = cde +1;
         }
      }
      
      while((probe != -1) && (probe != cde)){
      
         if(arrayA[probe] == null){
            arrayA[probe] = key;
            probeArray[probe] = cntProbe;
            probe = -1;
            
         }else{
         
            if(probe == (arrayA.length - 1)){
               cntProbe++;
               probe = 0;
               
            }else{
               cntProbe++;
               probe++;
            }
         }
      }
   }
   
   //Searching Linear Probing
   
   public static int[] searchLP(String key, String[] arrayA){
   
      int i = hornerRule(key, arrayA.length);
      int h = 1;
      int cntProbe = 1;
      int[] b = new int[2];
      
      while(arrayA[i] != null){
      
         if(arrayA[i].equals(key)){
         
            b[0] = 1;
            b[1] = cntProbe;
         
            return b;
         } 
         i = (i + 1) % (arrayA.length);
         cntProbe++;
      }
      b[0] = -1;
      b[1] = cntProbe;
      
      return b;
   }
   
   //Deleting using Linear Probing
   
   public static int[] removeLP(String key, String[] arrayA){
      int[]  b = searchLP(key, arrayA);
      
         if(b[0] == -1)
         return b;
      
      int i = hornerRule(key, arrayA.length);
      int cntProbe = 1;
      
      while(!key.equals(arrayA[i])){
      
         i = (i + 1) % (arrayA.length);
         cntProbe++;
      }
      
      b[1] = cntProbe;
      arrayA[i] = "";
      
      return b;
   }     
   
   //Inserting using Quadratic Probing for Array B
   
   public static void addB(String key, String[] arrayB, int[] probeArrayB){
   
      int temp = hornerRule(key, arrayB.length);
      int i = temp;
      int h = 1;
      
      do{
         if(arrayB[i] == null){
            arrayB[i] = key;
            probeArrayB[i] = h;
            
            return;
         }
         
         
         i = (temp + h * h++) % arrayB.length;
         
         
      }while(true);
   }
   
   
   //Searching using Quadratic Probing for Array B
   
   public static int[] searchQP(String key, String[] arrayB){
      int i = hornerRule(key, arrayB.length);
      int h = 1;
      int cntProbe = 1;
      int[] t = new int[2];
      
      while(arrayB[i] != null){
         if(arrayB[i].equals(key)){
            t[0] = 1;
            t[1] = cntProbe;
            
            return t;
         }
         
         i = (i + h * h++) % (arrayB.length);
         cntProbe++;
      }
      
      t[0] = -1;
      t[1] = cntProbe;
      return t;
   }
   
   public static int[] removeQP(String key, String[] arrayB){
      int[] t = searchQP(key,arrayB);
      
      if(t[0] == -1)
         return t;
         
      int i = hornerRule(key, arrayB.length);
      int cntProbe = 1;
      int h = 1;
      
      while(!key.equals(arrayB[i])){
      
         i = (i + h*h++) % (arrayB.length);
         cntProbe++;
      }
      
      t[1] = cntProbe;
      arrayB[i] = null;
      return t;
   }
}      
      
         
