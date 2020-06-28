public class OrderCommand implements IOrderCommand{

    MainWarehouse mw;

    public OrderCommand(MainWarehouse mw) {
        this.mw = mw;
    }

    private boolean canUndo = false;
    private Product p;
    private int quantity;

    @Override
    public void order(Product p, int quantity) {
        this.p = p;
        this.quantity=quantity;
            switch(p.getType()) {
                case Food:
                    for (int i = 0; i < quantity; i++) {
                        mw.getFoodWarehouse().removeProduct(p.getName());
                    }
                    break;
                case Toy:
                    for (int i = 0; i < quantity; i++) {
                        mw.getToyWarehouse().removeProduct(p.getName());
                    }
                    break;
                default:
            }
            canUndo = true;
    }

    @Override
    public void undo() {
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
        }else{
            System.out.println("Nothing to undo!");
        }
    }
}
