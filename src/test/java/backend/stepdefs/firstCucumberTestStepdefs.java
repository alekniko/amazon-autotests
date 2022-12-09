package backend.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class firstCucumberTestStepdefs {
    int alexApplesCount;
    int olgaApplesCount;
    int total;

    @Given("Alex has {int} apples")
    public void alexHasApples(int count) {
        System.out.println("!!!!!!");
        alexApplesCount = count;
    }

    @Given("Olga has {int} apples")
    public void olgaHasApples(int count) {
        olgaApplesCount = count;
    }

    @When("they are putting all apples together")
    public void theyArePuttingAllApplesTogether() {
        total = alexApplesCount + olgaApplesCount;
    }

    @Then("they have {int} apples together")
    public void theyHaveApplesTogether(int expectedTotal) {
        Assertions.assertEquals(expectedTotal, total, "Incorrect total count");
    }
}
