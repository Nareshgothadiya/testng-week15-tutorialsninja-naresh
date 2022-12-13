package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.Desktops;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooks;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class DesktopTest extends BaseTest {
    HomePage homePage;
    Desktops desktops;
    LaptopsAndNotebooks laptopsAndNotebooks;
    MyAccount myAccount;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        homePage = new HomePage();
        desktops = new Desktops();
        laptopsAndNotebooks = new LaptopsAndNotebooks();
        myAccount = new MyAccount();
    }

    //****************************************DesktopTest***************
    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphabeticalOrder() {

        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.verifyZtoAforDropDroDown();
    }

    //***************************From 2.1 to 2.15*****************
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        desktops.clickOnCurrencyLink();
        laptopsAndNotebooks.changeCurrency();
        homePage.clickOnDesktopLink();
        desktops.clickOnAllDesktop();
        desktops.SortByNameZtoAfromDropdown();
        desktops.clickOnHPlp3065();
        Assert.assertEquals(desktops.getVerifyTextHp(), "HP LP3065", "Error Message not displayed");
        desktops.selectDeliveryDate();
        //desktops.changeQuantity("1");
        desktops.clickOnAdToCart();
        Assert.assertEquals(desktops.getVerifyMessage(), "Success: You have added HP LP3065 to your shopping cart!\n" +
                "×", "Error Message not displayed");
        desktops.clickOnShppingCart();
        Thread.sleep(3000);
        Assert.assertEquals(desktops.getVerifyShoppingCart(), "Shopping Cart  (1.00kg)", "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyProductName(), "HP LP3065", "Error Message not displayed");
        //Assert.assertEquals(desktops.getVerifyDeliveryDate(), "2023-11-30", "Error Message not displayed");
        Assert.assertEquals(desktops.getVerifyModel(), "Product 21", "Error Message not displayed");
        Thread.sleep(2000);
        Assert.assertEquals(desktops.getVerifyTotal(), "£74.73", "Error Message not displayed");

    }
}
