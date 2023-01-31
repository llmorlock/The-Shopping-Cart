//Seller.java

//declare package
package ShoppingCartV1;
import java.util.*;

/**
 * A class which holds information about a seller and keeps track of their products.
 * @author Lauren
 */
public class Seller {
    /**
     * Default constructor.
     */
    public Seller() {
        username = password = email = address = company = null;
    }
    
    /**
     * Constructor.
     * @param user seller username
     * @param pass seller password
     */
    public Seller(String user, String pass) {
        username = user;
        password = pass;
    }
    
    /**
     * Constructor.
     * @param username username of seller
     * @param password password of seller
     * @param email email of seller
     * @param address address of seller
     * @param company company of seller
     */
    public Seller(String username, String password, String email, String address, String company) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.company = company;
        this.sellerID = generateSellerID();
    }
    
    /**
     * Generates a unique pseudorandom ID for a seller.
     * @return unique seller ID
     */
    private static int generateSellerID() {
        int min = 1, max = 32767;
        int ID = min + (int)(Math.random() * (max - min + 1));
        
        while (sellerIDs.indexOf(ID) != -1) {
            ID = min + (int)(Math.random() * (max - min + 1));
        }
        sellerIDs.add(ID);
        
        return ID;
    }
    
    /**
     * Updates the address of the seller
     * @param address seller new address
     */
    public void updateAddress(String address) {
        this.address = address;
    }
    
    /**
     * Updates the email of the seller.
     * @param email seller new email
     */
    public void updateEmail(String email) {
        this.email = email;
    }
    
    /**
     * Updates the company of the seller
     * @param company seller new company
     */
    public void updateCompany(String company) {
        this.company = company;
    }
    
    /**
     * Gets the unique ID of the seller
     * @return seller unique id
     */
    public int getID() {
        return sellerID;
    }
    
    /**
     * Refreshes list of products seller has on the market.
     */
    public void refreshMyProducts() {
        myProducts.clear();
        LinkedList<Product> allProds = Product.getProductList();
        ListIterator<Product> iterator = allProds.listIterator();
        
        while (iterator.hasNext()) {
            Seller seller = iterator.next().getSeller();
            if (Integer.valueOf(seller.getID()).equals(Integer.valueOf(this.getID()))) {
                myProducts.add(iterator.previous());
                iterator.next();
            }
        }
    }
    
    /**
     * Returns the list of products associated with the seller.
     * @return list of seller products
     */
    public LinkedList getMyProducts() {
        return myProducts;
    }
    
    /**
     * Adds a product to the sold list and calls for a revenue update.
     * @param product 
     */
    public void addToSoldProducts(Product product) {
        soldProducts.add(product);
        
        addToRevenue(product);
    }
    
//    private void reCalcRevenue() {
//        revenue = 0;
//        ListIterator<Product> iterator = soldProducts.listIterator();
//        
//        while (iterator.hasNext()) {
//            revenue += iterator.next().getSellingPrice() - iterator.previous().getBasePrice();  //cursor starts and ends in same position
//            iterator.next();
//        }
//    }
    
    /**
     * Adds a products selling price - base price to a seller's revenue.
     * @param product 
     */
    private void addToRevenue(Product product) {
        revenue += product.getSellingPrice() - product.getBasePrice();
    }
    
    /**
     * Returns the revenue of the seller
     * @return seller revenue
     */
    public double getRevenue() {
        return revenue;
    }
    
    /**
     * Returns the password of the seller
     * @return seller password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Updates the password of the seller.
     * @param pass seller password
     */
    public void setPassword(String pass) {
        this.password = pass;
    }
    
    /**
     * Updates the username of the seller.
     * @param username seller username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Returns the username of the seller
     * @return seller username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Adds a product to the seller's product list
     * @param prod product to add
     */
    public void addToMyProducts(Product prod) {
        prod.setSeller(this);
        myProducts.add(prod);
    }
    
    //class variables
    private static ArrayList<Integer> sellerIDs = new ArrayList<>();
    
    //instance variables
    private String username = null, password = null, email = null, address = null, company = null;
    private int sellerID = 0;
    private double revenue = 0;
    private LinkedList<Product> myProducts = new LinkedList<>(), soldProducts = new LinkedList<>();
}
