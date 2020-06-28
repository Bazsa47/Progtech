import java.util.ArrayList;

public class FoodWarehouse implements IObserver{

    private ArrayList<Product> foodList = new ArrayList<Product>();

    @Override
    public void update(Product p, int quantity) {
        if (p.getType() == ProductType.Food)
            for (int i = 0; i < quantity; i++) {
                foodList.add(p);
            }
    }

    public int getListSize(){
        return foodList.size();
    }
}
