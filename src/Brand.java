import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Brand {
    static final AtomicInteger count = new AtomicInteger(0);
    final int id;
    String name;
    static ArrayList<Brand> brands = new ArrayList<Brand>();

    public Brand(String name){
        id = count.incrementAndGet();
        this.name = name;
        brands.add(this);
    }
    public String toString(){
        return name;
    }
}
