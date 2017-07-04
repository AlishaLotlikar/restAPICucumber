package com.rest.api.cucumber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

/**
 * Created by jingbai on 7/4/17.
 */
public class helloWord {

    String url;
    Response response;
    //ResponseHolder responseHolder;
    Map<String, String> query;
    Map<String, Object> responseMap;
    Map<String, String> postBody;


    @Given("^the api is \"([^\"]*)\"$")
    public void the_apis_are_up_and_running_for(String url) throws Throwable {
       this.url = url;

    }

    @When("^a user setup a get request to \"([^\"]*)\"$")
    public void a_user_performs_a_get_request_to(String path) throws Throwable {
        this.url = this.url + path;
    }

    @When("^perform the request$")
    public void perform_the_request() throws Throwable {

        System.out.println("URL is " + this.url + query);
        if (query == null)
        {
            response = given()
                    .accept(ContentType.JSON)
                    .when()
                    .get(this.url);
        }
        else
        {
            response = given()
                    .accept(ContentType.JSON)
                    .when()
                    .get(this.url);
        }

        //ResponseHolder.setResponse(response);

        //System.out.println(response.asString());
        //System.out.println(responseHolder.getResponseBody());

    }

    @Then("^the response code should be (\\d+)$")
    public void the_response_code_should_be(int code) throws Throwable {

        /*response = (Response) given()
                .accept(ContentType.JSON)
                .when()
                .get(url); */
        //System.out.println("response code is " + response.getStatusCode() );

        Assert.assertEquals(code, response.getStatusCode());
        //Assert.assertEquals(code, ResponseHolder.getResponseCode());


    }

    @Then("^I should see JSON response with pairs on the filtered \"([^\"]*)\" node$")
    public void I_should_see_JSON_response_with_pairs_on_the_filtered_node(String filter, DataTable dataTable) throws Throwable {

        Map<String, String> pair = new LinkedHashMap<String, String>();
        for (DataTableRow row : dataTable.getGherkinRows()) {
            pair.put(row.getCells().get(0), row.getCells().get(1));
        }

        /*for (Map.Entry entry : pair.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }*/


        ObjectReader reader = new ObjectMapper().reader(Map.class);

        responseMap = reader.readValue(response.asString());

        //System.out.println(responseMap);

        responseMap = (Map<String, Object>) responseMap.get(filter);

        //System.out.println(responseMap);

        for (String key: pair.keySet()) {
            Assert.assertTrue(responseMap.containsKey(key));
            Assert.assertEquals(pair.get(key), responseMap.get(key).toString());
        }

    }

    @When("^a user setup a post request to \"([^\"]*)\" with below details$")
    public void a_user_setup_a_post_request_to_with_below_details(String path, DataTable dataTable) throws Throwable {
        this.url = this.url + path;
        System.out.println(this.url);

        this.postBody = new LinkedHashMap<String, String>();
        for (DataTableRow row : dataTable.getGherkinRows()) {
            this.postBody.put(row.getCells().get(0), row.getCells().get(1));
        }
    }

    @When("^perform the post request$")
    public void perform_the_post_request() throws Throwable {
        response = given()
                .contentType(ContentType.JSON)
                .body(this.postBody)
                .when()
                .post(this.url);

    }

}
