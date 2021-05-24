package testcases;

import listeners.TestExecutionListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestExecutionListener.class)
public class SampleTestCase extends BaseTest {

    @Test
    public void test() {
        homeScreenPage.tapOnLoginScreenTextView();
    }
}
