package agilepartner.java.bowling;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:ScoreCalculationFeature.feature" }, glue = { "agilepartner.java.bowling" })
public class ScoreCalculationFeature {

}