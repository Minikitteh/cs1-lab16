import java.io.*;
import java.util.Scanner;
import java.util.*;

public class ManageToyStore {

    /*********************************************************************
     * A method, readFromFile, that takes a file name as a string – this 
     * file contains toys information, and returns an array of items of 
     * type ToyStoreItem. This method should handle file-reading errors via 
     * exception handling.
     *********************************************************************/
    // auxiliary function to help compute the number of lines in the file you have to read
    /* Option 1 TO DO: Modify this method to fit your file pattern*/
    public static int numToys(String filename) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        int counter = 0;
        while (textReader.ready()) {
            textReader.readLine();   
            counter++;
        }
        textReader.close();
        return counter-1; // Modify code here to fit your file format (for instance: 10 lines 
                    // in the file may correspond to 2 toys (1 attribute per line) so you would return 2) 
    }
    
    /*****************/
    /* Option 1 TO DO: Complete this method */
    public static ToyStoreItem[] readItemsFromFileA(String filename) throws FileNotFoundException, IOException {
        int nbToys = numToys(filename);
		ToyStoreItem[] toysArray = new ToyStoreItem[nbToys];
		for(int i=0; i<toysArray.length; i++){
			toysArray[i]= new ToyStoreItem();
		}
        
		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

      String line;
	  double temp;
	  
	  
	  for(int i=0; i<nbToys; i++){
	  	line = textReader.readLine();
		for(int lineCounter = 0;lineCounter < nbToys;lineCounter++) {
			  String[] x = line.split(" ");// complete code here
			  ToyStoreItem tempIndex = new ToyStoreItem();
			  tempIndex.setType(x[0]);
			  tempIndex.setName(x[1]);
			  tempIndex.setPrice(Double.parseDouble(x[2]));
			  tempIndex.setDiscount(Double.parseDouble(x[3]));
			  tempIndex.setAge(Integer.parseInt(x[4]));
			  toysArray[i] = tempIndex;
		  }
	  }

        textReader.close();        
        
        return toysArray;
    }
    
    /*********************************************************************************** 
     * the following method takes a file name and as it is reading it (WITHOUT counting 
     * the number of lines first)
     * it stores the information about toys into a linked list of these toys
     * your method should use a while loop: see below 
     ***********************************************************************************/
     /*****************/
     /* Option 2 TO DO: Complete this method */
   /*public static ToyStoreInventory readItemsFromFile(String filename) throws FileNotFoundException, IOException {
 		FileReader fr = new FileReader(filename);
        BufferedReader textReader = new BufferedReader(fr);

        // complete code here
        
        //while (complete code here ) {
            // complete code here
        //} 
        textReader.close();        
        
        return null; // modify code here
   }
   */
   
    /*********************************************************************
     * A method, sortByPrice, that takes an array of elements of 
     * type ToyStoreItem, and sorts them by price, from cheapest to most expensive. 
     *********************************************************************/
     /* Option 1 & Option 2 TO DO: Complete this method */
     public static void sortByPrice(ToyStoreItem[] A) {
        // I suggest that you use selection sort 
		
        for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length-1; j++) {
				if(A[j].getPrice() > A[j+1].getPrice()){
					ToyStoreItem t = A[j];
					A[j] = A[j+1];
					A[j+1]=t;
				}
			}
        }
        
    }
    
    /*********************************************************************
     * Now design another method that sorts an array of toys a different 
     * way: e.g., by alphabetical order of the type of toys,
     * by discount, etc.
     *********************************************************************/
     /* Option 1 & Option 2 TO DO: Complete this method */
     //public static /* complete code here */(ToyStoreItem[] A) {
        // add your code here           
     //}
    
    
    /*********************************************************************
     * A method, revenue, that takes an array of toys and computes the
     * total amount of money generated by the total of these toys' prices
     * while taking into account discounts
     *********************************************************************/
    /* Option 1 TO DO: Complete this method */ 
    public static double revenue(ToyStoreItem[] A) {
		double [] dp = new double[A.length];
		for (int i=0; i<dp.length; i++){
			dp[i]= A[i].getPrice()-(A[i].getPrice()*(A[i].getDiscount()/100.0));
		}
		
		double tc = 0.0;
		for(int i=0; i<dp.length; i++){
			tc = tc + A[i].getPrice();
		}
        return tc; // to be modified
    }
    
    /*********************************************************************
     * A method, revenue, that takes a linked list of toys and computes the
     * total amount of money generated by the total of these toys' prices
     * while taking into account discounts
     *********************************************************************/
    /* Option 2 TO DO: Complete this method 
    public static double revenue(ToyStoreInventory L) {
        // add your code here                   
        return 0; // to be modified
    }*/
    
    /*********************************************************************
     * A method buildLL that takes an array of items of type ToyStoreItem, and 
     * returns a linked list of all the toys in the array
     *********************************************************************/
    /* Option 1 TO DO: Complete this method */
    public static ToyStoreInventory buildLL(ToyStoreItem[] A) {
        if (A.length == 0) return null;
        ToyStoreInventory result = new ToyStoreInventory(A[0]);
        for (int i=1; i<A.length; i++) {
            
        }
        return result;
    }
    
    /*********************************************************************
     * A method buildA that takes a linked list of all the toys and 
     * returns an array of the toys originally in the linked list
     *********************************************************************/
    /* Option 2 TO DO: Complete this method */
    //public static ToyStoreItem[] buildA(ToyStoreInventory L) {
        // complete code here
    //}
    
    /*********************************************************************
     * Print the contents of an array of toys
     *********************************************************************/
    /* Option 2 TO DO: Complete this method 
    public static void printToys(ToyStoreItem[] A) {
        // complete code here
		for (int i = 0; i < A.length; i++){
			A[i] = print();
    }
    */

    /*********************************************************************
     * Print the contents of a linked list of toys
     *********************************************************************/
    /* Option 1 TO DO: Complete this method */ //?????????HELP
    public static void printToys(ToyStoreInventory L) {
        L.print(); //you slreadt
    }
    
     /*********************************************************************
     * A main method that allows you to test all above methods.
     *********************************************************************/
    public static void main(String[] args) throws FileNotFoundException, IOException {

        ToyStoreItem T1 = new ToyStoreItem("Board Game", "Chess");
        ToyStoreItem T2 = new ToyStoreItem("Outdoor", "Football");
        ToyStoreInventory I = new ToyStoreInventory(T1);
		//I.setRestOfInventory(new ToyStoreInventory(new ToyStoreItem("bgame","game")));
        System.out.println(I.size());
        //I.print();
        //I.addNth(T2, 3);
		printToys(I);
		System.out.println(I.size());
//		ToyStoreItem A[] = (readItemsFromFileA("ToyStoreItem.txt"));
//		sortByPrice(A);
		// add code in there to test your methods
    }
} 