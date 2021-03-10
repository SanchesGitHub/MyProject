package SimpleTests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestClassRegression {

    @Test(groups = "regression")
    public void openBrowserTest() {
        open("https://yandex.ru/");
        $x(".//div[@class='home-logo__default']").shouldBe(Condition.visible);
    }

}
