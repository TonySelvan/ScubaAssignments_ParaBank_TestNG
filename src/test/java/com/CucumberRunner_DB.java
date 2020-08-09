package com;

import com.maveric.core.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features/",
        tags = "@parabankwithDB",
        glue = "com.maveric.scuba.tests.parabank"
)
public class CucumberRunner_DB extends CucumberBaseTest {


}
