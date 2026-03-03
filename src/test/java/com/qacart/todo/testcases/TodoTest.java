package com.qacart.todo.testcases;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.TodoPage;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;



@Feature("Tasks feature")
public class TodoTest extends BaseTest {
    @Feature("Add a task")
    @Test(description = "Should be able to add new task")
    public void ShouldBeableToAddNewTodo (){

        //used api approach so that our test case won't depend on UI functions

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies().asList());
        System.out.println(registerApi.getRestAssuredCookies());
        String actualResult = todoPage.load()
                .ClickOnAddButton()
                .addNewTodo("Learn Selenium")
                .getItemText();


        Assert.assertEquals(actualResult, "Learn Selenium");
    }
    @Feature("Delete a task")
    @Test(description = "Should be able to delete a task")
    public void ShouldBeableToDeleteTodo () throws InterruptedException {

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        System.out.println("Access Token after register(): " + registerApi.getAccessToken());

        TasksApi  tasksApi = new TasksApi();
        tasksApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies().asList());

        boolean isNotodoMsgDisplayed = todoPage
                .load()
                .ClickOnDeleteButton()
                .IsNoTodoItemDisplayed();

        Assert.assertTrue(isNotodoMsgDisplayed);


    }
}
