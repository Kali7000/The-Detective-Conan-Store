import java.util.*;
import java.io.*;


public class User implements Serializable{
    private String username;
    private String password;
    
    public User(){
        this.username = "kali";
        this.password = "12345";
    }
    public User(String userN, String pass){
        this.username = userN;
        this.password = pass;
    }
    
    public void setPassword(String newPass){
        this.password = newPass;
    }
    
    public void setUsername(String newUser){
        this.username = newUser;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getUsername(){
        return this.username;    
    }
    public void login(){
        System.out.println("Default login for users.");
    }
   
}
