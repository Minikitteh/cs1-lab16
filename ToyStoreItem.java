public class ToyStoreItem {

	/**************** ATTRIBUTES *******************************************
	/* Here go your attributes, i.e., the information that is contained in 
	 * your new "type" 
	 * We can also see these new types as "blue-prints" of "things" we are 
	 * going to build 
     * DO NOT MODIFY THIS LIST OF ATTRIBUTES
	 ***********************************************************************/
	private String type; // type of toy; e.g., board game
    private String name; // name of toy; e.g., chess
    private double price; // price of toy
    private double discount; // possible special (may be set to 0 as default)
    private int age; // minimum recommended age 
	
    /***************** METHODS *********************************************
     * Note that none of the methods below are static.
     ***********************************************************************/
    
	/**************** CONSTRUCTORS *****************************************
	 * Note that the signatures are different from those we are used to 
	 ***********************************************************************/
	/* default constructor: provided to you. You should not touch the next two lines of code */
	public ToyStoreItem() {
	}
	
    public ToyStoreItem(String actualtype, String actualname) {
        type = actualtype;
        name = actualname;   
    }
    
    /* TO DO: add at least 2 more constructors */
	
	public ToyStoreItem(double tp, double d){
		price = tp;
		discount = d;
	}
	
	public ToyStoreItem(String actualtype, String actualname, double tp, double d, int a){
		type = actualtype;
        name = actualname; 
		price = tp;
		discount = d;
		age = a;
	}
	
	/***************** SETTERS / MUTATORS **********************************
	 * Methods that allow to set or modify the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static 
	 ***********************************************************************/
	public void setType(String actualtype) {
        type = actualtype;
	}
    
    /* TO DO: add all other setters */
	public void setName(String toyName){
		name = toyName;
	}
	
	public void setPrice(double toyPrice){
		price = toyPrice;
	}
	
	public void setDiscount(double dSpecial){
		discount = dSpecial;
	}
	
	public void setAge(int kAge){
		age = kAge;
	}
	
	/*private String type; // type of toy; e.g., board game
    private String name; // name of toy; e.g., chess
    private double price; // price of toy
    private double discount; // possible special (may be set to 0 as default)
    private int age;
	*/
    
	/**************** GETTERS / ACCESSORS **********************************
	 * Methods that allow to access the values of the attributes
	 * One method per attribute
	 * Note that the methods are not static 
	 ***********************************************************************/
	public String getType() {
        return type;
	}
	
    /* TO DO: add all other getters */
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return price;
	}
	
	public double getDiscount(){
		return discount;
	}
	
	public int getAge(){
		return age;
	}
    	
	/***********************************************************************
	 * Other methods, depending on your needs 
	 ***********************************************************************/

    /***********************************************************************
	 * TO DO: Here we are asking you to design a method that prints the information
	 * about any Toy Store Item
	 ***********************************************************************/
	public void print() {
        System.out.println("Toy type: " + type);
		System.out.println("Toy name: " + name);
		System.out.println("Toy price: " + price);
		System.out.println("Toy discount: " + discount);
		System.out.println("Reccommended age: " + age + " and up");
		// here: add code to complete the print method that allows to print 
        // the content of all attributes
    }
	
}