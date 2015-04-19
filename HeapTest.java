// Heidi Fritz

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


/**
 * class HeapTest 
 */
public class HeapTest
{  
   //******************************************************************
   // Generate a HEAP tree randomly:
   //******************************************************************
   /**
    * Method to generate a Heap randomly
    * @param: three integers, L is lower limit, H is higher limit, M is the number of nodes
    * @return: the new HEAP 
    */      
   public static HeapBag GenHeap(int L, int H, int M){
	   Random rn = new Random();
	   HeapBag tempHeap = new HeapBag();
	   for (int i = 0; i < M; i++)
	   {
		   // Generate a random set of M integers in the range
		   // L to H. Display the set.
		   int data = rn.nextInt(H) + L; 
		   System.out.print(data + " ");
		   // Build a heapX by inserting M nodes using generated integers as data
		   BinaryTreeNode btn = new BinaryTreeNode();
		   btn.setData(data);
		   tempHeap.add(btn);
	   }
	   return tempHeap;
   }
   
   //******************************************************************
   // MAKE a HEAP (by USER)
   //******************************************************************
   /**
    * Method to let user to create a Heap. First enter M integers, then add nodes one-by-one
    * @param: two integers, L is lower limit, H is higher limit
    * @return: "heapG" is the new HEAP 
    */    
   public static HeapBag MakeHeap(int L, int H){
	   System.out.println("User make a Heap. Node values are between " + L + " and " + H);
	   System.out.println("Please enter # of nodes: ");
	   Scanner sc = new Scanner(System.in);
       int M = sc.nextInt();
       HeapBag tempHeap = new HeapBag();
       for(int i = 1; i <= M; i++)
       {
    	   System.out.println("node # " + i + ": ");
           int nodeData = sc.nextInt();
           BinaryTreeNode btn = new BinaryTreeNode();
		   btn.setData(nodeData);
		   tempHeap.add(btn);
       }
       return tempHeap;
   }
   
   //******************************************************************
   //Display DATA of the HEAP with ARRAY Implementation order
   //******************************************************************
   /**
    * Method to Display DATA of the HEAP (with ARRAY Implementation order)
    * @param: heapG is the heap to be displayed
    * @return: NONE 
    */       
   public static void DisplayHeapData(HeapBag heapG){
	   for(int i = 0; i < heapG.getLast() + 1; i++)
	   {
		   if(heapG.getNode(i) == null)
			   break;
		   else
			   System.out.print(heapG.getNode(i).getData() + ", ");
	   }
	   System.out.println();
   }

   //************************************************************
   // SAVE-Write a HEAP to a TEXT FILE (with ARRAY Implementation)
   //************************************************************
   /**
    * Method to SAVE-Write a HEAP to a TEXT FILE (with ARRAY Implementation)
    *     first write the # of nodes/elements, then each node value of the heap 
    * @param: two, "heapG" is the heap to write and "filename" is the name of the file
    * @return: NONE 
    */      
   public static void WriteHeapToFile(HeapBag heapG, String fileName) throws IOException{
	   try {
  		 
	  	      File file = new File(fileName);
	   
	  	      if (file.createNewFile())
	  	      {
	  	    	  System.out.println("File created.");
	  	      }
	  	      else
	  	      {
	  	    	  System.out.println("File overwritten.");
	  	      }
	  	      
	  	      	FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				fw.write(heapG.getLast() + 1 + " ");
				for(int i = 0; i < heapG.getLast() + 1; i++)
				{
					if(heapG.getNode(i) == null)
						   break;
					else
						fw.write(heapG.getNode(i).getData() + " ");
				}
				bw.close();
	  	      
	   
	      	} catch (IOException e) {
	  	      e.printStackTrace();
	  	}
   }   
   
   //************************************************************
   // GET-Read a HEAP to a TEXT FILE (with ARRAY Implementation)
   //************************************************************
   /**
    * Method to GET-Read a HEAP to a TEXT FILE (with ARRAY Implementation),
    *        first read the # of nodes/elements, then each node value and add it the new heap 
    * @param: "filename" is the name of the file
    * @return: heapG is the heap read from the file 
    */
   public static HeapBag ReadHeapFromFile(String fileName) throws IOException{
	   File file = new File(fileName);
       Scanner sc = new Scanner(file);
       
       System.out.println("Reading a Tree from " + fileName + " file: ");
       
       HeapBag hb = new HeapBag();
       int x;
       while(sc.hasNextInt())
       {
      	 x = sc.nextInt();
      	 
      	BinaryTreeNode btn = new BinaryTreeNode();
		   btn.setData(x);
		   hb.add(btn);
      	 System.out.print(x + " ");
       }
       
       sc.close();
       System.out.println();
       System.out.println("End of Reading.\n");
  	 return hb;

   }   
   
   
   //************************************************************
   // DISPLAY a HEAP in a tree form on the screen
   //************************************************************
   /**
    * Method to DISPLAY a HEAP in a tree form on the screen
    *     using method print(n) with indentation in BinaryTreeNode, must connect all nodes first 
    * @param: the heap
    * @return: NONE 
    */    
   
