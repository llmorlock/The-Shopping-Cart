//Customer.java
package ShoppingCartV1;
import java.util.*;
public class Customer {
String userName;
String password;
String address;
String email;
int id;
int count=0;
	Customer(){
	}
Customer(String user,String pass, String em){
	userName=user;
	password=pass;
	email=em;
	count++;
	id=count;
}

public Customer(String user, String pass) {
    userName = user;
    password = pass;
}

public String getUsername() {
	return userName;
}
public String getPassword() {
	return password;
}
public String getAddress() {
	return address;
}
public String getEmail() {
	return email;
}
public int getID() {
	return id;
}

public void setUsername(String temp) {
	userName=temp;
}
public void setPassword(String temp) {
	password=temp;
}
public void setAddress(String temp) {
	address=temp;
}
public void setEmail(String temp) {
	email=temp;
}
public void setID(int temp) {
	id=temp;
}

public void add(Product product) {
    myProducts.add(product);
}

public void add(LinkedList list) {
    myProducts.addAll(list);
}

public LinkedList getMyProducts() {
    return myProducts;
}

public void remove(int index) {
    myProducts.remove(index);
}

LinkedList<Product> myProducts = new LinkedList<>();

}