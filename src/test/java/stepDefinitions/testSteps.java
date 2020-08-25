package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Assert;

import basePackage.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import testSupport.EndPoint;
import testSupport.SupportFiles;

public class testSteps {

	private BaseClass baseClass = new BaseClass();

	private Logger log = Logger.getLogger(testSteps.class.getName());

	@Given("I setup baseUri")
	public void i_setup_base_uri() {
		baseClass.setBaseUri(System.getenv("BASE_URI"));
		baseClass.setRequestHeaders(baseClass);
	}

	@Given("I enter the endpoint")
	public void i_enter_the_endpoint() {
		baseClass.setEndPoint(EndPoint.booksEndpoint);
	}

	@Given("I enter the endpoint for purchase")
	public void i_enter_the_endpoint_for_purchase() {
		
		baseClass.setEndPoint(EndPoint.purchaseOrder);
		baseClass.setPathParams("orderId", 1);
	}
	
	@When("I perform get operation")
	public void i_perform_get_operation() {
		baseClass.performGet();
	}

	@Then("I get the response")
	public void i_get_the_response() {
		JsonPath jsonPath = baseClass.getJsonResponse();

		log.debug("First book's website is: " + jsonPath.getString("books[0].website"));
	}

	@Then("I get status code as {int}")
	public void i_get_status_code_as(Integer int1) {
		Assert.assertEquals(baseClass.getResponseCode(), 200);
		log.info("Status code verified successfully");
	}

	@Given("I create the request payload")
	public void i_create_the_request_payload() {
		// Write code here that turns the phrase above into concrete actions
		baseClass.loadRequestPayload(SupportFiles.requestPayloadFile);
	}
}
