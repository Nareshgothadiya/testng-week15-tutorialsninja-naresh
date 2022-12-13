package com.tutorialsninja.testsuite;

import com.tutorialsninja.customlisteners.CustomListeners;
import com.tutorialsninja.pages.MyAccount;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class MyAccountTest extends BaseTest {
    MyAccount myAccount;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        myAccount = new MyAccount();
    }

    //**************************************MyAccount***************************************

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Register");
        Assert.assertEquals(myAccount.getVerifyRegister(), "Register Account", "Error Message not displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Login");
        Assert.assertEquals(myAccount.getVerifyReturning(), "Returning Customer", "Error Message not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Register");
        myAccount.enterFirstName("prime");
        myAccount.enterLastName("testing");
        myAccount.enterEmailAdd("selenium588@gmail.com");
        myAccount.enterPhone("12345678965");
        myAccount.enterPassword("123456");
        myAccount.enterConfirmPass("123456");
        myAccount.clickYesonNewsLetter();
        myAccount.clickOnPrivacy();
        myAccount.clickFinalContinue();
        //Assert.assertEquals(myAccount.getVerifyMessage(), "Your Account Has Been Created!", "Error Message not displayed");
        myAccount.clickOnContinueButton();
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        Thread.sleep(2000);
        myAccount.clickOnContinueTab();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        myAccount.clickonMyAccount();
        myAccount.selectMyAccountOptions("Login");
        myAccount.enterEmailAdd("selenium588@gmail.com");
        myAccount.enterPassword("123456");
        myAccount.clickOnMyAccountTab();
        myAccount.selectMyAccountOptions("Logout");
        //Assert.assertEquals(myAccount.getVerifyLogout(), "Account Logout", "Error Message not displayed");
        myAccount.clickOnContinueTab();
    }


}
