import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Store store = new Store("PatikaStore");

        Brand samsung = new Brand("Samsung");
        Brand lenovo = new Brand("Lenovo");
        Brand apple = new Brand("Apple");
        Brand huawei = new Brand("Huawei");
        Brand casper = new Brand("Casper");
        Brand asus = new Brand("Asus");
        Brand hp = new Brand("Hp");
        Brand xiaomi = new Brand("Xiaomi");
        Brand monster = new Brand("Monster");

        MobilePhone mobilePhoneObj1 = new MobilePhone(15000, 20, 58, "iPhone 11", apple, 128, 5.8f, 3000, 4, "White");
        MobilePhone mobilePhoneObj2 = new MobilePhone(10000, 15, 37, "iPhone 8 Plus", apple, 64, 5.5f, 2800, 3, "Gold");
        MobilePhone mobilePhoneObj3 = new MobilePhone(20000, 25, 13, "iPhone 12", apple, 128, 6.1f, 3500, 6, "Black");
        MobilePhone mobilePhoneObj4 = new MobilePhone(15000, 15, 42, "Huawei Nova 10 Pro", huawei, 128, 6.3f, 4000, 6, "Rose");
        MobilePhone mobilePhoneObj5 = new MobilePhone(7500, 25, 103, "Xiaomi Mi 11 ", xiaomi, 128, 5.1f, 3500, 3, "White");
        MobilePhone mobilePhoneObj6 = new MobilePhone(4999, 5, 251, "Xiaomi Redmi 9C ", xiaomi, 64, 5.5f, 3900, 3, "Blue");
        MobilePhone mobilePhoneObj7 = new MobilePhone(24999, 25, 14, "Samsung Galaxy Z Fold4", samsung, 128, 6.6f, 4800, 8, "White");
        MobilePhone mobilePhoneObj8 = new MobilePhone(24999, 25, 14, "Samsung Galaxy S22", samsung, 64, 5.1f, 2900, 3, "Pink");

        Notebook notebookObj1 = new Notebook(25000, 15, 13, "Monster Abra A5 v9.1", monster, 1000, 17.3f, 16);
        Notebook notebookObj2 = new Notebook(33000, 20, 8, "Monster Abra A7 v10.1", monster, 256, 17.3f, 32);
        Notebook notebookObj3 = new Notebook(17000, 15, 25, "Lenovo V15", lenovo, 256, 15.6f, 8);
        Notebook notebookObj4 = new Notebook(12000, 20, 37, "Asus X543MA", asus, 512, 15.6f, 8);
        Notebook notebookObj5 = new Notebook(19999, 10, 19, "Casper Nirvana C600", casper, 512, 15.6f, 16);
        Notebook notebookObj6 = new Notebook(30999, 15, 7, "HP 4H1T0EA Spectre X360", hp, 512, 14f, 32);
        Notebook notebookObj7 = new Notebook(9999, 5, 54, "HP 6Q8N2ES 255 G9", hp, 512, 15.6f, 4);
        Notebook notebookObj8 = new Notebook(7999, 20, 65, "HP 4H262EA İntel Celeron", hp, 256, 15.6f, 4);

        Scanner scan = new Scanner(System.in);

        Boolean control = true;
        int counter = 0;

        while (control) {
            if(counter == 0){
                Menu();
            }
            else{

                System.out.print("Type a key for the menu!");
                System.in.read();
                Menu();
            }

            counter++;
            System.out.print("\nType your selection number for Menu: ");
            int selection = scan.nextInt();

            switch (selection) {
                case 1:
                    System.out.println("\nWould you like to list category-");
                    System.out.println("1-Notebook");
                    System.out.println("2-Mobile Phone");
                    System.out.println("Type the category number: ");
                    selection = scan.nextInt();
                    if(selection == 1){
                        for(Product product: Product.products){
                            if(product instanceof Notebook){
                                System.out.println(product);
                                System.out.println(endPoint());
                            }
                        }
                    }
                    else{
                        for(Product product: Product.products){
                            if(product instanceof MobilePhone){
                                System.out.println(product);
                                System.out.println(endPoint());
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("\nAll Notebooks;");
                    System.out.format("%12s %16s %16s %16s %32s %12s %8s %12s %8s\n", "Product Id", "Price", "Discount Rate", "Stock Quantity", "Product Name", "Brand", "Storage", "Screen Size", "Ram");

                    for(Product product: Product.products) {
                        if (product instanceof Notebook) {
                            System.out.format("%12s %16s %16s %16s %32s %12s %8s %12s %8s\n", product.id, product.unitPrice +" TL", product.discountRate, product.stockQuantity + " Pieces", product.productName, product.brand, (((Notebook) product).storage + " GB"), ((Notebook) product).screenSize + " Inch", ((Notebook) product).ram + " GB");
                        }
                    }

                    System.out.println("\nAll Mobile Phones;");
                    System.out.format("%12s %16s %16s %16s %32s %12s %8s %12s %16s %8s %12s\n", "Product Id", "Price", "Discount Rate", "Stock Quantity", "Product Name", "Brand", "Storage", "Screen Size", "Battery Power", "Ram", "Color");

                    for(Product product: Product.products) {
                        if (product instanceof MobilePhone) {
                            System.out.format("%12s %16s %16s %16s %32s %12s %8s %12s %16s %8s %12s\n", product.id, product.unitPrice +" TL", product.discountRate, product.stockQuantity + " Pieces", product.productName, product.brand, (((MobilePhone) product).storage + " GB"), ((MobilePhone) product).batteryPower + " mAH",((MobilePhone) product).screenSize + " Inch", ((MobilePhone) product).ram + " GB", ((MobilePhone) product).color);
                        }
                    }
                    System.out.println(endPoint());
                    break;
                case 3:
                    System.out.println("\nWould you like to add-");
                    System.out.println("1-Notebook");
                    System.out.println("2-Mobile Phone");
                    System.out.println("Type the category number: ");
                    selection = scan.nextInt();

                    System.out.println("\nEnter all attributes until they end!");
                    System.out.print("Price: ");
                    float unitPrice = scan.nextFloat();
                    System.out.print("Discount Rate: ");
                    float discountRate = scan.nextFloat();
                    System.out.print("Stock Quantity: ");
                    int stockQuantity = scan.nextInt();
                    System.out.print("Product's name: ");
                    String productName = scan.next();
                    System.out.print("Select the brand: \n");

                    for (int i = 0; i < Brand.brands.size() ; i++) {
                        System.out.print((i + 1) + "-" + Brand.brands.get(i) + "\n");
                    }

                    Brand brand = Brand.brands.get(scan.nextInt() - 1);

                    switch (selection){
                        case 1:
                            System.out.print("Ram: ");
                            int ram = scan.nextInt();
                            System.out.print("Storage: ");
                            int storage = scan.nextInt();
                            System.out.print("Screen Size: ");
                            float screenSize = scan.nextFloat();
                            new Notebook(unitPrice, discountRate, stockQuantity, productName, brand, storage, screenSize, ram);
                            System.out.println("The new Notebook is successfully added!\n");
                            break;

                        case 2:
                            System.out.print("Storage: ");
                            storage = scan.nextInt();
                            System.out.print("Screen Size: ");
                            screenSize = scan.nextFloat();
                            System.out.print("Battery Power: ");
                            int batteryPower = scan.nextInt();
                            System.out.print("Ram: ");
                            ram = scan.nextInt();
                            System.out.print("Color: ");
                            String color = scan.next();
                            new MobilePhone(unitPrice, discountRate, stockQuantity, productName, brand, storage, screenSize, batteryPower, ram, color);
                            System.out.println("The new Mobile Phone is successfully added!\n");
                            break;
                    }
                    System.out.println(endPoint());
                    break;
                case 4:
                    System.out.println("\nType the Id of the product that you would like to delete: ");
                    int id = scan.nextInt();
                    if(Product.remove(id))
                        System.out.println("The product with id " + id + " is succesfully removed!");
                    else
                        System.out.println("Given id couldn't be found in the products!");
                    System.out.println(endPoint());
                    break;
                case 5:
                    System.out.println("\n1-List by given id.");
                    System.out.println("2-List by brand.");
                    System.out.print("\nType the selection: ");
                    selection = scan.nextInt();

                    switch (selection){
                        case 1:
                            System.out.print("\nType the id that you'd like to list: ");
                            id = scan.nextInt();

                            for(Product product: Product.products) {
                                if (product.id == id && product instanceof Notebook) {
                                    System.out.format("\n%12s %12s %16s %16s %16s %32s %12s %8s %12s %8s\n", "Product Type", "Product Id", "Price", "Discount Rate", "Stock Quantity", "Product Name", "Brand", "Storage", "Screen Size", "Ram");
                                    System.out.format("%12s %12s %16s %16s %16s %32s %12s %8s %12s %8s\n", "Notebook", product.id, product.unitPrice +" TL", product.discountRate, product.stockQuantity + " Pieces", product.productName, product.brand, (((Notebook) product).storage + " GB"), ((Notebook) product).screenSize + " Inch", ((Notebook) product).ram + " GB");
                                    break;
                                }
                                else if(product.id == id && product instanceof MobilePhone){
                                    System.out.format("\n%12s %12s %16s %16s %16s %32s %12s %8s %12s %16s %8s %12s\n", "Product Type", "Product Id", "Price", "Discount Rate", "Stock Quantity", "Product Name", "Brand", "Storage", "Screen Size", "Battery Power", "Ram", "Color");
                                    System.out.format("%12s %12s %16s %16s %16s %32s %12s %8s %12s %16s %8s %12s\n", "Mobile Phone", product.id, product.unitPrice +" TL", product.discountRate, product.stockQuantity + " Pieces", product.productName, product.brand, (((MobilePhone) product).storage + " GB"), ((MobilePhone) product).batteryPower + " mAH",((MobilePhone) product).screenSize + " Inch", ((MobilePhone) product).ram + " GB", ((MobilePhone) product).color);
                                    break;
                                }
                            }
                            break;
                        case 2:
                            System.out.println(endPoint());
                            System.out.println("Select the brand to list by it");

                            for (int i = 0; i < Brand.brands.size() ; i++) {
                                System.out.print((i + 1) + "-" + Brand.brands.get(i) + "\n");
                            }

                            brand = Brand.brands.get(scan.nextInt() - 1);

                            System.out.println(endPoint());
                            System.out.println("\nFor " + brand + " brand;\n\n-Notebooks;");
                            System.out.format("%12s %12s %16s %16s %16s %32s %12s %8s %12s %8s\n", "Product Type", "Product Id", "Price", "Discount Rate", "Stock Quantity", "Product Name", "Brand", "Storage", "Screen Size", "Ram");

                            for(Product product: Product.products){
                                if(product.brand == brand && product instanceof Notebook){
                                        System.out.format("%12s %12s %16s %16s %16s %32s %12s %8s %12s %8s\n", "Notebook", product.id, product.unitPrice +" TL", product.discountRate, product.stockQuantity + " Pieces", product.productName, product.brand, (((Notebook) product).storage + " GB"), ((Notebook) product).screenSize + " Inch", ((Notebook) product).ram + " GB");
                                }
                            }

                            System.out.println("\n-Mobile Phones;");
                            System.out.format("%12s %12s %16s %16s %16s %32s %12s %8s %12s %16s %8s %12s\n", "Product Type", "Product Id", "Price", "Discount Rate", "Stock Quantity", "Product Name", "Brand", "Storage", "Screen Size", "Battery Power", "Ram", "Color");

                            for(Product product: Product.products){
                                if(product.brand == brand && product instanceof MobilePhone){
                                    System.out.format("%12s %12s %16s %16s %16s %32s %12s %8s %12s %16s %8s %12s\n", "Mobile Phone", product.id, product.unitPrice +" TL", product.discountRate, product.stockQuantity + " Pieces", product.productName, product.brand, (((MobilePhone) product).storage + " GB"), ((MobilePhone) product).batteryPower + " mAH",((MobilePhone) product).screenSize + " Inch", ((MobilePhone) product).ram + " GB", ((MobilePhone) product).color);
                                }
                            }
                            break;
                    }
                    System.out.println(endPoint());
                    break;
                case 6:
                    control = false;
                    System.out.println("You succesfully quited from the application.");
                    System.out.println(endPoint());
                    break;
            }
        }
    }

    public static String endPoint(){
        return "------------------------------------------------------------------------------------------------------------------";
    }

    public static void Menu(){
        System.out.println("---------------------------MENU--------------------------");
        System.out.println("1-List the products as the selected category.");
        System.out.println("2-List all products.");
        System.out.println("3-Add a product.");
        System.out.println("4-Delete a product with its Id.");
        System.out.println("5-List the products with the filter.");
        System.out.println("6-Quit from the console.");
        System.out.println("---------------------------------------------------------");
    }
}
