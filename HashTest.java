// File: HashTest.java 

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**********************************************************************
* This class is a homework assignment #03;
**********************************************************************/
// use HashBag.java; 


/**
 * class HashTest which tests HashBag class and works with Hash tables
 * HW-03, CS3
 * @author Heidi Fritz
 * @version Mar 4, 2015
 */
public class HashTest
{
    public static final int H=100;
    public static final int M=10;
  
    public static void main(String[] args) throws FileNotFoundException{


        
       //******************************************************************
       // (1) Generate a HASH TABLE randomly:
       //******************************************************************
	   
		   
	   HashBag hb = new HashBag(H);   
	   // Generate Hash table and write to a text file "dataS.txt" 
	   try {
	  		 
	  	      File file = new File("dataS.txt");
	  	      String formatStr = "%09d%n";
	  	      
	  	      if (file.createNewFile())
	  	      {
	  	    	  System.out.println("Writing random SSNs to file: ");
	  	      }
	  	      else
	  	      {
	  	    	  System.out.println("Overwriting random SSNs to file: ");
	  	      }
	  	      
	  	      FileWriter fw = new FileWriter(file);
			  BufferedWriter bw = new BufferedWriter(fw);
				
			  Random rn = new Random();
			  fw.write(M+"\n");
			  for (int i = 0; i < M; i++)
			  {
				  // Generate a random set of M integers.
				  // Display the SSNs.
				  int SSN = rn.nextInt(999999999); 
				  System.out.format("%09d%n", SSN);
				  // Write SSNs to a file
				  fw.write(String.format(formatStr, SSN));
			  }
			  bw.close();
			  System.out.println("DONE");
	   
	      } catch (IOException e) {
	  	      e.printStackTrace();
	  	  }

	       
       //************************************************************       
       // 2)READ SSNs from file:
       //************************************************************
	   File file = new File("dataS.txt");
	       Scanner sc = new Scanner(file);
	       
		   System.out.println("Read DATA from \"dataS.txt\" & put in HASH Table: ");
	       int getSSN;
	       while(sc.hasNextInt())
	       {
	      	 	getSSN = sc.nextInt();
	      	 	System.out.println("Key = " + getSSN + " -> Hash value = " + (getSSN % H));
			   	hb.put(getSSN);
	       }
	       
	       sc.close();
	       System.out.println();
	       System.out.println("End READ SSNs.\n");
        
        //***************************************************************
        // 3) Print the HashTable
        //***************************************************************
	       System.out.println("Display table: ");
	       for(int i=0; i < H; i++)
	    	    System.out.println("t[" + i + "] = " + hb.readData(i));
  
        //***************************************************************
        //  4) SEARCH: Let the user ENTER a SSN: A. Search to see if A is in T. 
        //  Print out A and the search result(if A is found or not and index of A if it is found) 
        //***************************************************************
	     //Enter the KEY to search
	       System.out.println("Enter the Value of a Key(SSN) to Search: ");
	       Scanner scr = new Scanner(System.in);
	       int a = scr.nextInt();
	       hb.hasKey(a);
	       System.out.println("Key = " + a + " -> Hash Value = " + a % H);
        
        //Search for KEY
	       if(hb.hasKey(a) == -1)
	       {
	    	   System.out.println("Search result : " + a + " was not found.");
	       }
	       else
	       {
	    	   System.out.println("Search result : " + a + " is Found at T[" + hb.hasKey(a) + "]");
	       }
            
        //****************************************************************************
        //   5)	REMOVE: Let the user enter a SSN: B. Remove B if there is B in T. 
        //      Print out B and the remove result(if B is found and removed or not and index where B is removed) 
        //*****************************************************************************        
	     //Enter the KEY to remove
	       System.out.println("Enter the Value of a KEY(SSN) to Remove: ");
	       int b = scr.nextInt();
	       int removedVal;
	       removedVal = hb.remove(b);
	       System.out.println("Key = " + b + " -> Hash Value = " + b % H);
        
        //Search for KEY
	       if(removedVal == -1)
	       {
	    	   System.out.println("Remove result : " + b + " was not found.");
	       }
	       else
	       {
	    	   System.out.println("Remove result : " + b + " is Removed at T[" + removedVal + "]");
	       }
	       
        //****************************************************************************
        //   6) ADD: Let the user enter a SSN: C. Insert/add C to Hash Table/array T.  
        //*****************************************************************************        
	     //Enter the KEY to add
	       System.out.println("Enter the Value of a KEY(SSN) to Insert: ");
	       int c = scr.nextInt();
	       hb.put(c);
	       System.out.println("Key = " + c + " -> Hash Value = " + c % H);
        
        //Search for KEY
	       if(hb.hasKey(c) == -1)
	       {
	    	   System.out.println("Insert result : Hash Table is full. Could not add " + c + " to HashBag.");
	       }
	       else
	       {
	    	   System.out.println("Insert result : " + c + " is Added at T[" + hb.hasKey(c) + "]");
	       }
	       scr.close();
        //***************************************************************
        //  7) Print the HashTable
        //***************************************************************
	       System.out.println("Display table: ");
	       for(int i=0; i < H; i++)
	    	    System.out.println("t[" + i + "] = " + hb.readData(i));
    }
}
