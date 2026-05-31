package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@deletePlace")
	public void beforeScenario() throws IOException {
		stepDefinition m = new stepDefinition();
		if(stepDefinition.placeId==null) {
		m.add_place_api_payload("Akshay", "English", "Kundlapur");		
		m.user_calls_api_with_https_request("AddPlace", "POST");
		m.verify_on_hitting_api("Akshay", "getPlace");
		}
	}
}
