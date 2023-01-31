//Inventory.java

//declare package
package ShoppingCartV1;
import java.util.*;

/**
 * A single instance class which holds sorts products.
 * @author Lauren
 */
public class Inventory {
    /**
     * Constructor.
     */
    private Inventory() {   //single instance class
        
    }
    
    /**
     * Returns the single instance of the class.
     * @return class instance
     */
    public static Inventory getInstance() {
        return instance;
    }
    
    /**
     * Imports the product list.
     */
    public static void update() {
        productList = Product.getProductList();
    }
    
    /**
     * Sorts product list alphabetically ascending.
     */
    public void sortByABCUp() {
        Collections.sort(productList, Inventory.getCompByAlph());
    }
    
    /**
     * Sorts product list alphabetically descending.
     */
    public void sortByABDDown() {
        Collections.sort(productList, Inventory.getCompByAlphDesc());
    }
    
    /**
     * Sorts product list by price ascending.
     */
    public void sortByPriceUp() {
        Collections.sort(productList, Inventory.getCompByPrice());
    }
    
    /**
     * Sorts product list by price descending.
     */
    public void sortByPriceDown() {
        Collections.sort(productList, Inventory.getCompByPriceDesc());
    }
    
    /**
     * Returns comparator object for sorting alphabetically, ascending.
     * @return comparator object
     */
    private static Comparator<Product> getCompByAlph() {
        return new
            Comparator<Product>() {
                @Override
                public int compare (Product prod1, Product prod2) {
                    return prod1.getName().compareTo(prod2.getName());
                }
            };
    }
    
    /**
     * Returns comparator object for sorting alphabetically, descending.
     * @return comparator object
     */
    private static Comparator<Product> getCompByAlphDesc() {
        return new
            Comparator<Product>() {
                @Override
                public int compare (Product prod1, Product prod2) {
                    return prod2.getName().compareTo(prod1.getName());
                }
            };
    }
    
    /**
     * Returns comparator object for sorting by price, ascending.
     * @return comparator object
     */
    private static Comparator<Product> getCompByPrice() {
        return new
            Comparator<Product>() {
                @Override
                public int compare (Product prod1, Product prod2) {
                    return Double.valueOf(prod1.getSellingPrice()).compareTo(Double.valueOf(prod2.getSellingPrice()));
                }
            };
    }
    
    /**
     * Returns comparator object for sorting by price, descending.
     * @return comparator object
     */
    private static Comparator<Product> getCompByPriceDesc() {
        return new
            Comparator<Product>() {
                @Override
                public int compare (Product prod1, Product prod2) {
                    return Double.valueOf(prod2.getSellingPrice()).compareTo(Double.valueOf(prod1.getSellingPrice()));
                }
            };
    }
    
    /**
     * Returns the product list.
     * @return product list
     */
    public LinkedList getProductList() {
        return productList;
    }
    
    //class variables
    private static final Inventory instance = new Inventory();
    
    //instance variables
    private static LinkedList<Product> productList = Product.getProductList();
}
