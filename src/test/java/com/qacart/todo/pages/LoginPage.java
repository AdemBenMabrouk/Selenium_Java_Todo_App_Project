package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;

    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public TodoPage login (String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();
        return new TodoPage(driver);
    }
    //return this whole page with its methods
    @Step
    public LoginPage loadUrl() {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
       return this;
    }
}
