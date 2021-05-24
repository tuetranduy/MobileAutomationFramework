package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreenPageIOS extends BasePageObject implements HomeScreenPage {
    @FindBy(id = "IntegerA")
    IOSElement txtA;

    @FindBy(id = "IntegerB")
    IOSElement txtB;

    @FindBy(id = "ComputeSumButton")
    IOSElement sumBtn;

    public HomeScreenPageIOS(AppiumDriver driver) {
        super();
    }

    @Override
    public void tapOnLoginScreenTextView() {
        txtA.sendKeys(5 + "");
        txtB.sendKeys(15 + "");
        sumBtn.click();
    }
}
