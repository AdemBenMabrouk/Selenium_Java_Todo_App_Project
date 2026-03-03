package com.qacart.todo.testcases;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth feature")
public class LoginTest extends BaseTest {

    @Story("Login with correct email and password")
    @Description("It will login by filling the email and password correctly and redirect to Todo page successfully")

    @Test(description = "Test the login functionality")
    public void Shouldbeabletologinwithemailandpassword() {

        LoginPage loginPage = new LoginPage(getDriver());
        //Builder Pattern design technique (method after method)
        //no need to define todopage object
        Boolean iswelcomeDisplayed = loginPage
                .loadUrl()
                .login(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getPassword())
                .IswelcomeDisplayed();

        Assert.assertTrue( iswelcomeDisplayed);

    }
}
