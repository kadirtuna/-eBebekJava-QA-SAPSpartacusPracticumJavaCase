import java.util.ArrayList;

public class MobilePhone extends Product {
    int storage;
    float screenSize;
    int batteryPower;
    int ram;
    String color;

    public MobilePhone(float unitPrice, float discountRate, int stockQuantity, String productName, Brand brand, int storage, float screenSize, int batteryPower, int ram, String color){
        super(unitPrice, discountRate, stockQuantity, productName, brand);
        this.storage = storage;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    public static Product listById(int id){
        for(Product product: Product.products) {
            if(product.id == id && product instanceof MobilePhone)
                return product;
        }
        return new MobilePhone(0,0,0,null, new Brand("2"), 0, 0, 0, 0, "");
    }

    @Override
    public String toString(){
        return "Id: " + id + "\nUnitPrice: " + unitPrice + "\nDiscount Rate: " + discountRate + "\nStock Quantity: " + stockQuantity + "\nProduct Name: " + productName + "\nBrand: " + brand + "\nStorage: " + storage + "\nScreen Size: " + screenSize + "\nBattery Power: " + batteryPower + "\nRam: " + ram + "\nColor: " + color;
    }
}
