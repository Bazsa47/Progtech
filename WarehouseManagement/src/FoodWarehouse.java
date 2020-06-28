import java.util.ArrayList;

public class FoodWarehouse implements IObserver,IListOperation{

    private ArrayList<Product> foodList = new ArrayList<Product>();
    private MainWarehouse mw;

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

    public FoodWarehouse(MainWarehouse mw) {
        this.mw = mw;
        mw.addObserver(this);
    }

}
