package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Desktops extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;

    public void clickOnCurrencyLink() {
        Reporter.log("clickOnCurrencyLink" + currencyLink.toString());
        clickOnElement(currencyLink);
    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Desktops')]")
    WebElement clickOnShowAllDeskTop;

    public void clickOnAllDesktop() {
        Reporter.log("clickOnAllDesktop" + clickOnShowAllDeskTop.toString());
        clickOnElement(clickOnShowAllDeskTop);
    }

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByNameZtoA;

    public void SortByNameZtoAfromDropdown() {
        Reporter.log("SortByNameZtoAfromDropdown" + sortByNameZtoA.toString());
        sendTextToElement(sortByNameZtoA, "Name (Z - A)");

    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement clickOnHpLp3065;

    public void clickOnHPlp3065() {
        Reporter.log("clickOnHPlp3065" + clickOnHpLp3065.toString());
        clickOnElement(clickOnHpLp3065);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyText;
    ;

    public String getVerifyText() {
        Reporter.log("getVerifyText" + verifyText.toString());
        return getTextFromElement(verifyText);
    }

    @CacheLookup
    @FindBy(name = "quantity")
    WebElement selectQuantity;

    public void changeQuantity(String quantity) {
        Reporter.log("changeQuantity" + selectQuantity.toString());
        sendTextToElement(selectQuantity, quantity);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;
    ;


    public void clickOnAdToCart() {
        Reporter.log("clickOnAdToCart" + addToCart.toString());
        clickOnElement(addToCart);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement verifyHPlp3065;

    public String getVerifyProductName() {
        Reporter.log("getVerifyProductNam" + verifyHPlp3065.toString());
        return getTextFromElement(verifyHPlp3065);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement verifyTextHPlp3065;

    public String getVerifyTextHp() {
        Reporter.log("getVerifyTextHp" + verifyTextHPlp3065.toString());
        return getTextFromElement(verifyTextHPlp3065);
    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement clickShoppingCart;


    public void clickOnShppingCart() {
        Reporter.log("clickOnShppingCart" + clickShoppingCart.toString());
        clickOnElement(clickShoppingCart);

    }

    @CacheLookup
    @FindBy(css = "body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")
    WebElement verifymessage;

    public String getVerifyMessage() {
        Reporter.log("getVerifyMessage" + verifymessage.toString());
        return getTextFromElement(verifymessage);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement verifyShoppingCart;

    public String getVerifyShoppingCart() {
        Reporter.log("getVerifyShoppingCart" + verifyShoppingCart.toString());
        return getTextFromElement(verifyShoppingCart);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]\")).contains(\"2023-11-30")
    WebElement verifyDate;


    public String getVerifyDeliveryDate() {
        Reporter.log("getVerifyDeliveryDate" + verifyDate.toString());
        return getTextFromElement(verifyDate);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement verifyModel;

    public String getVerifyModel() {
        Reporter.log("getVerifyMode" + verifyModel.toString());
        return getTextFromElement(verifyModel);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement verifyTotal;


    public String getVerifyTotal() {
        Reporter.log("getVerifyTotal" + verifyTotal.toString());
        return getTextFromElement(verifyTotal);
    }


    public void selectDeliveryDate() {

        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        //desktops.selectDeliveryDate();
        //clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }


    public void verifyZtoAforDropDroDown() {
        // Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        System.out.println(afterSortByZToAProductsName);
        //Assert.assertEquals("Product not sorted into Z to A order",
        //  originalProductsName, afterSortByZToAProductsName);

    }
}
