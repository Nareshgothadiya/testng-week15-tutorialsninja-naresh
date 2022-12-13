package com.tutorialsninja.pages;

import com.tutorialsninja.browserfactory.ManageBrowser;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooks extends Utility {
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopLink;


    public void clickOnLaptoptopLink() {
        clickOnElement(laptopLink);
    }

    public String shortPriceLowToHigh() {
        List<WebElement> products = ManageBrowser.driver.findElements(By.xpath("//p[@class ='price']"));
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(originalProductsPrice);
        // Sort By Reverse order
        Collections.sort(originalProductsPrice, Collections.reverseOrder());
        System.out.println(originalProductsPrice);
        // Select sort by Price (High > Low)
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (Low > High)");
        // After filter Price (High > Low) Get all the products name and stored into array list
        products = ManageBrowser.driver.findElements(By.xpath("//p[@class ='price']"));
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        System.out.println(afterSortByPrice);
        // Assert.assertEquals("Product not sorted by price High to Low",
        // originalProductsPrice, afterSortByPrice);

        return null;
    }

    public void changeCurrency() {

        List<WebElement> currencyList = ManageBrowser.driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }

    @CacheLookup
    @FindBy(linkText = "Show All Laptops & Notebooks")
    WebElement allLaptopAndNotebooksLink;

    public void clickOnAllLaptopAndNotebooksLink() {
        Reporter.log("clickOnAllLaptopAndNotebooksLink" + allLaptopAndNotebooksLink.toString());
        clickOnElement(allLaptopAndNotebooksLink);
    }

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByPriceHighToLow;

    public void sortByPriceHighToLowfromDropdown() {
        Reporter.log("sortByPriceHighToLowfromDropdown" + sortByPriceHighToLow.toString());
        sendTextToElement(sortByPriceHighToLow, "Price (High > Low)");
    }

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement macbookLink;

    public void clickOnMacbookLink() {
        Reporter.log("clickOnMacbookLink" + macbookLink.toString());
        clickOnElement(macbookLink);
    }

    @CacheLookup
    @FindBy(linkText = "MacBook")
    WebElement varifyMacbook;

    public String getVerifyMacbook() {
        Reporter.log("getVerifyMacbook" + varifyMacbook.toString());
        return getTextFromElement(varifyMacbook);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCart;

    public void clickOnAddToCart() {
        Reporter.log("clickOnAddToCart" + addToCart.toString());
        clickOnElement(addToCart);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement varifySusccess;

    public String getVerifySuccess() {
        Reporter.log("getVerifySuccess" + varifySusccess.toString());
        return getTextFromElement(varifySusccess);
    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCart;

    public void clickOnShoppingCart() {
        Reporter.log("clickOnShoppingCart" + addToCart.toString());
        clickOnElement(addToCart);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement varifyCart;

    public String getVerifyCart() {
        Reporter.log("getVerifyCar" + varifyCart.toString());
        return getTextFromElement(varifyCart);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']//h1")
    WebElement varifyProductMacbook;

    public String getVerifyProductMacbook() {
        Reporter.log("getVerifyProductMacbook" + varifyProductMacbook.toString());
        return getTextFromElement(varifyProductMacbook);
    }

    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement updateCart;

    public void clickOnUpdateCart() {
        Reporter.log("clickOnUpdateCart" + updateCart.toString());
        clickOnElement(updateCart);
    }

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='product-product']/div[1]")
    WebElement varifyCartText;

    public String getVerifyCarttext() {
        Reporter.log("getVerifyCarttext" + varifyCartText.toString());
        return getTextFromElement(varifyCartText);
    }

    By clearText = By.xpath("//input[contains(@name, 'quantity')]");

    public void clearTextInQuantityField() {
        Actions actions = new Actions(ManageBrowser.driver);
        WebElement quantity = ManageBrowser.driver.findElement(clearText);
        quantity.clear();
    }

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement sendTextToQuantity;

    public void sendTextToQuantityField() {
        Reporter.log("sendTextToQuantityField" + sendTextToQuantity.toString());
        sendTextToElement(sendTextToQuantity, "2");
    }

    @CacheLookup
    @FindBy(xpath = "//tbody/tr[1]/td[6]")
    WebElement varifyTotal;

    public String getVerifyTotal() {
        Reporter.log("getVerifyTotal" + varifyTotal.toString());
        return getTextFromElement(varifyTotal);
    }

    @CacheLookup
    @FindBy(xpath = "//header/div[1]/div[1]/div[3]/div[1]/button[1]")
    WebElement clickonCart;

    public void clickOnCheckoutCart() {
        Reporter.log("clickOnCheckoutCart" + clickonCart.toString());
        clickOnElement(clickonCart);
    }

    @CacheLookup
    @FindBy(xpath = "//body[1]/header[1]/div[1]/div[1]/div[3]/div[1]/ul[1]/li[2]/div[1]/p[1]/a[2]/strong[1]")
    WebElement clickonCheckout;

    public void clickOnFinalCheckout() {
        Reporter.log("clickOnFinalCheckout" + clickonCheckout.toString());
        clickOnElement(clickonCheckout);
    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement varifyCheckout;

    public String getVerifyCheckout() {
        Reporter.log("getVerifyCheckout" + varifyCheckout.toString());
        return getTextFromElement(varifyCheckout);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class='col-sm-6']//h2")
    WebElement varifyNewCustomer;

    public String getVerifyNewCustomer() {
        Reporter.log("getVerifyNewCustomer" + varifyNewCustomer.toString());
        return getTextFromElement(varifyNewCustomer);
    }

    @CacheLookup
    @FindBy(xpath = "//label[text()[normalize-space()='Guest Checkout']]")
    WebElement guestCheckout;

    public void clickOnGuestCheckout() {
        Reporter.log("clickOnGuestCheckout" + guestCheckout.toString());
        clickOnElement(guestCheckout);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueTab;

    public void clickOnContinueTab() {
        Reporter.log("clickOnContinueTab" + continueTab.toString());
        clickOnElement(continueTab);
    }

    @CacheLookup
    @FindBy(name = "firstname")
    WebElement nameField;

    public void enterName(String name) {
        Reporter.log("enterNam" + nameField.toString());
        sendTextToElement(nameField, name);
    }

    @CacheLookup
    @FindBy(name = "lastname")
    WebElement lastnameField;

    public void enterLastName(String lastname) {
        Reporter.log("enterLastName" + lastnameField.toString());
        sendTextToElement(lastnameField, lastname);
    }

    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement emaileField;

    public void enterEmail(String email) {
        Reporter.log("enterEmail" + emaileField.toString());
        sendTextToElement(emaileField, email);
    }

    @CacheLookup
    @FindBy(name = "telephone")
    WebElement telePhone;

    public void enterTelephone(String phone) {
        Reporter.log("enterTelephone" + telePhone.toString());
        sendTextToElement(telePhone, phone);
    }

    @CacheLookup
    @FindBy(name = "address_1")
    WebElement addressLine;

    public void enterAddress(String street) {
        Reporter.log("enterAddress" + addressLine.toString());
        sendTextToElement(addressLine, street);
    }

    @CacheLookup
    @FindBy(name = "city")
    WebElement cityName;

    public void enterCity(String city) {
        Reporter.log("enterCity" + cityName.toString());
        sendTextToElement(cityName, city);
    }

    @CacheLookup
    @FindBy(name = "postcode")
    WebElement postCode;

    public void enterPostcode(String code) {
        Reporter.log("enterPostcode" + postCode.toString());
        sendTextToElement(postCode, code);
    }

    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement countryName;

    public void enterCountry(String country) {
        Reporter.log("enterCountry" + countryName.toString());
        sendTextToElement(countryName, country);
    }

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement zoneName;

    public void enterState(String state) {
        Reporter.log("enterState" + zoneName.toString());
        sendTextToElement(zoneName, state);
    }

    @CacheLookup
    @FindBy(xpath = "(//input[@value='Continue'])[2]")
    WebElement continueCheckout;

    public void clickOnCheckout() {
        Reporter.log("clickOnCheckout" + continueCheckout.toString());
        clickOnElement(continueCheckout);
    }

    @CacheLookup
    @FindBy(xpath = "//textarea[@name='comment']")
    WebElement passtext;

    public void enterText(String msg) {
        Reporter.log("enterText" + passtext.toString());
        sendTextToElement(passtext, msg);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement termsCondition;

    public void clickOnTerms() {
        Reporter.log("clickOnTerms" + termsCondition.toString());
        clickOnElement(termsCondition);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement verifyText1;
    By lastContinue = By.xpath("//input[@id='button-payment-method']");

    public void clickContinue() {
        Reporter.log("clickContinue" + lastContinue.toString());
        clickOnElement(lastContinue);
    }

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
    WebElement warningMsg;

    public String getVerifyWarningMsg() {
        Reporter.log("getVerifyWarningMsg" + warningMsg.toString());
        return getTextFromElement(warningMsg);
    }
}



