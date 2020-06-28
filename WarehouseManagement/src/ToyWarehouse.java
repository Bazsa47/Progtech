import java.util.ArrayList;

public class ToyWarehouse implements IObserver{

    private ArrayList<Product> toyList = new ArrayList<Product>();
    private MainWarehouse mw;

    @Override
    public void update(Product p, int quantity) {
        if (p.getType() == ProductType.Toy)
            for (int i = 0; i < quantity; i++) {
                toyList.add(p);
            }
    }

    public int getListSize(){
        return toyList.size();
    }

    public ToyWarehouse(MainWarehouse mw) {
        this.mw = mw;
        mw.addObserver(this);
    }
}
