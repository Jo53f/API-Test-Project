package com.sparta.runner;

import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/sparta/steps",
        plugin = {
                "pretty",
                "html:target/testReport.html",
                "json:target/testReport.json"
        },
        publish = true
)
public class CucumberRunnerTest {
}
