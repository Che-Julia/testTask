package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxPage {
    public TextBoxPage() {
        open("https://demoqa.com/");
    }


    @Step("Открывыем меню {buttonMenu}" )
    public TextBoxPage clickOnMainMenu(String buttonMenu) {
        $x("//*[text()='" + buttonMenu + "']/../../..").scrollTo().click();
        return this;
    }


    @Step("Нажимаем на кнопку {buttonText}")
    public TextBoxPage clickOnSideMenuButton(String buttonText) {
        $x("//span[text()='" + buttonText + "']").scrollTo().click();
        return this;
    }

    @Step("Нажимаем на кнопку {buttonText}")
    public TextBoxPage clickOnButton(String buttonText) {
        $x("//button[text()='" + buttonText + "']").scrollTo().click();
        return this;
    }

    @Step("Нажимаем на кнопку {buttonId}")
    public TextBoxPage clickOnButtonById(String buttonId) {
        $x("//button[@id='" + buttonId + "']").sendKeys(Keys.ENTER);
        return this;
    }


    @Step("Вводим в поле {fieldId} значение {fieldValue}")
    public TextBoxPage enterValue(String fieldId, String fieldValue) {
        $x("//*[@id='" + fieldId + "']").setValue(fieldValue);
        return this;
    }

    @Step("Проверить, что данные в блоке сохранены корректно")
    public TextBoxPage checkSuccess() {
        $x("//p[@id=\"name\"]")
                .shouldHave(Condition.text("Ivan"));
        $x("//p[@id=\"email\"]")
                .shouldHave(Condition.text("pewave7421@bnovel.com"));
        $x("//p[@id=\"currentAddress\"]")
                .shouldHave(Condition.text("Moscow"));
        $x("//p[@id=\"permanentAddress\"]")
                .shouldHave(Condition.text("Moscow"));
        return this;
    }

    @Step("Проверяем, что появился текст")
    public TextBoxPage buttonText(String text) {
        $x("//p[text()='" + text + "']");
        return this;
    }

    @Step("Закрываем окно")
    public TextBoxPage closeWindow() {
        Selenide.closeWebDriver();
        return this;
    }

    @Step("Закрываем вкладку")
    public TextBoxPage close() {
        switchTo().window(1);
        Selenide.closeWindow();
        switchTo().window(0);
        return this;
    }

    @Step("Закрываем вкладку")
    public TextBoxPage closeNotificationWindow() {
        switchTo().alert().accept();
        return this;
    }

    @Step("Проверяем появление сообщения {notificationText}")
    public TextBoxPage confirmationMessage(String notificationText) {
        $x("//span[text()='" + notificationText + "']")
                .shouldHave(Condition.text("You selected "));
        $x("//span[text()='" + notificationText + "']")
                .shouldHave(Condition.text("Ok"));
        return this;
    }

    @Step("Проверяем появление сообщения {notificationText}")
    public TextBoxPage confirmationMessage2(String notificationText) {
        $x("//span[text()='" + notificationText + "']")
                .shouldHave(Condition.text("You entered "));
        $x("//span[text()='" + notificationText + "']")
                .shouldHave(Condition.text("Test name"));
        return this;
    }

    @Step("Заполняем поле в уведомление данными")
    public TextBoxPage sendValue() {
        switchTo().alert().sendKeys("Test name");
        return this;
    }
}


