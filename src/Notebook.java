import java.util.ArrayList;

public class Notebook extends Product {
    int ram;
    int storage;
    float screenSize;

    public Notebook(float unitPrice, float discountRate, int stockQuantity, String productName, Brand brand, int storage, float screenSize, int ram){
        super(unitPrice, discountRate, stockQuantity, productName, brand);
        this.ram = ram;
        this.storage = storage;
        this.screenSize = screenSize;
    }

    public static Product listById(int id){
        for(Product product: Product.products) {
            if(product.id == id && product instanceof Notebook)
                return product;
        }
        return new Notebook(0,0,0,null, new Brand("2"), 0, 0, 0);
    }

    @Override
    public String toString(){
        return "Id: " + id + "\nUnitPrice: " + unitPrice + "\nDiscount Rate: " + discountRate + "\nStock Quantity: " + stockQuantity + "\nProduct Name: " + productName + "\nBrand: " + brand + "\nStorage: " + storage + "\nScreen Size: " + screenSize + "\nRam: " + ram;
    }
}
