import java.util.ArrayList;

public final class MainWarehouse implements IObservable{

    private ArrayList<IObserver> observerList = new ArrayList<IObserver>();
    static MainWarehouse mw = null;
    ToyWarehouse tw;
    FoodWarehouse fw;



    public static MainWarehouse getInstance(){
        if (mw == null){
            mw = new MainWarehouse(new ToyWarehouse(), new FoodWarehouse());
        }
        return mw;

    }

    private MainWarehouse(ToyWarehouse tw, FoodWarehouse fw) {
        this.tw = tw;
        this.fw = fw;
        addObserver(tw);
        addObserver(fw);
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
