public interface IOrderCommand {
    public void order(Product p, int quantity, float balance);
    public void undo();
}
