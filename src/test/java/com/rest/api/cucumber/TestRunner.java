package com.rest.api.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by jingbai on 7/4/17.
 */

@RunWith(Cucumber.class)
@Cucumber.Options (
        format ={"pretty","html:target/html/"},
        features = "src/test/resource",
        glue = { "com.rest.api.cucumber"}
)
public class TestRunner {
}
