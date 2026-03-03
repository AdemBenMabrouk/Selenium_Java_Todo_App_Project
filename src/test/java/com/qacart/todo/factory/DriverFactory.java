package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver initialize() {

        //if user didnt send a browser variable (mvn clean test) ,chrome will be the default value
        //if user uses a variable (ex : mvn clean test -Dbrowser=chrome ) , the chrome will be the driver
        //Syntax : mvn clean test -D(variable name)=value

        String browser=System.getProperty("browser","chrome");
        switch(browser){
            case "chrome":
                 WebDriverManager.chromedriver().setup();
                 driver = new ChromeDriver();
                 break;
            case "firefox":
                 WebDriverManager.firefoxdriver().setup();
                 driver = new FirefoxDriver();
                 break;
            case "safari":
                 driver = new SafariDriver();
                 break;
            case "edge":
                 driver = new EdgeDriver();
                 break;
            default:
                throw new RuntimeException("Browser not supported");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
