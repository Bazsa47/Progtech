public interface IOrderCommand {
    public void order(Product p, int quantity);
    public void undo();
}
