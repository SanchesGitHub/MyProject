package TestTasks;

import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestYandexImage {

    Properties prop = new Properties();

    @BeforeGroups(groups = "regression")
    public void loadProperties(){
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test(groups = "regression")
    public void searchImageTest() {
        open("https://yandex.ru/");
        $x(".//div[@class='home-logo__default']").shouldBe(visible);
        $x(".//a[@data-id='images']").click();
        switchTo().window(1);
        $x(".//button[@aria-label='Поиск по изображению']").shouldBe(enabled).click();
        $x(".//input[@type='file']").uploadFile(new File(prop.getProperty("image.path")));
        $(byText("Кажется, на изображении")).shouldBe(visible);

        ElementsCollection bullets = $$x("//div[@class='CbirItem CbirTags']//span[contains(text()," + prop.getProperty("image.name") + ")]");
        assert bullets.size() > 0;
    }

}
