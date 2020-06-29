import org.junit.*;

public class Tests {


    MainWarehouse mw = MainWarehouse.getInstance();

    @Test
    public void TestMainWarehouseIsSingleton() {
        MainWarehouse mw2 = MainWarehouse.getInstance();
        Object expected = mw;
        Object actual = mw2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestAddedToyGetsIntoToyWarehouse() {
        int expected = mw.getToyWarehouse().getListSize()+1000;
        mw.importProduct(new Product("Toy",1999,ProductType.Toy),1000);
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestAddedFoodGetsIntoFoodWarehouse() {
        int expected = mw.getFoodWarehouse().getListSize()+1000;
        mw.importProduct(new Product("Food",1999,ProductType.Food),1000);
        int actual = mw.getFoodWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }


    @Test
    public void TestOrderFood() {
        int expected = mw.getFoodWarehouse().getListSize()-10;
        Customer c = new Customer("Test","Eger",999999,new BasicCustomerOrderStrategy(mw));
        c.Order(new Product("Food",1999,ProductType.Food),10,c.getBalance());
        int actual = mw.getFoodWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestOrderToy() {
        int expected = mw.getToyWarehouse().getListSize()-10;
        Customer c = new Customer("Test","Eger",999999,new BasicCustomerOrderStrategy(mw));
        c.Order(new Product("Toy",1999,ProductType.Toy),10,c.getBalance());
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestUndoOrderToy() {
        mw.importProduct(new Product("Toy",1999,ProductType.Toy),1000);
        int expected = mw.getToyWarehouse().getListSize();
        Customer c = new Customer("Test","Eger",999999,new BasicCustomerOrderStrategy(mw));
        c.Order(new Product("Toy",1999,ProductType.Toy),10,c.getBalance());
        c.undoOrder();
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestUndoOrderFood() {
        mw.importProduct(new Product("Food",1999,ProductType.Food),1000);
        int expected = mw.getFoodWarehouse().getListSize();
        Customer c = new Customer("Test","Eger",999999,new BasicCustomerOrderStrategy(mw));
        c.Order(new Product("Food",1999,ProductType.Food),10,c.getBalance());
        c.undoOrder();
        int actual = mw.getFoodWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestCustomerDoesNotHaveEnoughMoney() {
        Product p = new Product("Test",1000,ProductType.Toy);
        mw.importProduct(p,1000);
        int expected = mw.getToyWarehouse().getListSize();
        Customer c = new Customer("Test","Eger",3000,new BasicCustomerOrderStrategy(mw));
        c.Order(p,4,c.getBalance());
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestCustomerHasEnoughMoney() {
        Product p = new Product("Test",1000,ProductType.Toy);
        mw.importProduct(p,1000);
        int expected = mw.getToyWarehouse().getListSize()-4;
        Customer c = new Customer("Test","Eger",30000,new BasicCustomerOrderStrategy(mw));
        c.Order(p,4,c.getBalance());
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestPremiumCustomerDoesNotHaveEnoughMoney() {
        Product p = new Product("Test",1001,ProductType.Toy);
        mw.importProduct(p,1000);
        int expected = mw.getToyWarehouse().getListSize();
        Customer c = new Customer("Test","Eger",3000,new PremiumCustomerOrderStrategy(mw));
        c.Order(p,3,c.getBalance());
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestPremiumCustomerHasEnoughMoney() {
        Product p = new Product("Test",1001,ProductType.Toy);
        mw.importProduct(p,1000);
        int expected = mw.getToyWarehouse().getListSize();
        Customer c = new Customer("Test","Eger",3003,new PremiumCustomerOrderStrategy(mw));
        c.Order(p,3,c.getBalance());
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }
}