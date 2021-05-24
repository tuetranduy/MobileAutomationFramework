package controllers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.PropertyUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumController {

    private static final String ANDROID_APP_NAME = PropertyUtils.getProperty("android.app.name");
    private static final String ANDROID_PLATFORM = PropertyUtils.getProperty("android.platform");
    private static final String ANDROID_DEVICE_NAME = PropertyUtils.getProperty("android.device.name");
    private static final String ANDROID_AUTOMATION_NAME = PropertyUtils.getProperty("android.automation.name");
    private static final String ANDROID_PLATFORM_VERSION = PropertyUtils.getProperty("android.platform.version");

    private static final String IOS_APP_NAME = PropertyUtils.getProperty("ios.app.name");
    private static final String IOS_PLATFORM = PropertyUtils.getProperty("ios.platform");
    private static final String IOS_DEVICE_NAME = PropertyUtils.getProperty("ios.device.name");
    private static final String IOS_AUTOMATION_NAME = PropertyUtils.getProperty("ios.automation.name");
    private static final String IOS_PLATFORM_VERSION = PropertyUtils.getProperty("ios.platform.version");

    private static final String EXECUTION_PLATFORM = PropertyUtils.getProperty("execution_platform");

    private static final int IMPLICIT_WAIT = PropertyUtils.getIntProperty("implicitWait", 5);

    public static AppiumController instance = new AppiumController();
    public static PLATFORM platform;
    public AppiumDriver driver;

    public void setup() throws MalformedURLException {
        if (driver != null) {
            return;
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "src/test/resources/app");
        File app;

        switch (EXECUTION_PLATFORM) {
            case "LOCAL_IOS":
                platform = PLATFORM.IOS;
                break;
            case "LOCAL_ANDROID":
                platform = PLATFORM.ANDROID;
                break;
        }

        switch (platform) {
            case ANDROID:
                System.out.println("=== LOCAL_ANDROID TESTING PLATFORM ===");
                app = new File(appDir, ANDROID_APP_NAME);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID_PLATFORM);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, ANDROID_DEVICE_NAME);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, ANDROID_AUTOMATION_NAME);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, ANDROID_PLATFORM_VERSION);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case IOS:
                System.out.println("=== LOCAL_IOS TESTING PLATFORM ===");
                app = new File(appDir, IOS_APP_NAME);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS_PLATFORM);
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, IOS_DEVICE_NAME);
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, IOS_AUTOMATION_NAME);
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, IOS_PLATFORM_VERSION);
                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
                driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public enum PLATFORM {
        ANDROID,
        IOS
    }
}