   public static void PrintHeapTree(HeapBag a){
	   a.connectNodes();
	   a.getNode(0).print(BinaryTreeNode.treeSize(a.getNode(0)));
   }
   
   
   public static void main(String[] args) throws IOException{


        
// 1) GENERATE a random HEAP:
		    System.out.println("Generate Random Integers: ");
		    HeapBag heapX = new HeapBag();
		    heapX = GenHeap(1, 100, 10);
		    System.out.println();
        
	   
        //Display DATA of the HEAP with ARRAY Implementation order
		    System.out.println("Data of this Heap with Array Implementation: ");
		    DisplayHeapData(heapX);

	   
        //Write heap DATA to a TEXT file
		    System.out.println("Write this heap to a Text file HeapX.txt");
		    WriteHeapToFile(heapX, "HeapX.txt");

        
        // DISPLAY a HEAP in a tree form on the screen
		    System.out.println("Tree Form of this Heap: ");
		    PrintHeapTree(heapX);
	        System.out.println();
        
// 2) Let the USER make a HEAP:
		    HeapBag heapY = new HeapBag();
		    heapY = MakeHeap(1, 100);
		    System.out.println();
        
        //Display DATA of the HEAP with ARRAY Implementation order
		    System.out.println("Data of this Heap with Array Implementation: ");
		    DisplayHeapData(heapY);
		    System.out.println();
	   
        // DISPLAY a HEAP in a tree form on the screen
		    System.out.println("Tree Form of this Heap: ");
		    PrintHeapTree(heapY);
	        System.out.println();
       
        //Write heap DATA to a TEXT file
	        System.out.println("Write this heap to a Text file HeapY.txt");
			WriteHeapToFile(heapY, "HeapY.txt");
		    System.out.println();
             
// 3) READ a heap from a TEXT file:
	  
        
        //Read heap DATA from a TEXT file
		    System.out.println("Read a heap from Text file HeapX.txt");
		    HeapBag heapA = new HeapBag();
			heapA = ReadHeapFromFile("HeapX.txt");
		    System.out.println();

        // DISPLAY a HEAP in a tree form on the screen       
		    System.out.println("Tree Form of this Heap: ");
		    PrintHeapTree(heapA);
	        System.out.println();
        
// 4) ADD a new NODE
        
        //Enter the Value of a node Z to add
	        System.out.println("Enter the Value of node Z to add: ");
	        Scanner scr = new Scanner(System.in);
	        int z = scr.nextInt();
        // create the NEW NODE
	        BinaryTreeNode newNode = new BinaryTreeNode(z, null, null);
	        
        //Adding the New Node
	        HeapBag heapC = new HeapBag();
	        heapA.add(newNode);
	        heapC = heapA;
        
        //Display DATA of the NEW HEAP (with ARRAY Implementation order)
			System.out.println("New HeapC after adding node. Data of this Heap with Array Implementation: ");
			DisplayHeapData(heapC);
			System.out.println();
			
		// Write to file "heapC.txt"
			System.out.println("Write this heap to a Text file HeapC.txt");
			WriteHeapToFile(heapC, "HeapC.txt");
		    System.out.println();

        // DISPLAY a HEAP in a tree form on the screen
			System.out.println("Tree Form of this Heap: ");
			PrintHeapTree(heapA);
			System.out.println();
        
// 5) REMOVE a NODE(ROOT)

        
        //Display the removed node
			System.out.println("The removed node = " + heapA.remove().getData());
        
        //Display DATA of the NEW HEAP (with ARRAY Implementation order)
			System.out.println("Data of this Heap with Array Implementation: ");
		    DisplayHeapData(heapA);
		    System.out.println();
		    
        // DISPLAY a HEAP in a tree form on the screen
		    System.out.println("Tree Form of this Heap: ");
			PrintHeapTree(heapA);
			System.out.println();
        
// 6) SEARCH for a KEY

        
        //Enter the KEY to search
	       System.out.println("Enter the Key to search: ");
	       int x = scr.nextInt();
	       heapA.search(x);
        
        //Search for KEY, count how many times if it's found
	       System.out.println("found this key " + heapA.count(x) + " time(s).");
	       
        scr.close();
    }
}
