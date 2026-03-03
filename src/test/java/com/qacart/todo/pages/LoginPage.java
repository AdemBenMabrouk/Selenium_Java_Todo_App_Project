package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

//Page Object esmha hedhi , lezem 4 hajet mohema (taarif driver meloul,Initelements f constructor fih driver, elements , methods w fazet)
//ay page jdida lezem naamlou extends lel base(eli feha constructor mteeha w pagefactory) w maaha constractor feha super
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
