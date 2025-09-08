package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        // Browser setup
        DriverFactory.getDriver();
    }

    @After
    public void tearDown() {
        // Close browser after each scenario
        DriverFactory.quitDriver();
    }
}
