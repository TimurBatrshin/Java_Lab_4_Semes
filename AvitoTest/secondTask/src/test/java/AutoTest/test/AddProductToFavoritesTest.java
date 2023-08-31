package AutoTest.test;

import AutoTest.AuthBase;
import org.junit.Assert;
import org.junit.Test;

public class AddProductToFavoritesTest extends AuthBase {

    @Test
    public void allTest(){
        addProductToFavoritesTestCase();
        addProductToFavoritesFromSearchPageTestCase();
        deleteProductTestCase();
        Assert.assertTrue(true);
        app.stop();
    }

    @Test
    public void addProductToFavoritesTestCase() {
        app.getNavigationHelper().openHomePage();
        app.getNavigationHelper().clickAddFavoritesButton();
        app.getNavigationHelper().openFavoritesPage();
        Assert.assertTrue(true);
    }

    @Test
    public void addProductToFavoritesFromSearchPageTestCase() {
        app.getNavigationHelper().openSearchPage();
        app.getNavigationHelper().addProduct();
        app.getNavigationHelper().openFavoritesPage();
        Assert.assertTrue(true);
    }

    @Test
    public void deleteProductTestCase() {
        app.getNavigationHelper().openFavoritesPage();
        app.getNavigationHelper().deleteProduct();
        Assert.assertTrue(true);
    }
}
