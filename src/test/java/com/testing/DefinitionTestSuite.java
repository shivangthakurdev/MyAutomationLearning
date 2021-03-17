package com.testing;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "test/cucumber/",glue = "com.testing/steps")
public class DefinitionTestSuite {


}
