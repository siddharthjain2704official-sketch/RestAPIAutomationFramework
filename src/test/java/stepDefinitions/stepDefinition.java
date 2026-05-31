package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.testDataBuild;
import resources.utils;

public class stepDefinition extends utils {
	RequestSpecification req;
	ResponseSpecification respSpec;
	Response res;
	String resp;
	static String placeId;
	testDataBuild data = new testDataBuild();

	@Given("Add Place API Payload {string} {string} {string}")
	public void add_place_api_payload(String name, String language, String address) throws IOException {

		req = given().spec(addPlaceAPIRequestSpecification()).body(data.requestTestData(name, language, address));
		System.out.println("This message is Just for Testing");
		System.out.println("This message is Just for Testing pull feature");
		System.out.println("This message is to test branch");

	}

	@When("user Calls {string} api with {string} https request")
	public void user_calls_api_with_https_request(String resource, String httpMethod) {
		APIResources pathParameter = APIResources.valueOf(resource);
		pathParameter.getResource();
		respSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		if (httpMethod.equalsIgnoreCase("POST")) {
			res = req.when().post(pathParameter.getResource()).then().extract().response();

		} else if (httpMethod.equalsIgnoreCase("GET")) {
			res = req.when().get(pathParameter.getResource()).then().extract().response();

		}
	}

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(int1.intValue(), res.getStatusCode());
	}

	@Then("{string} in response body {string}")
	public void in_response_body(String key, String value) {
		// Write code here that turns the phrase above into concrete actions

		assertEquals(getJsonPath(res, key), value);

	}

	@Then("verify {string} on hitting {string} API")
	public void verify_on_hitting_api(String ExpectedName, String resource) throws IOException {
		// Write code here that turns the phrase above into concrete actions
		placeId = getJsonPath(res, "place_id");
		req = given().spec(addPlaceAPIRequestSpecification()).queryParam("place_id", placeId);
		user_calls_api_with_https_request(resource, "GET");
		String actualName = getJsonPath(res, "name");
		assertEquals(actualName, ExpectedName);
	}

	@Given("DeletePlace API Payload")
	public void delete_place_api_payload() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		req = given().spec(addPlaceAPIRequestSpecification()).body(data.DeleteAPIPayload(placeId));
	}

}
