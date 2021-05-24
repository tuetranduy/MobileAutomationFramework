package pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreenPageAndroid extends BasePageObject implements HomeScreenPage {

    @AndroidFindBy(accessibility = "Login Screen")
    AndroidElement loginScreenTextView;

    public HomeScreenPageAndroid(AppiumDriver driver) {
        super();
    }

    @Override
    public void tapOnLoginScreenTextView() {
        System.out.println("Clicking login...");
        loginScreenTextView.click();
    }
}