import java.util.ArrayList;
import java.util.Iterator;

public class FoodWarehouse implements IObserver,IListOperation{

    private ArrayList<Product> foodList = new ArrayList<Product>();
    private MainWarehouse mw;

    public FoodWarehouse(MainWarehouse mw) {
        this.mw = mw;
        mw.addObserver(this);
    }

    @Override
    public void update(Product p, int quantity) {
        if (p.getType() == ProductType.Food)
            for (int i = 0; i < quantity; i++) {
                foodList.add(p);
            }
    }

    @Override
    public int getListSize(){
        return foodList.size();
    }

    @Override
    public void clearList() {
        this.foodList.clear();
    }

    @Override
    public void addProduct(Product p) {
        this.foodList.add(p);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Product> list = mw.getFoodWarehouse().foodList;
        for (Iterator<Product> iterator = list.iterator(); iterator.hasNext(); ) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                iterator.remove();
                return;
            }
        }
    }
}
