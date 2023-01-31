//Product.java

//declare package
package ShoppingCartV1;
import java.util.*;

/**
 * A class for storing product information.
 * @author Lauren
 */
public class Product {
    /**
     * Default constructor.
     */
    public Product() {
        id = name = descr = null;
        seller = null;
        quantity = 0;
        sellPrice = basePrice = 0;
    }
    
    /**
     * Constructor.
     * @param id product id
     * @param name product name
     * @param sellPrice product selling price
     * @param basePrice product base price
     * @param quantity product quantity
     * @param description product description
     * @param seller  product seller
     */
    public Product (String id, String name, double sellPrice, double basePrice, int quantity, String description, Seller seller) {
        this.name = name;
        this.id = id;
        this.sellPrice = sellPrice;
        this.basePrice = basePrice;
        this.quantity = quantity;
        this.descr = description;
        this.seller = seller;
    }
    
    /**
     * Adds a product to product list, inventory list, and seller list.
     */
    public void add() {
        if (id == null) {
            System.err.println("No product ID.");
        }
        else if (productList.indexOf(id) != -1) {
            System.err.println("Product already exists");
        }
        else {
            productList.add(this);
            updateInventory();
            seller.refreshMyProducts();
        }
    }
    
    /**
     * Removes a product from the product list via ID.
     * @param id ID of the product
     */
    public void delete(String id) {
        int index = productList.indexOf(id);
        if (index == -1) {
            System.err.println("Product ID not valid");
        }
        else {
            productList.remove(index);
            updateInventory();
        }
    }
    
    /**
     * Updates product quantity, adds sold items to seller sold list.
     * @param quantitySold quantity of the product sold
     */
    public void sold(int quantitySold) {
        quantity -= quantitySold;

        for (int i = 0; i < quantitySold; i++) {    //adds 1 sold product to list
            seller.addToSoldProducts(new Product(id, name, sellPrice, basePrice, 1, descr, seller));
        }
        
        if (quantity == 0) {
            delete(this.id);
        }
    }
    
    /**
     * Updates all product parameters.
     * @param oldID old ID of the product
     * @param newID new ID of the product
     * @param newName new name of the product
     * @param newPrice new price of the product
     * @param newQuantity new quantity of the product
     * @param newDescr new description of the product
     */
    public void update(String oldID, String newID, String newName, double newPrice, int newQuantity, String newDescr) {
        if (productList.indexOf(newID) == -1) {
            //delete(oldID);
            this.name = newName;
            this.id = newID;
            this.sellPrice = newPrice;
            this.quantity = newQuantity;
            this.descr = newDescr;
            //add();
        }
        else {
            System.err.println("Product already exists.");
        }
    }
    
    /**
     * Returns the list of products
     * @return list of products
     */
    public static LinkedList getProductList() {
        return productList;
    }
    
    /**
     * Returns the name of the product
     * @return product name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the quantity of the product
     * @return product quantity
     */
    public int getQuantity() {
        return quantity;
    }
    
    /**
     * Updates the quantity of the product
     * @param quantity desired quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * Returns the description of the product.
     * @return product description
     */
    public String getDescription() {
        return descr;
    }
    
    /**
     * Returns the selling price of the product
     * @return product selling price.
     */
    public double getSellingPrice() {
        return sellPrice;
    }
    
    /**
     * Returns the base price of the product.
     * @return product base price
     */
    public double getBasePrice() {
        return basePrice;
    }
    
    /**
     * Returns the seller of the product
     * @return product seller
     */
    public Seller getSeller() {
        return seller;
    }
    
    /**
     * Updates the inventory product list with the current product list.
     */
    private void updateInventory() {
        Inventory.getInstance().update();
    }
    
    /**
     * Returns a copy of the product.
     * @return product clone
     */
    public Product getCopy() /*throws CloneNotSupportedException*/{
        //return (Product)this.clone();
        return this;
    }
    
    /**
     * Updates the name of the product
     * @param name product name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Updates the description of the product
     * @param descr product description
     */
    public void setDescription(String descr) {
        this.descr = descr;
    }
    
    /**
     * Updates the selling price of the product
     * @param price product selling price
     */
    public void setSellingPrice(double price) {
        this.sellPrice = price;
    }
    
    /**
     * Updates the seller of the product
     * @param sell product seller
     */
    public void setSeller(Seller sell) {
        this.seller = sell;
    }
    
    /**
     * Updates the quantity of a product inside a cart.
     * @param num amount of product inside cart
     */
    public void setNum(int num) {
        this.num = num;
    }
    
    /**
     * Returns the amount of product inside a cart
     * @return product amount inside cart
     */
    public int getNum() {
        return num;
    }
    
    //class variables
    private static LinkedList<Product> productList = new LinkedList<>();
    
    //instance variables
    private String name = null, id = null, descr = null;
    private double sellPrice = 0, basePrice = 0;
    private int quantity = 0, num = 0;
    private Seller seller = null;
}
