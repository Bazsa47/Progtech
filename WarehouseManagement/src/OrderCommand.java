public class OrderCommand implements IOrderCommand{

    MainWarehouse mw;
    IOrderStrategy os;

    public OrderCommand(MainWarehouse mw, IOrderStrategy os) {
        this.mw = mw;
        this.os = os;
    }

    private boolean canUndo = false;
    private Product p;
    private int quantity;

    @Override
    public void order(Product p, int quantity, float balance) {
       os.orderProduct(p,quantity,balance);
    }

    @Override
    public void undo() {
        os.undoOrder();
    }
}
