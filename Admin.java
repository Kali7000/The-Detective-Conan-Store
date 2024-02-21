import java.util.*;
import java.io.*;



public class Admin extends User implements Serializable{
    
    public Scanner scan = new Scanner(System.in);
    HashMap<String, User> dict = Main.dict;
    HashMap<String, Product> items = Main.items;
    
    public Admin() {
        super();
    }
    public Admin(String username, String password) {
        super(username, password);
    }
    
    public void login(){
        while(true){
            try {
                System.out.println("1- Create a customer account"+
                    "\n" +"2- Remove a customer account"+"\n"+"3- View inventory"+"\n"+
                    "4- Add a product"+"\n"+"5- Remove a product"+"\n"+
                    "6- Restock a product"+"\n"+"7- Logout");
                System.out.print("Enter: ");
                int num = scan.nextInt();
                scan.nextLine();
                if (num == 1){
                    CreateAccount();
                }
                
                else if (num == 2){
                    removeAccount();
                }
                
                else if (num == 3){
                    viewInventory();
                    
                }else if (num ==4){
                    addProduct();
                }else if (num ==5){
                    removeProduct();
                }else if (num ==6){
                    restock();
                }
                else if(num == 7){
                    break;
                }
                
                
                else{
                    System.out.println("Invalid input, your options are-------> ");
                    System.out.println();
                }
                    
            } catch(Exception e){
                System.out.println("Only Integers are allowed!");
                scan.nextLine();
            }    
                
            
        }
    }
    
    
    
    
     public void CreateAccount(){
        System.out.println("******** Create a customer account ********");
        while (true){
            System.out.print("Enter Username: ");
            String username = scan.nextLine();
            if (dict.containsKey(username)){ 
                System.out.println("Error: This username already exists");
            }else{
                System.out.print("Enter password: ");
                String password = scan.nextLine();
                if (password.length()!=5){
                    System.out.println("Error: password should be exactly 5 characters");
                }else{
                    dict.put(username, new Customer(username,password));    
                    break;
                }
            }
        }
    }
    
    
    public void removeAccount(){
        System.out.println("******** Remove a customer account ********");
        while (true){
            System.out.print("Enter username: ");
            String username = scan.nextLine();
            if (dict.containsKey(username)){
                dict.remove(username);
                System.out.println("Success: customer account has been removed");
                break;
            }else{
                System.out.println("Error: This username doesn't exist");
            }
        }
        
    }
    
    public void viewInventory(){
        System.out.println();
        System.out.println("******** Inventory ********");

        for (Map.Entry<String, Product> item : items.entrySet()) {
            Product product = item.getValue();
            product.print();
        }
        System.out.println();
    }
    
    public void addProduct(){
        System.out.println();
        System.out.println("******** Add a product ********");
        scan.nextLine();
        while (true){
            System.out.println();
            System.out.print("Enter new product name: ");
            String productName = scan.nextLine();

                System.out.print("Enter price: ");
                int price = scan.nextInt();
                System.out.print("Enter Count: ");
                int count = scan.nextInt();
                
                Product tempItem = new Product(productName, count, price);
                items.put(productName, tempItem);
                System.out.println(productName +" added");
                System.out.print("Enter 'y' to continue OR Enter 'n' to stop removing: ");
                scan.nextLine();
                String ans = scan.nextLine();
                if (ans.equals("n")){
                    break;
                }
                
            }
            
        }
        
        

    public void removeProduct(){
        System.out.println();
        System.out.println("******** Remove a product ********");
        while (true){
            System.out.println();
            System.out.print("Enter new product name: ");
            String productName = scan.nextLine();
            if (items.containsKey(productName)){ 
                items.remove(productName);
                System.out.println("Success: "+ productName+" has been removed");
            }else{
                System.out.println("Error: product does not exist");
            }
            
            System.out.print("Enter 'y' to continue OR Enter 'n' to stop removing: ");
            scan.nextLine();
            String ans = scan.nextLine();
            if (ans.equals("n")){
                break;
            
            }
        
        }
    }

    public void restock(){
        System.out.println();
        System.out.println("******** Restock ********");
        
        while(true){
            System.out.print("Enter Product Name: ");
            String productName = scan.nextLine();
            if (items.containsKey(productName)){ 
                System.out.print("Enter Restock Count: ");
                int count  = scan.nextInt();
                (items.get(productName)).setCount(((items.get(productName)).getCount() + count));
                System.out.println("Success: Quantity of "+ productName+" has been increased to "+(items.get(productName)).getCount());
            }else{
                System.out.println("Error: product does not exist");
            }
            System.out.print("Enter 'y' to continue OR Enter 'n' to stop Restocking: ");
            scan.nextLine();
            String ans = scan.nextLine();
            if (ans.equals("n")){
                break;
            
            }
        
        }

    }
    
}
