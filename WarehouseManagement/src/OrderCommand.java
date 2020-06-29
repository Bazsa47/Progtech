public class OrderCommand implements IOrderCommand{

    MainWarehouse mw;
    IOrderStrategy os;

    public OrderCommand(MainWarehouse mw, IOrderStrategy os) {
        this.mw = mw;
        this.os = os;
    }

    @Override
    public void order(Product p, int quantity, float balance) throws NotEnoughMoneyException {
       os.orderProduct(p,quantity,balance);
    }

    @Override
    public void undo() {
        os.undoOrder();
    }
}
