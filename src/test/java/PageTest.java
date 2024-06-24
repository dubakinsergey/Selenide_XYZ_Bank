import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class PageTest {
    private BankPage bankPage;


    @BeforeTest
    public static void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
    }

    @Test
    public void userLoginTest() {
        bankPage = new BankPage();
        bankPage.openPage();
        webdriver().shouldHave(url("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login"));
        bankPage.clickButtonCustomerLogin();
        bankPage.selectNameUser();
        bankPage.selectDropDown();
        bankPage.checkValueDropDown();
        bankPage.clickButtonLogin();
        bankPage.checkValueAccountNumber();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
