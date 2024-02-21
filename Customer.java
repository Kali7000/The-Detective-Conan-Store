import java.util.*;
import java.io.*;



public class Customer extends User implements Serializable{
    public Random rand = new Random();
    public Scanner scan = new Scanner(System.in);
    HashMap<String, Product> items = Main.items;
    private HashMap<Product, Integer> cart = new HashMap<>();
    private int balance;
    public int price = 0;
    
    
    public Customer(){
        super();
    }
    public Customer(String username, String password) {
        super(username, password);
    }
    public Customer(String username, String password, int balance) {
        super(username, password);
        this.balance = balance;
    }
    
    public void setBalance(int newBalance){
        this.balance = newBalance;
    }
     public int getBalance(){
        return this.balance;
    }
    
    
    public void login(){
        while (true){
            System.out.println("Welcome "+super.getUsername()+"\n"+"1- Shop the store \n"
                + "2- View and checkout shopping cart \n"+ "3- View balance \n" + 
                "4- Add balance \n"+"5- Win money \n"+ "6- Logout");   
            
             System.out.print("Enter: ");
                int num = Integer.parseInt(scan.nextLine());
                
                if (num == 1){
                    shop();
                }
                
                else if (num == 2){
                    checkOut();
                }
                
                else if (num == 3){
                    System.out.println();
                    System.out.println("Your Balance is: "+ getBalance());
                    System.out.println();
                    
                }else if (num ==4){
                    
                    System.out.println("Your current Balance is: "+getBalance());
                    System.out.print("Enter Amount to add: ");
                    int amount = scan.nextInt();
                    setBalance(amount+getBalance());
                    System.out.println("Amount added, Your current Balance is: "+getBalance());
                    scan.nextLine();
                    
                }else if (num ==5){
                    win();    
                }
                
                else if (num ==6){
                    break;
                }
                else{
                    System.out.println("Invalid input, your options are-------> ");
                    System.out.println();
                }
        }     
    }
    
    
    public void win(){
        System.out.println("<----- Welcome to Your Bad Luck ----->");
        
        while(true){
            System.out.println("Guess a Number between 1 to 5 and win 500$ - 5000$");
            System.out.print("Enter the Number: ");
            int guess = scan.nextInt();
            setBalance((getBalance()-300));
            int randNum = rand.nextInt(5)+1;
            int randMoney = rand.nextInt(5000)+500;
            if(guess == 3){
                System.out.println("You chose 3, that's a bad number, you loose $300!!");
                
                System.out.println("Your balance had been reduced to $"+getBalance());
                System.out.println();
            }
            else if (guess == randNum){
                
                System.out.println();
                System.out.println("You are Rich, Now! You won: "+randMoney);
                setBalance((getBalance()+randMoney));
                System.out.println("Your New balance is $"+getBalance());
                System.out.println();
                System.out.print("Want to Play again? (y/n):");
                scan.nextLine();
                String ans = scan.nextLine();
                if(ans.equals("y")){
                    System.out.println("You are gonna lose everything!!!");
                }else{
                    break;
                }
                
            }else{
                System.out.println("You have a very bad luck, try again!");
            }
        }
       
        
        
    }
    
    public void shop(){
        System.out.println();
        System.out.println("******** Inventory ********");

        for (Map.Entry<String, Product> item : items.entrySet()) {
            Product product = item.getValue();
            product.print();
        }
        System.out.println();
        
        while (true){
            System.out.println("Enter the name of the Product to Buy!!");
            String productName = scan.nextLine();
            
            if (items.containsKey(productName)){ 
                System.out.print("Enter count: ");
                int count = scan.nextInt();
                
                if ((items.get(productName)).getCount()>count-1){
                    price = price + (count*(items.get(productName).getPrice()));
                    cart.put(items.get(productName),count);
                    System.out.println("Total Price: "+price+" Your Balance "+getBalance());
                    
                }else{
                    System.out.println("Not enough "+productName+"! You are too rich lower the number or get out.");
                }
                
                System.out.print("Enter 'y' to continue OR Enter 'n' to stop buying: ");
                scan.nextLine();
                String ans = scan.nextLine();
                
                if (ans.equals("n")){
                    break;
                }
            }else {
                System.out.println("Error: product does not exists in the inventory");
            }
        }
    }
    
    
    public void checkOut(){
        price = 0;
        System.out.println("Your Balance: "+getBalance());
        System.out.println();
        for (Map.Entry<Product, Integer> thing : cart.entrySet()) {
            Product product = thing.getKey();
            int count = thing.getValue(); 
            product.print();
            price = price+(product.getPrice());
        }
        
        System.out.println("Checkout (Y/N)?");
        String out = scan.nextLine();
        
        if (out.equals("Y") || out.equals("y")){
            if (price > getBalance()){
                System.out.println("Insufficient Balance --(You are poor, Go get some money!)");
                
            }else{
                for (Map.Entry<Product, Integer> thing : cart.entrySet()) {
                    Product product = thing.getKey();
                    int count = thing.getValue(); 
                    product.setCount((product.getCount())-count);
                }
                setBalance(getBalance()-price);
                System.out.println("Thank you for shopping at The Detective Conan Store");
                System.out.println("Your new balance is: "+getBalance());
                
            }
        }else{
            System.out.println("Want to waste more money! You chose it!!! \n Going back to the main menu.");
            
            
        }
        
        
        
    }
    

    
}
