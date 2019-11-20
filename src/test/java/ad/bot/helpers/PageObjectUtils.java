package ad.bot.helpers;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageObjectUtils {

  private PageObjectUtils() {
  }

  public static boolean checkPageIsPresentByUrl(final String pageUrl) {
    try {
      Selenide.Wait().until(ExpectedConditions.urlContains(pageUrl));
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }
}