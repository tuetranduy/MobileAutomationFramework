package testcases;

import org.testng.annotations.Test;

public class SampleTestCase extends BaseTest {

    @Test
    public void test() {
        homeScreenPage.tapOnLoginScreenTextView();
    }
}
