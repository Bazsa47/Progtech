import java.util.ArrayList;
import java.util.Iterator;

public class ToyWarehouse implements IObserver, IListOperation{

    private ArrayList<Product> toyList = new ArrayList<Product>();
    private MainWarehouse mw;

    @Override
    public void update(Product p, int quantity) {
        if (p.getType() == ProductType.Toy)
            for (int i = 0; i < quantity; i++) {
                toyList.add(p);
            }
    }

    @Override
    public int getListSize(){
        return toyList.size();
    }

    @Override
    public void clearList() {
        this.toyList.clear();
    }

    @Override
    public void addProduct(Product p) {
        this.toyList.add(p);
    }

    @Override
    public void removeProduct(String name) {
        ArrayList<Product> list = mw.getToyWarehouse().toyList;

        for (Iterator<Product> iterator = list.iterator(); iterator.hasNext(); ) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                iterator.remove();
                return;
            }
        }
    }

    public ToyWarehouse(MainWarehouse mw) {
        this.mw = mw;
        mw.addObserver(this);
    }
}
