import java.util.*;
import java.io.*;

public class Main{
    private static Serialization serial = new Serialization();
    
    public static HashMap<String, User> dict = new HashMap<>();
    public static HashMap<String, Product> items = new HashMap<>();
    public static HashMap<Product, Integer> cart = new HashMap<>();
    
	public static void main(String[] args) {
	    
	    
        HashMap<String, User> loadedDict = (HashMap<String, User>) serial.download("users.ser");
        if (loadedDict != null) {
            dict = loadedDict;
        }

        HashMap<String, Product> loadedItems = (HashMap<String, Product>) serial.download("products.ser");
        if (loadedItems != null) {
            items = loadedItems;
        }

        HashMap<Product, Integer> loadedCart = (HashMap<Product, Integer>) serial.download("cart.ser");
        if (loadedCart != null) {
            cart = loadedCart;
        }
	    
		dict.put("human1", new Customer("human1", "12345", 10000));
		
		dict.put("admin", new Admin("admin", "12345"));
		
		
		items.put("milk", new Product("milk", 100, 5));
		items.put("book", new Product("book",500,10));
		items.put("clock", new Product("clock",30,20));
		items.put("gold", new Product("gold",400,5000));
		items.put("anti matter", new Product("anti matter",2,9999999));
		
		
	    Scanner scan = new Scanner(System.in);
	    boolean rm = false;

	    while(true){
    		System.out.println("******** Welcome to The Detective Conan Store ********");
    		System.out.println("1- Login");
    		System.out.println("2- Register");
    		System.out.println("3- Logout");
    		
    		if(rm){
    		    scan.nextLine();
    		}
    		
    		try{
        		int input = scan.nextInt();
        		
        		scan.nextLine();
        		if (input ==1){
        		    System.out.println();
        		    System.out.print("Enter Username: ");
        		    String inputName = scan.nextLine();
        		    
        		    if (dict.containsKey(inputName)){
        		        System.out.print("Enter Password: ");
        		        String inputPassword = scan.nextLine();
        		        if (inputPassword.equals((dict.get(inputName)).getPassword())){
        		            (dict.get(inputName)).login();
        		            
        		        }else{
        		            System.out.println("Wrong Password ------) try Again");
        		            System.out.println();
        		        }
        		    } 
        		    else{
        		        System.out.println("Entered username Dosen't Exist! ---> Try Again");
        		        System.out.println();
        		    }
        		    
        		    
        		    
        		} else if(input == 2){
        		    System.out.println("Hi there---> We don't value our customers at all");
        		    
        		    while(true){
            		    System.out.print("Enter New Username: ");
            		    String newUsername = scan.nextLine();
            		    
            		    if (dict.containsKey(newUsername)){
            		        System.out.println("The username already exists!! Try a different one");
            		    }
            		    else{
            		        while (true){
            		            System.out.print("Create Password: ");
            		            String newPassword = scan.nextLine();
                                if (newPassword.length()!=5){
                                    System.out.println("Error: password should be exactly 5 characters");
                                }else{
                                    dict.put(newUsername, new Customer(newUsername, newPassword)); 
                                    break;
                                }
                            }
            		        
            		        System.out.println(newUsername+" added!!");
            		        break;
        		        }
        		    }
        		    
        		    
        		}else if (input == 3){
        		    serial.save(dict, "users.ser");
                    serial.save(items, "products.ser");
                    serial.save(cart, "cart.ser");
        		    System.out.println("You are hacked!!! Pay $500 or .....");
        		    break;
        		 
        		}
        		else{
        		    System.out.println("Wrong Input ---> Try Again");
        		    System.out.println();
        		}
    	 	
    	    }catch (Exception e) {
        		    System.out.println("Wrong Type of Input ---> Try Again");
        		    System.out.println();
        		    rm = true;
        		    continue;
        	}
	    }
		
		
	}
}
