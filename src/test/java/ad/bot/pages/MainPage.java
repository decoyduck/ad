package ad.bot.pages;

import ad.bot.helpers.EventHandler;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

//import org.json.JSONException;
//import org.json.JSONObject;
//import com.br.*;
//import com.browserup.*;

public class MainPage {
    private SelenideElement body = $(".block1");
    //URI страницы
    private final static String pageUrl = "/";

    @Step(value = "Open main page")
    public MainPage open() {
        Selenide.open(pageUrl);
        return this;
    }

    @Step(value = "Detect popunder")
    public MainPage checkPopunder() {
        WebDriver driver = WebDriverRunner.getWebDriver();
//        String winHandleBefore = driver.getWindowHandle();

//        Actions action = new Actions(driver);
//        action.moveByOffset(500, 500).perform();
//        action.click();
//        System.out.println(driver.getTitle().toLowerCase());
//        System.out.println(driver.getCurrentUrl());
//        body.click();
//        System.out.println(driver.getCurrentUrl());

//        BrowserUpProxy proxy = new BrowserUpProxyServer();
//        proxy.start();
//        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);

//        eventDriver.get("https://decoyduck.github.io");
        WebElement element = eventDriver.findElement(By.id("redirect"));
        element.click();

        // Switch to new window opened
        for (String winHandle : eventDriver.getWindowHandles()) {
            eventDriver.switchTo().window(winHandle);
        }

//         Switch to new window opened
//        for (String winHandle : eventDriver.getWindowHandles()) {
//            eventDriver.switchTo().window(winHandle);
//        }

//        eventDriver.switchTo().window("1");
//        String injectedJavascript = "alert('test');";
//        eventDriver.executeAsyncScript(injectedJavascript);
//        eventDriver.executeScript(injectedJavascript);
//        handler.afterNavigateTo("erv", eventDriver);
//        System.out.println("switch to popup");



//        System.out.println(driver.getCurrentUrl());
//            System.out.println("page is loaded!!" + driver.getCurrentUrl());
//            System.out.println("PERFORMANCE");
//            LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);
//            for (Iterator<LogEntry> it = logs.iterator(); it.hasNext(); ) {
//                LogEntry entry = it.next();
//
//                System.out.println(driver.getCurrentUrl());
//                System.out.println(entry.toString());
//            }

            try {
                (new WebDriverWait(eventDriver, 8)).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                        System.out.println("wait!");

                        return d.getTitle().toLowerCase().startsWith("test!");
                    }
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("After timeout");

            try {
                System.out.println("TakesScreenshot!");
                File scrFile = ((TakesScreenshot) eventDriver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("/Users/pes/screenshot.png"));

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }


//        Object.class.toString();
//        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver d) {
//                System.out.println("CHEESE!!");
//
//                return d.getTitle().toLowerCase().startsWith("cheese!");
//            }
//        });


        return this;


    }

    public static void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
