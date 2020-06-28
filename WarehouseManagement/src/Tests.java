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
        mw.importProduct(new Product("Toy",1999,ProductType.Toy),1);
        int expected = 1;
        int actual = mw.getToyWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void TestAddedFoodGetsIntoFoodWarehouse() {
        mw.importProduct(new Product("Food",1999,ProductType.Food),1);
        int expected = 1;
        int actual = mw.getFoodWarehouse().getListSize();
        Assert.assertEquals(expected,actual);
    }


}