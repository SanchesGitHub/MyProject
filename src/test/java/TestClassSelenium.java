import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestClassSelenium {

    @Test(groups = "smoke")
    public void openDriverTest() {
        open("https://www.google.ru/");
        $x(".//*[@name='q']").shouldBe(Condition.visible);
    }

}
