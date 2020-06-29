public interface IOrderStrategy {
    public void orderProduct(Product p, int quantity, float balance) throws NotEnoughMoneyException;
    public void undoOrder();
}
