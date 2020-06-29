public class Customer {

    private String name;
    private String address;
    private float balance;
    IOrderCommand command;

    public Customer(String name, String address, float balance, IOrderStrategy os) {
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.command = new OrderCommand(MainWarehouse.getInstance(),os);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void Order(Product p, int quantity,float balance) throws NotEnoughMoneyException {
        command.order(p,quantity,balance);
    }

    public void undoOrder(){
        command.undo();
    }
}
