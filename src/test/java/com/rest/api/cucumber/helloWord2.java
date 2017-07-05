package com.rest.api.cucumber;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by jingbai on 7/6/17.
 */
public class helloWord2 {

    @Given("^the (\\d+)nd api is \"([^\"]*)\"$")
    public void the_nd_api_is(int arg1, String arg2) throws Throwable {
        System.out.println("just dummy for 2nd feature.");
    }

    @When("^b user setup a get request to \"([^\"]*)\"$")
    public void b_user_setup_a_get_request_to(String arg1) throws Throwable {
        System.out.println("just dummy for 2nd feature.");
    }

    @When("^send the request$")
    public void send_the_request() throws Throwable {
        System.out.println("just dummy for 2nd feature.");
    }

    @Then("^the response code is (\\d+)$")
    public void the_response_code_is(int arg1) throws Throwable {
        System.out.println("just dummy for 2nd feature.");
    }

    @Then("^I should see JSON response with pairs under the filtered \"([^\"]*)\" node$")
    public void I_should_see_JSON_response_with_pairs_under_the_filtered_node(String arg1, DataTable arg2) throws Throwable {
        System.out.println("just dummy for 2nd feature.");
    }

    @When("^b user setup a post request to \"([^\"]*)\" with below details$")
    public void b_user_setup_a_post_request_to_with_below_details(String arg1, DataTable arg2) throws Throwable {
        System.out.println("just dummy for 2nd feature.");
    }

    @When("^send the post request$")
    public void send_the_post_request() throws Throwable {
        System.out.println("just dummy for 2nd feature.");
    }
}
