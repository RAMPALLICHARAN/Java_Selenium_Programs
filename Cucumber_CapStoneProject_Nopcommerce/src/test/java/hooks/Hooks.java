package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.getDriver(); // Launch driver before each scenario
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(); // Close driver after each scenario
    }
}
