package testcases;

import controllers.AppiumBaseClass;
import controllers.AppiumController;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.HomeScreenPage;
import pageobjects.HomeScreenPageAndroid;
import pageobjects.HomeScreenPageIOS;

import java.net.MalformedURLException;

public class BaseTest extends AppiumBaseClass {

    HomeScreenPage homeScreenPage;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        AppiumController.instance.setup();

        switch (AppiumController.platform) {
            case ANDROID:
                homeScreenPage = new HomeScreenPageAndroid(driver());
                break;
            case IOS:
                homeScreenPage = new HomeScreenPageIOS(driver());
                break;
        }
    }

    @AfterMethod
    public void tearDown() {
        AppiumController.instance.stop();
    }
}
