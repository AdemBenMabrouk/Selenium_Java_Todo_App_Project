package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.Endpoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage {
    public TodoPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement welcome;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement add;

    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement delete;

    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodos;

    @Step
    public TodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ Endpoint.TODO_PAGE_ENDPOINT);
        return this;
    }
    public boolean IswelcomeDisplayed() {
        return welcome.isDisplayed();
    }

    //Travel from Todopage to Newtodopage
    @Step
    public NewTodoPage ClickOnAddButton() {
        add.click();
        return new NewTodoPage(driver);
    }
    @Step
    public String getItemText() {
        return todoItem.getText();
    }
    @Step
    public TodoPage ClickOnDeleteButton() {
        delete.click();
        return this;
    }
    @Step
    public boolean IsNoTodoItemDisplayed() {
        return noTodos.isDisplayed();
    }


}
