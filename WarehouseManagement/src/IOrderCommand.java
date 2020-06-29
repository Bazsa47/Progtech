public interface IOrderCommand {
    public void order(Product p, int quantity, float balance) throws NotEnoughMoneyException;
    public void undo();
}
