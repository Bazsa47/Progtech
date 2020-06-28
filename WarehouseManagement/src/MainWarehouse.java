import java.util.ArrayList;
import java.util.function.IntConsumer;

public final class MainWarehouse implements IObservable{

    private ArrayList<IObserver> observerList = new ArrayList<IObserver>();
    static MainWarehouse mw = null;
    IOrderCommand command = new OrderCommand(this);
    ToyWarehouse tw;
    FoodWarehouse fw;


    public static MainWarehouse getInstance(){
        if (mw == null){
            mw = new MainWarehouse();
        }
        return mw;
    }

    private MainWarehouse() {
        this.tw = new ToyWarehouse(this);
        this.fw = new FoodWarehouse(this);
    }

    public void importProduct(Product product, int quantity){
        notifyObservers(product,quantity);
    }


    public ToyWarehouse getToyWarehouse() {
        return tw;
    }

    public FoodWarehouse getFoodWarehouse() {
        return fw;
    }

    public void Order(Product p, int quantity){
        command.order(p,quantity);
    }

    public void undoOrder(){
        command.undo();
    }

    @Override
    public void addObserver(IObserver o) {
        observerList.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {
        observerList.remove(o);
    }

    @Override
    public void notifyObservers(Product p, int quantity) {
        for (IObserver o : observerList) {
            o.update(p,quantity);
        }
    }
}
