import java.util.Comparator;

public class DeviceComparatorByBrand implements Comparator<Product>{

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getBrand().getName().compareTo(o2.getBrand().getName());
    }
    
}
