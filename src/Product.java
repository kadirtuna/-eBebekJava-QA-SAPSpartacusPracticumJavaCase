import javax.swing.*;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    static final AtomicInteger count = new AtomicInteger(0);
    final int id;
    float unitPrice;
    float discountRate;
    int stockQuantity;
    String productName;
    Brand brand;
    static ArrayList<Product> products = new ArrayList<Product>();

    public Product(float unitPrice, float discountRate, int stockQuantity, String productName, Brand brand){
        id = count.incrementAndGet();
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockQuantity = stockQuantity;
        this.productName = productName;
        this.brand = brand;
        products.add(this);
    }

    public static Boolean remove(int id){
        for(Product product: Product.products){
            if(product.id == id) {
                Product.products.remove(product);
                return true;
            }
        }
        return false;
    }

    public static Product listById(int id){
        for(Product product: Product.products) {
            if(product.id == id)
                return product;
        }
        return new Product(0,0,0,null,new Brand("0"));
    }


    public String toString(){
        return "Id: " + id + "\nUnitPrice: " + unitPrice + "\nDiscount Rate: " + discountRate + "\nStock Quantity: " + stockQuantity + "\nProduct Name: " + productName + "\nBrand: " + brand;
    }
}
