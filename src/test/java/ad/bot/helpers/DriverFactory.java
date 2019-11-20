package ad.bot.helpers;

import com.browserup.bup.BrowserUpProxy;
import com.browserup.bup.BrowserUpProxyServer;
import com.browserup.bup.client.ClientUtil;
import com.browserup.bup.proxy.CaptureType;
import com.browserup.harreader.model.Har;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static ad.bot.helpers.ParametersProvider.getProperty;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Long.parseLong;

public class DriverFactory {

  private DriverFactory() {
  }

  public static void setupDriver() throws MalformedURLException {
    String runType = getProperty("runType");
    String browser = getProperty("browser");
    String browserVersion = getProperty("browserVersion");
    String selenoidUrl = getProperty("selenoidUrl");
    String baseUrl = getProperty("baseUrl");
    boolean headless = parseBoolean(getProperty("headless"));
    long implicitlyWait = parseLong(getProperty("implicitlyWait"));
    long pageLoadTimeout = parseLong(getProperty("pageLoadTimeout"));

    switch (runType) {
      case ("local"):
        if ("chrome".equals(browser)) {
          WebDriverManager.chromedriver().setup();
          ChromeOptions chromeOptions = new ChromeOptions();
          if (headless) {
            chromeOptions.addArguments("--headless", "window-size=1980,1024");
          }

//          chromeOptions. AddAdditionalCapability(CapabilityType.EnableProfiling, true, true);
          LoggingPreferences logPrefs = new LoggingPreferences();
          logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
          chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
          chromeOptions.setCapability( "goog:loggingPrefs", logPrefs );

//          chromeOptions.addArguments("--user-agent=sm-autotest");
          chromeOptions.addArguments("--remote-debugging-port=0");
          chromeOptions.addArguments("--enable-devtools-experiments");
          chromeOptions.addArguments("--auto-open-devtools-for-tabs");

          // start the proxy
//          BrowserUpProxy proxy = new BrowserUpProxyServer();
//          proxy.start(0);
//          int port = proxy.getPort();
//          System.out.println(port);

          // get the Selenium proxy object
//          Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
          // configure it as a desired capability

//          DesiredCapabilities capabilities = new DesiredCapabilities();
//          capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

//          chromeOptions.setCapability(CapabilityType.PROXY, seleniumProxy);
          WebDriver webDriver = new ChromeDriver(chromeOptions);
//          proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
//          chromeOptions.merge(capabilities);

          Configuration.browser = browser;
          Configuration.baseUrl = baseUrl;
//          webDriver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
//          webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
          webDriver.manage().window().maximize();
          WebDriverRunner.setWebDriver(webDriver);
        } else if ("firefox".equals(browser)) {
          WebDriverManager.firefoxdriver().setup();

          FirefoxOptions options = new FirefoxOptions();
//          options.addPreference("general.useragent.override", "sm-autotestERE");
          options.addPreference("devtools.debugger.remote-enabled", true);
          options.addPreference("devtools.chrome.enabled", true);
          options.addPreference("browser.tabs.remote.autostart", false);
          options.addPreference("security.sandbox.content.level", 5);
          options.addPreference("devtools.debugger.prompt-connection", false);
//          options.addPreference("devtools.console.stdout.content", true);

//          options.addPreference("devtools.debugger.remote-port", "0");
          options.addArguments("--start-debugger-server");

          LoggingPreferences logPrefs = new LoggingPreferences();
          logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
          options.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
          options.setCapability( "goog:loggingPrefs", logPrefs);

//          DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
//          desiredCapabilities.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
//          options.merge(desiredCapabilities);

          BrowserUpProxy proxy = new BrowserUpProxyServer();
          proxy.start(0);
          int port = proxy.getPort();
          System.out.println(port);
          Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
          // configure it as a desired capability
          DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
          options.merge(capabilities);

          WebDriver webDriver = new FirefoxDriver(options);


          proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
          proxy.newHar("yahoo.com");

          Configuration.browser = browser;
          Configuration.baseUrl = baseUrl;
          webDriver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
          webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
          webDriver.manage().window().maximize();
          WebDriverRunner.setWebDriver(webDriver);

          webDriver.get("https://decoyduck.github.io");
          Har har = proxy.getHar();
          System.out.println(har.getLog());


        }
        break;

      case ("selenoid"):
        if ("chrome".equals(browser)) {
          Configuration.browser = browser;
          Configuration.headless = false;
          Configuration.baseUrl = baseUrl + "?wm=selenoid";
          DesiredCapabilities capabilities = new DesiredCapabilities();
          capabilities.setBrowserName(browser);
          capabilities.setVersion(browserVersion);
          capabilities.setCapability("enableVNC", true);
          capabilities.setCapability("enableVideo", false);
          RemoteWebDriver remoteWebDriver = new RemoteWebDriver(URI.create(selenoidUrl).toURL(),
              capabilities);
          remoteWebDriver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
          remoteWebDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
          remoteWebDriver.manage().window().maximize();
          WebDriverRunner.setWebDriver(remoteWebDriver);
        } else if ("firefox".equals(browser)) {
          Configuration.headless = false;
          DesiredCapabilities capabilities = new DesiredCapabilities();
          Configuration.baseUrl = baseUrl;
          capabilities.setBrowserName(browser);
          capabilities.setVersion(browserVersion);
          capabilities.setCapability("enableVNC", true);
          capabilities.setCapability("enableVideo", false);
          RemoteWebDriver remoteWebDriver = new RemoteWebDriver(URI.create(selenoidUrl).toURL(),
              capabilities);
          remoteWebDriver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
          remoteWebDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
          remoteWebDriver.manage().window().maximize();
          WebDriverRunner.setWebDriver(remoteWebDriver);
        }
        break;
    }
  }
}
