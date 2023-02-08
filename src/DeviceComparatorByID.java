import java.util.Comparator;

public class DeviceComparatorByID implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        if(o1.getId() > o2.getId()){
            return 1;
        }else if(o1.getId() < o2.getId()){
            return -1;
        }
        else{
            return 0;
        }
    }
    
}
