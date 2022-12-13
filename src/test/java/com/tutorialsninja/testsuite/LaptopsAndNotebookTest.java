package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.LaptopsAndNotebooks;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LaptopsAndNotebookTest extends BaseTest {

    LaptopsAndNotebooks laptopsAndNotebooks;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        laptopsAndNotebooks = new LaptopsAndNotebooks();
    }

    //*************************************LaptopsAndNotbooks*************************************************
    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {

        laptopsAndNotebooks.clickOnLaptoptopLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.shortPriceLowToHigh();

    }

    //****************from 2.1 to 2.25************************
    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        laptopsAndNotebooks.changeCurrency();
        laptopsAndNotebooks.clickOnLaptoptopLink();
        laptopsAndNotebooks.clickOnAllLaptopAndNotebooksLink();
        laptopsAndNotebooks.sortByPriceHighToLowfromDropdown();
        laptopsAndNotebooks.clickOnMacbookLink();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyMacbook(), "MacBook", "Error Message not displayed");
        laptopsAndNotebooks.clickOnAddToCart();
        Assert.assertEquals(laptopsAndNotebooks.getVerifySuccess(), "Success: You have added MacBook to your shopping cart!\n" +
                "×", "Error Message not displayed");
        laptopsAndNotebooks.clickOnShoppingCart();
        //Assert.assertEquals(laptopsAndNotebooks.getVerifyCart(), "shopping cart", "Error Message not displayed");
        Assert.assertEquals(laptopsAndNotebooks.getVerifyProductMacbook(), "MacBook", "Error Message not displayed");
        laptopsAndNotebooks.clearTextInQuantityField();
        laptopsAndNotebooks.sendTextToQuantityField();
        Thread.sleep(3000);
        //Assert.assertEquals(laptopsAndNotebooks.getVerifyCarttext(), "Success: You have added MacBook to your shopping cart!\n" +
        //"×", "Error Message not displayed");
        //Assert.assertEquals(laptopsAndNotebooks.getVerifyTotal(), "£1,472.45", "Error Message not displayed");
        laptopsAndNotebooks.clickOnCheckoutCart();
        laptopsAndNotebooks.clickOnFinalCheckout();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyCheckout(), "Checkout", "Error Message not displayed");
        Thread.sleep(2000);
        Assert.assertEquals(laptopsAndNotebooks.getVerifyNewCustomer(), "New Customer", "Error Message not displayed");
        laptopsAndNotebooks.clickOnGuestCheckout();
        laptopsAndNotebooks.clickOnContinueTab();
        laptopsAndNotebooks.enterName("Prime");
        laptopsAndNotebooks.enterLastName("testing");
        laptopsAndNotebooks.enterEmail("prime1289@gmail.com");
        laptopsAndNotebooks.enterTelephone("123456789012");
        laptopsAndNotebooks.enterAddress("selenium");
        laptopsAndNotebooks.enterCity("adtala");
        laptopsAndNotebooks.enterPostcode("365430");
        laptopsAndNotebooks.enterCountry("Iceland");
        laptopsAndNotebooks.enterState("Austurland");
        laptopsAndNotebooks.clickOnCheckout();
        Thread.sleep(3000);
        laptopsAndNotebooks.enterText("thanks");
        laptopsAndNotebooks.clickOnTerms();
        laptopsAndNotebooks.clickContinue();
        Assert.assertEquals(laptopsAndNotebooks.getVerifyWarningMsg(), "Warning: Payment method required!\n" +
                "×", "Error Message not displayed");

    }

}