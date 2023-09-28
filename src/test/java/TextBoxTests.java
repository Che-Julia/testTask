import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page_objects.TextBoxPage;

public class TextBoxTests {

    @BeforeAll
    public static void beforeAll() {
        Configuration.pageLoadStrategy = "none";
        Configuration.timeout = 30_000;
    }


    @Test
    void formTest() {
        new TextBoxPage()
                .clickOnMainMenu("Elements")
                .clickOnSideMenuButton("Text Box")
                .enterValue("userName", "Ivan")
                .enterValue("userEmail", "pewave7421@bnovel.com")
                .enterValue("currentAddress", "Moscow")
                .enterValue("permanentAddress", "Moscow")
                .clickOnButtonById("submit")
                .checkSuccess()
                .clickOnSideMenuButton("Buttons")
                .clickOnButton("Click Me")
                .buttonText("You have done a dynamic click")
                .clickOnButton("Right Click Me")
//                .buttonText("")
                .clickOnButton("Double Click Me")
//                .buttonText("");
                .clickOnMainMenu("Alerts, Frame & Windows")
                .clickOnSideMenuButton("Browser Windows")
                .clickOnButton("New Tab")
                .close()
                .clickOnButton("New Window")
                .close()
                .clickOnSideMenuButton("Alerts")
                .clickOnButtonById("alertButton")
                .closeNotificationWindow()
                .clickOnButtonById("timerAlertButton")
                .closeNotificationWindow()
                .clickOnButtonById("confirmButton")
                .closeNotificationWindow()
                .confirmationMessage("You selected ")
                .confirmationMessage("Ok")
                .clickOnButtonById("promtButton")
                .sendValue()
                .confirmationMessage2("You entered ")
                .confirmationMessage2("Test name");

    }

}
