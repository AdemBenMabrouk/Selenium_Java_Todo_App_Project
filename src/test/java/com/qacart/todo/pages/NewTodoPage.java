package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.Endpoint;
import com.qacart.todo.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTodoPage extends BasePage {
    public NewTodoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"new-todo\"]")
    private WebElement newTodoInput;

    @FindBy(css = "[data-testid=\"submit-newTask\"]")
    private WebElement submitButton;

    //Travel from Newtodopage to Todopage
    public TodoPage addNewTodo (String text) {
        newTodoInput.sendKeys(text);
        submitButton.click();
        return new TodoPage(driver);
    }
    public NewTodoPage load(){
        driver.get(ConfigUtils.getBaseUrl() + Endpoint.NEW_TODO_ENDPOINT);
        return this;
    }
}
