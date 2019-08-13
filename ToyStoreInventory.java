/* This class is a blueprint (user-defined type) for a linked list of toys */

public class ToyStoreInventory {
    
	/**************** ATTRIBUTES *******************************************
	/* Here go your attributes, i.e., the information that is contained in 
	 * your new "type" 
	 * We can also see these new types as "blue-prints" of "things" we are 
	 * going to build 
     * DO NOT MODIFY THE LIST OF ATTRIBUTES
	 ***********************************************************************/
    // Attributes ARE GIVEN TO YOU...
    private ToyStoreItem toy;
    private ToyStoreInventory restOfInventory;
    
    /***************** METHODS *********************************************
     * Note that none of the methods below are static.
     ***********************************************************************/
    
	/**************** CONSTRUCTORS *****************************************
	 * Note that the signatures are different from those we are used to 
	 ***********************************************************************/
    // Constructors

    /* Constructor 1 ************************************************************
     * Here this constructor consists in starting the inventory with only one toy
     * So there is this toy in the list and nothing in the rest of the inventory
     ****************************************************************************/
    public ToyStoreInventory(ToyStoreItem t) {
        toy = t;
        restOfInventory = null;
    }
    
    /* Constructor 2 ************************************************************ 
     * Here this constructor consists in building a new inventory from a given toy
     * and an existing inventory. So there is this toy in the list and the "old"
     * inventory as the rest of the inventory
     ****************************************************************************/
    public ToyStoreInventory(ToyStoreItem t, ToyStoreInventory r) {
        toy = t;
        restOfInventory = r;
    }
    
	/***************** SETTERS / MUTATORS **********************************
	 * Methods that allow to set or modify the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static 
	 ***********************************************************************/
    public void setToy(ToyStoreItem t) {
        toy = t;   
    }
    
    public void setRestOfInventory(ToyStoreInventory r) {
        restOfInventory = r;   
    }
    
	/**************** GETTERS / ACCESSORS **********************************
	 * Methods that allow to access the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static 
	 ***********************************************************************/
    public ToyStoreItem getToy() {
        return toy;
    }
    
    public ToyStoreInventory getRestOfInventory() {
        return restOfInventory;   
    }
    
    /*******************************************************************
     * Other methods
     *******************************************************************/
    
    // A (non static) method, print, that prints the linked list of toys
    public void print() {
        ToyStoreInventory iter = this;
        while (iter != null) {
            iter.getToy().print();
            iter = iter.getRestOfInventory();   
        }
    }
    
    // A (non static) method, sizeLL, that returns the number of items in 
    // the list
    public int size() {
        int size = 0;
        ToyStoreInventory iter = this;
        while (iter != null) {
            size++;
            iter = iter.getRestOfInventory();   
        }
        return size;
    }
    
    // A (non static) RECURSIVE method, sizeLLR, that returns the number 
    // of items in the list
    public int sizeR() {
        ToyStoreInventory iter = this;
        if (iter == null) return 0;
        if (iter.getRestOfInventory() == null) return 1;
        return 1 + iter.getRestOfInventory().sizeR();
    }

    // TO DO: 
    // A (non static) method, addTail, that takes a new list of members L and modifies 
    // the original list where L has been added as the last nodes in the list.
    public void addTail(ToyStoreInventory L) { 
        ToyStoreInventory iter = this;
        while (iter.getRestOfInventory()!=null) {
			iter = iter.getRestOfInventory();   
        }
        //at this point, iter is the last node of the list = the tail
        iter.setRestOfInventory(L);
    }        
    
    // TO DO:
    public void addTail(ToyStoreItem M) {
        ToyStoreInventory L = new ToyStoreInventory(M);
        ToyStoreInventory iter = this;
        
		while (iter.getRestOfInventory()!=null) {
			iter = iter.getRestOfInventory();   
        }
        
        // at this point, iter is the last node of the list = the tail
        iter.setRestOfInventory(L);
    }        
    
   /* /********************************************************************************
     * Ideas for additional methods:
     * 1: A (non static) method, removeHead, that modifies the original list by cropping out its first node
     * 2: A (non static) method, removeTail, that modifies the original list by removing its last node    
     * 3. A (non static) method, addNth, that takes a new member M and 
     * an integer n, and modifies the original list whesse list if n is larger 
     * than the size of the list + 1).
     * 4. A (non static) method, removeNth, that modifies the original list by removing its nth node.
     * If there are less than n nodes in the current list, it removes the last one. */
     
    public void removeHead() {
       // complete code here
	   ToyStoreInventory temp = this;
	   temp = this.getRestOfInventory();
	   this.setToy(temp.getToy());
	   this.setRestOfInventory(temp.getRestOfInventory());
	   
    }
    
    public void removeTail() {
        // complete code here
		ToyStoreInventory prev = this;
		ToyStoreInventory temp = prev.getRestOfInventory();
		
		while (temp != null) {
			temp = temp.getRestOfInventory();
			prev = prev.getRestOfInventory();
		}
		prev.setRestOfInventory(null);
    }
    
    public void addNth(ToyStoreItem M, int n) {
        // complete code here
		ToyStoreInventory L = new ToyStoreInventory(M);
		ToyStoreInventory iter = this;
		int counter = 1;
		while ( counter < n-1) {
			iter = iter.getRestOfInventory();
			counter++;
		}
		L.setRestOfInventory(iter.getRestOfInventory());
		iter.setRestOfInventory(L);
    }
    
    public void removeNth(int n) {
        // complete code here
		ToyStoreInventory iter = this;
		int counter = 1;
		while (counter < n-1){
			iter.setRestOfInventory(iter.getRestOfInventory().getRestOfInventory());
		}
    } 
    
}