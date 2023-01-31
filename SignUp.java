//SignUp.java
package ShoppingCartV1;
import java.io.*;
import java.util.*;

public class SignUp {
	LinkedList<Customer> Clist = new LinkedList<>();
	LinkedList<Seller> Slist = new LinkedList<>();
	int count;

	SignUp() {

	}

	public void updateCList(String user, String pass) {
		Customer temp = new Customer(user, pass);
		Clist.add(temp);
	}


	public void updateSList(String user, String pass, String em, String add, String comp) {
		Seller temp = new Seller(user, pass, em, add, comp);
		Slist.add(temp);
	}


	public int checkLog(String user, String pass) {
		int check = 0;
		for (int i = 0; i < Clist.size(); i++) {
			if (user == Clist.get(i).getUsername()) {
				if (pass == Clist.get(i).getPassword()) {
					check = 1;
				}
			}

		}
		for (int i = 0; i < Slist.size(); i++) {
			if (user == Slist.get(i).getUsername()) {
				if (pass == Slist.get(i).getPassword()) {
					check = 2;
				}
			}

		}
		return check;
	}

	public LinkedList<Seller> getSlist(){
		return Slist;
	}
	public LinkedList<Customer> getClist(){
		return Clist;
	}
	public void setClist(LinkedList<Customer> temp){
		Clist=temp;
	}
	public void setSlist(LinkedList<Seller> temp){
		 Slist=temp;
	}
}