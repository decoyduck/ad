package ad.bot.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("beforeAlertAccept " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("afterAlertAccept " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("afterAlertDismiss " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("beforeAlertDismiss" + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("beforeNavigateTo " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("afterNavigateTo " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("beforeNavigateBack " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("afterNavigateBack " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("beforeNavigateForward " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("afterNavigateForward " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("beforeNavigateRefresh " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("afterNavigateRefresh " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("beforeFindBy ");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("afterFindBy ");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("beforeClickOn " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("afterClickOn " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("beforeChangeValueOf " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("afterChangeValueOf " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println("beforeScript " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        System.out.println("afterScript " + webDriver.getCurrentUrl());
    }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("beforeSwitchToWindow " + s + webDriver.getCurrentUrl());
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("afterSwitchToWindow " + s + webDriver.getCurrentUrl());
        webDriver.navigate().refresh();
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("onException " + webDriver.getCurrentUrl());
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        System.out.println("beforeGetScreenshotAs ");
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        System.out.println("afterGetScreenshotAs ");
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        System.out.println("beforeGetText " + webDriver.getCurrentUrl());
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        System.out.println("afterGetText " + webDriver.getCurrentUrl());
    }
}


//public class EventHandler implements WebDriverEventListener{
//
//    public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//
//        System.out.println("inside method afterChangeValueOf on " + arg0.toString());
//    }
//
//    public void beforeAlertAccept(WebDriver arg1) {
//        System.out.println("beforeAlertAccept");
//    }
//
//    public void afterAlertAccept(WebDriver arg1) {
//        System.out.println("beforeAlertAccept");
//    }
//
//    public void afterAlertDismiss(WebDriver arg1) {
//        System.out.println("beforeAlertAccept");
//    }
//
//    public void beforeAlertDismiss(WebDriver arg1) {
//        System.out.println("beforeAlertAccept");
//    }
//
//    public void beforeNavigateRefresh(WebDriver arg1) {
//        System.out.println("beforeAlertAccept");
//    }
//
//    public void afterNavigateRefresh(WebDriver arg1) {
//        System.out.println("beforeAlertAccept");
//    }
//
//    public void afterClickOn(WebElement arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//        System.out.println("inside method afterClickOn on " + arg0.toString());
//    }
//
//    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
//        // TODO Auto-generated method stub
//        System.out.println("Find happened on " + arg1.toString()
//                + " Using method " + arg0.toString());
//    }
//
//    public void afterNavigateBack(WebDriver arg0) {
//        // TODO Auto-generated method stub
//
//        System.out.println("Inside the after navigateback to " + arg0.getCurrentUrl());
//    }
//
//    public void afterNavigateForward(WebDriver arg0) {
//        // TODO Auto-generated method stub
//        System.out.println("Inside the afterNavigateForward to " + arg0.getCurrentUrl());
//    }
//
//    public void afterNavigateTo(String arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//        System.out.println("Inside the afterNavigateTo to " + arg0);
//    }
//
//    public void afterScript(String arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//        System.out.println("Inside the afterScript to, Script is " + arg0);
//    }
//
//    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//
//        System.out.println("Inside the beforeChangeValueOf method");
//    }
//
//    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//        System.out.println("About to click on the " + arg0.toString());
//
//    }
//
//    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
//        // TODO Auto-generated method stub
//        System.out.println("Just before finding element " + arg1.toString());
//
//    }
//
//    public void beforeNavigateBack(WebDriver arg0) {
//        // TODO Auto-generated method stub
//        System.out.println("Just before beforeNavigateBack " + arg0.getCurrentUrl());
//
//    }
//
//    public void beforeNavigateForward(WebDriver arg0) {
//        // TODO Auto-generated method stub
//        System.out.println("Just before beforeNavigateForward " + arg0.getCurrentUrl());
//
//    }
//
//    public void beforeNavigateTo(String arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//        System.out.println("Just before beforeNavigateTo " + arg0);
//    }
//
//    public void beforeScript(String arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//        System.out.println("Just before beforeScript " + arg0);
//    }
//
//    public void onException(Throwable arg0, WebDriver arg1) {
//        // TODO Auto-generated method stub
//        System.out.println("Exception occured at " + arg0.getMessage());
//
//    }
//}