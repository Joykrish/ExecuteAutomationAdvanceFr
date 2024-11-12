package com.ea.test.Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/com/ea/test/Features/"},glue ={"com/ea/test/Steps"})
public class TestRunner {

    

}
