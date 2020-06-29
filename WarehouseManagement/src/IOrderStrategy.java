public interface IOrderStrategy {
    public void orderProduct(Product p, int quantity, float balance);
    public void undoOrder();
}
