package com.tutorialsninja.pages;

import com.tutorialsninja.browserfactory.ManageBrowser;
import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccount extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccount;


    public void clickonMyAccount() {
        Reporter.log("clickonMyAccount" + myAccount.toString());
        clickOnElement(myAccount);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement varifyRegister;


    public String getVerifyRegister() {
        Reporter.log("getVerifyRegister" + varifyRegister.toString());
        return getTextFromElement(varifyRegister);
    }

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement varifyReturning;


    public String getVerifyReturning() {
        Reporter.log("getVerifyReturning" + varifyReturning.toString());
        return getTextFromElement(varifyReturning);

    }

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;


    public void enterFirstName(String name) {
        Reporter.log("enterFirstName" + firstName.toString());
        sendTextToElement(firstName, name);
    }

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;


    public void enterLastName(String lastname) {
        Reporter.log("enterLastName" + lastName.toString());
        sendTextToElement(lastName, lastname);
    }

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement enterEmail;


    public void enterEmailAdd(String email) {
        Reporter.log("enterEmailAdd" + enterEmail.toString());
        sendTextToElement(enterEmail, email);
    }

    @CacheLookup
    @FindBy(xpath = "input-telephone")
    WebElement verifyText;
    By enterPhone = By.id("input-telephone");

    public void enterPhone(String phone) {
        Reporter.log("enterPhone" + enterPhone.toString());
        sendTextToElement(enterPhone, phone);
    }

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement enterPass;


    public void enterPassword(String phone) {
        Reporter.log("enterPassword" + enterPass.toString());
        sendTextToElement(enterPass, phone);
    }

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPass;
    //By confirmPass = By.id("input-confirm");

    public void enterConfirmPass(String phone) {
        Reporter.log("enterConfirmPass" + confirmPass.toString());
        sendTextToElement(confirmPass, phone);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@name='newsletter']")
    WebElement newsLetter;


    public void clickYesonNewsLetter() {
        Reporter.log("clickYesonNewsLetter" + newsLetter.toString());
        clickOnElement(newsLetter);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement privacyPolicy;


    public void clickOnPrivacy() {
        Reporter.log("clickOnPrivacy" + privacyPolicy.toString());
        clickOnElement(privacyPolicy);
    }

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement clickOnContinue;


    public void clickFinalContinue() {
        Reporter.log("clickFinalContinue" + clickOnContinue.toString());
        clickOnElement(clickOnContinue);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement varifymessage;


    public String getVerifyMessage() {
        Reporter.log("getVerifyMessage" + varifymessage.toString());
        return getTextFromElement(varifymessage);

    }

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueButton;


    public void clickOnContinueButton() {
        Reporter.log("clickOnContinueButton" + continueButton.toString());
        clickOnElement(continueButton);
    }

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;


    public void clickOnMyAccountTab() {
        Reporter.log("clickOnMyAccountTab" + myAccountTab.toString());
        clickOnElement(myAccountTab);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement varifLogout;


    public String getVerifyLogout() {
        Reporter.log("getVerifyLogout" + varifLogout.toString());
        return getTextFromElement(varifLogout);
    }

    By continueButtonTab = By.xpath("//a[contains(text(),'Continue')]");

    public void clickOnContinueTab() {
        Reporter.log("clickOnContinueTab" + continueButton.toString());
        clickOnElement(continueButton);
    }

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginButton;


    public void clickOnLogin() {
        Reporter.log("clickOnLogin" + loginButton.toString());
        clickOnElement(loginButton);

    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = ManageBrowser.driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = ManageBrowser.driver.findElements(By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li"));
        }
    }
}
