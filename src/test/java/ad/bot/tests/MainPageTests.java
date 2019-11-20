package ad.bot.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ad.bot.pages.MainPage;

public class MainPageTests extends BaseTest {

    @Test
    @DisplayName("Detect popunder")
    public void testPopunder() {
        MainPage mainPage = new MainPage();
        mainPage.
                open().
                checkPopunder()
        ;
    }

}
