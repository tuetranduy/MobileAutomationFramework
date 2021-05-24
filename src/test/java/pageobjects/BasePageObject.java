package pageobjects;

import controllers.AppiumBaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utils.PropertyUtils;
import utils.WaitUtils;

import java.time.Duration;

public class BasePageObject extends AppiumBaseClass {
    public static final int IMPLICIT_WAIT = PropertyUtils.getIntProperty("implicitWait", 5);
    WaitUtils waitUtils;

    public BasePageObject(AppiumDriver driver) {
        initElements();
        waitUtils = new WaitUtils();
    }

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driver(), Duration.ofSeconds(IMPLICIT_WAIT)), this);
    }
}
