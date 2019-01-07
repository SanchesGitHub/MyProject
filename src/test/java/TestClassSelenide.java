import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestClassSelenide {

    @Test(groups = "regression")
    public void openBrowserTest() throws Exception {
        open("https://yandex.ru/");
        $x(".//div[@class='home-logo__default']").shouldBe(Condition.visible);
    }

}
