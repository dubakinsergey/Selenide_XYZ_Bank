import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class BankPage {
    private final String URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

    public void openPage() {
        open(URL);
    }

    public void clickButtonCustomerLogin() {
        $x("//button[@class=\"btn btn-primary btn-lg\"][@ng-click=\"customer()\"]").click();
    }

    public void selectNameUser() {
        $x("//select[@name=\"userSelect\"]").click();
    }

    public void selectDropDown() {
        $(By.name("userSelect")).find(withText("Harry Potter")).click();
    }

    public void checkValueDropDown() {
        $x("//div[@class=\"container-fluid ng-scope\"]").shouldHave(Condition.text("Harry Potter"));
    }

    public void clickButtonLogin() {
        $x("//button[@class=\"btn btn-default\"]").click();
    }

    public void checkValueAccountNumber() {
        $x("//div[@ng-hide=\"noAccount\"]//strong").shouldHave(Condition.text("1004"));
    }
}
