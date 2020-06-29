public class PremiumCustomerOrderStrategy implements IOrderStrategy{

    private boolean canUndo = false;
    private Product p;
    private int quantity;

    MainWarehouse mw;

    public PremiumCustomerOrderStrategy(MainWarehouse mw) {
        this.mw = mw;
    }

    @Override
    public void orderProduct(Product p, int quantity, float balance) {
        this.p = p;
        this.quantity=quantity;
        switch(p.getType()) {
            case Food:
                if(quantity*p.getPrice()*1.27f <= balance)
                    for (int i = 0; i < quantity; i++) {
                        mw.getFoodWarehouse().removeProduct(p.getName());
                    }
                break;
            case Toy:
                if(quantity*p.getPrice()*1.27f <= balance)
                    for (int i = 0; i < quantity; i++) {
                        mw.getToyWarehouse().removeProduct(p.getName());
                    }
                break;
            default:
        }
        canUndo = true;

    }

    @Override
    public void undoOrder() {
        if (canUndo){
            switch(p.getType()) {
                case Food:
                    for (int i = 0; i < quantity; i++) {
                        mw.getFoodWarehouse().addProduct(p);
                    }
                    break;
                case Toy:
                    for (int i = 0; i < quantity; i++) {
                        mw.getToyWarehouse().addProduct(p);
                    }
                    break;
                default:
            }
            canUndo = true;
        }
    }
}