import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "summery"},
        features = {"src/test/features"},
        glue = {"package ru.netology.ibank.steps"})
public class RunCucumberTest {

}
