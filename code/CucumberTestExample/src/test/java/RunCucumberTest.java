import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

import java.sql.SQLOutput;

@RunWith(Cucumber.class) @CucumberOptions(
        features ="src/test/java/features/search.feature",
        glue = {"steps"},
        plugin= {
                "pretty","html:test-outout",
                "json:json_output/cucumber.json",
                "junit:junit_xml/cucumber.xml"
        },
        dryRun = true,
        strict = true,
        monochrome = true )
public class RunCucumberTest extends AbstractTestNGCucumberTests{

}