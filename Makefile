all: Main.java User.java Admin.java Customer.java Product.java Serialization.java
	javac Main.java User.java Admin.java Customer.java Product.java Serialization.java
    
run: all
	java Main

clean:
	rm *.class
