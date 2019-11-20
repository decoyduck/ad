package ad.bot.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static ad.bot.helpers.DriverFactory.setupDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

abstract class BaseTest {


  @BeforeEach
  public void setup() throws Exception {
    setupDriver();
  }

  @AfterEach
  public void tearDown() {
    getWebDriver().quit();
  }
}
