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
        mw.Order(new Product("Food",1999,ProductType.Food),10);
        int actual = mw.getFoodWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestOrderToy() {
        int expected = mw.getToyWarehouse().getListSize()-10;
        mw.Order(new Product("Toy",1999,ProductType.Toy),10);
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestUndoOrderToy() {
        mw.importProduct(new Product("Toy",1999,ProductType.Toy),1000);
        int expected = mw.getToyWarehouse().getListSize();
        mw.Order(new Product("Toy",1999,ProductType.Toy),10);
        mw.undoOrder();
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestUndoOrderFood() {
        mw.importProduct(new Product("Food",1999,ProductType.Food),1000);
        int expected = mw.getFoodWarehouse().getListSize();
        mw.Order(new Product("Food",1999,ProductType.Food),10);
        mw.undoOrder();
        int actual = mw.getFoodWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }
}